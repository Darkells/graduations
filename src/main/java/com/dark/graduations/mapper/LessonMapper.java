package com.dark.graduations.mapper;

import com.dark.graduations.pojo.Lesson;
import com.dark.graduations.vo.StudentLessonInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface LessonMapper {

    int getMargin(String LessonId);

    void updateMargin(String LessonId, int Margin);

    List<Lesson> querryAll();

    List<StudentLessonInfo> querryLessoninfo();
}
