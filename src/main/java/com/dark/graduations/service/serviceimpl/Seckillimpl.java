package com.dark.graduations.service.serviceimpl;

import com.dark.graduations.exception.sellException;
import com.dark.graduations.mapper.LessonMapper;
import com.dark.graduations.mapper.OrderMapper;
import com.dark.graduations.pojo.Lesson;
import com.dark.graduations.service.Seckill;
import com.dark.graduations.util.KeyUtil;
import com.dark.graduations.util.Lock.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Slf4j
public class Seckillimpl implements Seckill {
    private static final int TIMEOUT = 10 * 1000; //超时时间

    private final String key = "lesson";

    @Autowired
    private RedisLock redisLock;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private LessonMapper lessonMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public List<Lesson> findAll() {
        List<Lesson> lessonList = redisTemplate.boundHashOps(key).values();
        if (lessonList == null || lessonList.size() == 0) {
            //说明缓存中没有课程数据
            //查询数据库，将数据库中的数据放入缓存中
            lessonList = lessonMapper.querryAll();
            for (Lesson lesson : lessonList) {
                redisTemplate.boundHashOps(key).put(lesson.getLessonId(), lesson);
                log.info("findAll --> 从数据库读取数据进缓存");
            }
        } else {
            log.info("findAdd --> 从缓存中读取数据");
        }

        return lessonList;
    }

    @Override
    @Transactional

    public void sekill(String StuId, String LessonId) {

        long time = System.currentTimeMillis() + TIMEOUT;

        try {
            //加分布式锁
            if (!redisLock.lock(LessonId, String.valueOf(time))) {
                throw new sellException(101, "换个姿势试一试");
            }

            Lesson lesson = (Lesson) redisTemplate.boundHashOps(key).get(LessonId);
            int margin = lesson.getLessonMargin();
            if (margin == 0) {
                throw new sellException(100, "课程余量不足");
            } else {
                lesson.setLessonMargin(margin - 1);
                redisTemplate.boundHashOps(key).put(LessonId, lesson);
                lessonMapper.updateMargin(LessonId, margin - 1);
                orderMapper.addOrder(KeyUtil.genUniqueKey(), StuId, LessonId);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            redisLock.unlock(LessonId, String.valueOf(time));
        }




//        try {
//            if (!redisLock.lock(LessonId, String.valueOf(time))) {
//                throw new sellException(101,"换个姿势试一试");
//            }
//            //课程余量
//            int margin = lessonMapper.getMargin(LessonId);
//
//            if (margin == 0) {
//                throw new sellException(100, "课程余量不足");
//            } else {
//                orderMapper.addOrder(KeyUtil.genUniqueKey(),StuId, LessonId);
//                margin = margin - 1;
//                lessonMapper.updateMargin(LessonId,margin);
//            }
//        } catch (Exception e) {
//            log.info(e.getMessage());
//        } finally {
//            redisLock.unlock(LessonId, String.valueOf(time));
//        }
    }
}
