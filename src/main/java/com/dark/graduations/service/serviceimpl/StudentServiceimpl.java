package com.dark.graduations.service.serviceimpl;

import com.dark.graduations.mapper.LessonMapper;
import com.dark.graduations.mapper.OrderMapper;
import com.dark.graduations.mapper.StudentMapper;
import com.dark.graduations.pojo.Student;
import com.dark.graduations.service.StudentService;
import com.dark.graduations.vo.StudentLessonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private LessonMapper lessonMapper;


    @Override
    public String StudentLogin(Student student) {
        String password = studentMapper.querryByStuId(student.getStuId());
        if (password == null) {
            return "帐号不存在";
        } else if (!password.equals(student.getStuPwd())) {
            return "密码错误";
        }

        return "登陆成功";
    }

    @Override
    public String WechatLogin(String OpenId) {
        Student student = studentMapper.querryByOpenId(OpenId);
        if (student == null) {
            return "登陆失败";
        }

        return "登陆成功";
    }

    /**
     * 取消选课
     * @param OrderId 选课id
     * @param LessonId 课程id
     * @return
     */
    @Override
    public String QuiteLesson(String OrderId, String LessonId) {
        /**
         * 取消选课：
         * 1、消除oders表里对应的数据
         * 2、对应的课程容量+1
         */
        //删除orders表内对应的数据
        orderMapper.deleteorder(OrderId);

        int margin = lessonMapper.getMargin(LessonId) + 1;

        lessonMapper.updateMargin(LessonId, margin);

        return null;
    }

    /**
     * 学生选课信息
     * @param StuId 学号
     * @return
     */
    @Override
    public List<StudentLessonInfo> InfoLesson(String StuId) {
        List<StudentLessonInfo> lessonList = studentMapper.querryAll(StuId);

        return lessonList;
    }
}
