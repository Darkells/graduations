package com.dark.graduations.service;

import com.dark.graduations.pojo.Lesson;

import java.util.List;

public interface Seckill {
    void sekill(String StuId, String LessonId);

    List<Lesson> findAll();
}
