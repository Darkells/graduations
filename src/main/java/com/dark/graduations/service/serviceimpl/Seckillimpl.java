package com.dark.graduations.service.serviceimpl;

import com.dark.graduations.mapper.LessonMapper;
import com.dark.graduations.mapper.OrderMapper;
import com.dark.graduations.service.Seckill;
import com.dark.graduations.util.Lock.RedisLock;
import com.dark.graduations.util.datasource.CommonConstant;
import com.dark.graduations.util.datasource.TargetDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Seckillimpl implements Seckill {
    private static final int TIMEOUT = 10 * 1000; //超时时间

    @Autowired
    private RedisLock redisLock;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private LessonMapper lessonMapper;

    @TargetDataSource(CommonConstant.MASTER_DATASOURCE)
    @Override
    public void sekill(String StuId, String LessonId) {
        long time = System.currentTimeMillis() + TIMEOUT;

        if (!redisLock.lock(LessonId, String.valueOf(time))) {
            log.error("换个姿势试一试");
        }

        //课程余量
        int margin = lessonMapper.getMargin(LessonId);
        //获取选课余量大于0
        if (margin > 0) {
            margin -= 1;
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            lessonMapper.updateMargin(LessonId, margin);
        } else {
            log.error("秒杀接口-------课程余量不足");
        }
//        orderMapper.addOrder(StuId, LessonId);

        redisLock.unlock(LessonId, String.valueOf(time));
    }
}
