package com.dark.graduations.util;


import com.dark.graduations.mapper.LessonMapper;
import com.dark.graduations.pojo.Lesson;
import com.dark.graduations.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
@Scope("singleton")
@Slf4j
public class ApplicationInitListener implements ApplicationListener<ContextRefreshedEvent> {

    private final String key = "lesson";

    private LessonMapper lessonMapper;

    @Autowired
    public void setLessonMapper(LessonMapper lessonMapper) {
        this.lessonMapper = lessonMapper;
    }

    private RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null) {
            log.info(">>>>>>>>>>>>项目初始化完成，执行监听器中逻辑");
            //mapper中的sql，返回全部上架（支持秒杀）的课程集合

            List result = redisTemplate.boundHashOps(key).values();
            if (result == null || result.size() == 0) {
                //缓存中没有课程数据
                //查询数据库，将数据库中的数据放入缓存中
                List<Lesson> lessonList = lessonMapper.querryAll();
                Iterator<Lesson> iterator = lessonList.iterator();
                while (iterator.hasNext()) {
                    Lesson lesson = iterator.next();
                    log.info("课程ID：" + lesson.getLessonId() + "课程余量：" + lesson.getLessonMargin());
                    try {
                        redisTemplate.boundHashOps(key).put(lesson.getLessonId(), lesson.getLessonMargin());
                    } catch (Exception e) {
                        log.error("当前课程ID：" + lesson.getLessonId() + "余量：" + lesson.getLessonMargin() + "放入Rdis缓存异常<<<<<<<");
                        log.error(e.getMessage());
                    }
                }
//                for (Lesson lesson : lessonList) {
//                    redisTemplate.boundHashOps(key).put(lesson.getLessonId(), lesson.getLessonMargin());
//                    log.info("findAll-->从数据库读取数据进缓存");
//                }
            } else {
                log.info("findAll-->从缓存中读取数据");
            }
        }
    }
}
