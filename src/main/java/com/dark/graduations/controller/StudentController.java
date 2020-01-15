package com.dark.graduations.controller;

import com.dark.graduations.pojo.Student;
import com.dark.graduations.service.StudentService;
import com.dark.graduations.vo.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dark/student")
@Slf4j
public class StudentController {
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 学生登陆
     * @param StuId 学号
     * @param StuPwd    学生密码
     * @return  返回登陆结果
     */
    @RequestMapping("login")
    public String Login(String StuId, String StuPwd) {
        return studentService.StudentLogin(StuId, StuPwd);
    }

    /**
     * 学生微信小程序端登陆
     * @param token 微信小程序获取用户标识所用
     * @return  返回登陆结果
     */
    @RequestMapping(value = "wechatlogin")
    public JsonResult WechatLogin(String token) {
        /*
        依据小程序传来的token获取对应的openid,依据openid和用户绑定的信息对比
         */
        log.info(token);
        return null;
    }

    /**
     * 获取选课列表
     * @return  返回选课列表
     */
    @RequestMapping(value = "lessonlist")
    public JsonResult LessonList() {
        return null;
    }

    /**
     * 学生自主修改相关信息
     * @param student   学生实体类
     * @return  返回修改结果
     */
    @RequestMapping(value = "infoupdate")
    public JsonResult InfoUpdate(Student student) {
        log.info(student.toString());
        return null;
    }

}
