package com.dark.graduations.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LessonMapper {

    int getMargin(String LessonId);

    void updateMargin(String LessonId, int Margin);
}
