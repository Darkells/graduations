package com.dark.graduations.service;

import com.dark.graduations.pojo.Student;
import com.dark.graduations.vo.ResultVO;
import com.dark.graduations.vo.StudentLessonInfo;

import java.util.List;

public interface StudentService {
    //网页登陆接口
    ResultVO StudentLogin(String StuId, String StuPwd);

    //微信登陆接口
    ResultVO WechatLogin(String OpenId);

    //绑定微信
    ResultVO StudentWechat(String StuId, String StuPwd,String OpenId);

    //学生取消选课
    ResultVO QuiteLesson(String OrderId, String LessonId);

    //学生查看选课信息
    List<StudentLessonInfo> InfoLesson(String StuId);

    //选课列表
    List<StudentLessonInfo> LessonList();

    //学生更新信息
    ResultVO UpdateInfo(Student student);
}
