package com.dark.graduations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CountDownLatch;

@SpringBootTest(classes = GraduationsApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SekillRemote {
    RestTemplate rest = new RestTemplate();


    //设置并发量
    private static final int nums = 500;

    private static CountDownLatch cdl = new CountDownLatch(nums);

    private final String url = "http://localhost:8080/dark/seckill?StuId=2016044743004&LessonId=12345678901234";

    @Test
    public void TestSekill() throws Exception {
        for (int i = 0; i < nums; i++) {
            new Thread(new Skeill()).start();
            cdl.countDown();
        }
        Thread.currentThread().sleep(2000);
    }

    public class Skeill implements Runnable {
        @Override
        public void run() {
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String str = rest.getForEntity(url, String.class).getBody();
        }
    }
}
