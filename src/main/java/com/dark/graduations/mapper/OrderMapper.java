package com.dark.graduations.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OrderMapper {

    void addOrder(String OrderId, String stuId, String lessonId);

    void deleteorder(String orderId);
}
