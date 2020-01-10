package com.dark.graduations.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dark.graduations.pojo.Student;
import com.dark.graduations.vo.StudentLessonInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentMapper extends BaseMapper<Student> {
    //登陆验证
    String querryByStuId(String StuId);

    //微信小程序端登陆验证
    Student querryByOpenId(String OpenId);

    //获取学生已经选课信息
    List<StudentLessonInfo> querryAll(String StuId);
}
