package com.dark.graduations.controller;

import com.dark.graduations.mapper.LessonMapper;
import com.dark.graduations.service.Seckill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dark")
@Slf4j
public class ScekillController {

    @Autowired
    private Seckill seckill;

    @Autowired
    private LessonMapper lessonMapper;

    @RequestMapping("/seckill")
    public String seckill(@RequestParam("StuId") String StuId, @RequestParam("LessonId") String LessonId) {
        seckill.sekill(StuId, LessonId);
        return "课程余量为------" + lessonMapper.getMargin(LessonId);
    }
}
