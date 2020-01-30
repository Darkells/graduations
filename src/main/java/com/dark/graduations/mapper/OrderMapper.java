package com.dark.graduations.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OrderMapper {

    void addOrder(String OrderId, String StuId, String LessonId);

    void deleteOrder(String OrderId);

    String getOrder(String StuId, String LessonId);

}
