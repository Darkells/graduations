package com.dark.graduations.service;

import com.dark.graduations.pojo.Student;
import com.dark.graduations.vo.StudentLessonInfo;

import java.util.List;

public interface StudentService {
    //网页登陆接口
    String StudentLogin(Student student);

    //微信登陆接口
    String WechatLogin(String OpenId);

    //学生取消选课
    String QuiteLesson(String OrderId, String LessonId);

    //学生查看选课信息
    List<StudentLessonInfo> InfoLesson(String StuId);
}
