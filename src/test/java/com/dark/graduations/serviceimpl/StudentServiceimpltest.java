package com.dark.graduations.serviceimpl;


import com.dark.graduations.pojo.Student;
import com.dark.graduations.service.StudentService;
import com.dark.graduations.vo.StudentLessonInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StudentServiceimpltest {
    @Autowired
    private StudentService studentService;


    @Test
    public void test() {
        Student student = new Student();
        student.setStuId("2016044743005");
        student.setStuPwd("123456");
        log.info(studentService.StudentLogin(student));
    }

    /**
     * 微信OpenId登陆测试
     */
    @Test
    public void testWechatLogin() {
        log.info(studentService.WechatLogin("o8sDm5XceZ4vnvCnerD"));
    }

    /**
     * 学生自我选课信息获取
     */
    @Test
    public void InfoLesson() {
        for (StudentLessonInfo studentLessonInfo : studentService.InfoLesson("2016044743004")) {
            log.info(studentLessonInfo.toString());
        }
    }

    /**
     * 学生取消选课api
     */
    @Test
    public void quiteLeeson() {
        studentService.QuiteLesson("1234567890123456","12345678901234");
    }
}
