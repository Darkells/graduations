package com.dark.graduations.controller;

import com.dark.graduations.mapper.LessonMapper;
import com.dark.graduations.pojo.Lesson;
import com.dark.graduations.service.Seckill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dark")
@Slf4j
public class ScekillController {

    @Autowired
    private Seckill seckill;

    @Autowired
    private LessonMapper lessonMapper;

    @RequestMapping("/findAll")
    public String findAll() {
//        List<Lesson> lessonList = seckill.findAll();
//        if (lessonList == null || lessonList.size() == 0) {
//            return "没有库存";
//        }
        seckill.findAll();
        return "初始化成功";
    }

    @RequestMapping("/delete")
    public String delete() {
        seckill.clearAll();
        return "删除缓存";
    }

    @RequestMapping("/seckill")
    public String seckill(@RequestParam("StuId") String StuId, @RequestParam("LessonId") String LessonId) {
        seckill.sekill(StuId, LessonId);
        return "课程余量为------" + lessonMapper.getMargin(LessonId);
    }


}
