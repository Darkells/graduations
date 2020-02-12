package com.dark.graduations.controller;

import com.dark.graduations.enums.ResultEnums;
import com.dark.graduations.pojo.Student;
import com.dark.graduations.service.StudentService;
import com.dark.graduations.util.Openid;
import com.dark.graduations.util.token.TokenUtil;
import com.dark.graduations.util.token.UserLoginToken;
import com.dark.graduations.vo.ResultVO;
import com.dark.graduations.dto.ResultVOUtil;
import com.dark.graduations.vo.StudentLessonInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
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
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultVO Login(@RequestParam(value = "username") String StuId,@RequestParam(value = "password") String StuPwd) {
        return studentService.StudentLogin(StuId, StuPwd);
    }

    /**
     * 学生微信小程序端登陆
     * @param code 微信小程序获取用户标识所用
     * @return  返回登陆结果
     */
    @RequestMapping(value = "wechatlogin", method = RequestMethod.GET)
    public ResultVO WechatLogin(String code) {
        /*
        依据小程序传来的token获取对应的openid,依据openid和用户绑定的信息对比
         */
        if (code.isEmpty()) {
           return ResultVOUtil.error(ResultEnums.CODE_NULL.toString(), 500);
        }
        String[] result = Openid.getopenid(code);
//        log.info("session_key :" + session_key + " openid:"+ openid);
        //返回微信登陆接口结果
        return studentService.WechatLogin(result[1]);
    }

    @RequestMapping(value = "studentwechat", method = RequestMethod.POST)
    public ResultVO StudentWechat(String StuId, String StuPwd, String code) {
        /*
        依据小程序传来的token获取对应的openid
         */
        if (code.isEmpty()) {
            return ResultVOUtil.error(ResultEnums.CODE_NULL.toString(), 500);
        }
        String[] result = Openid.getopenid(code);
        return studentService.StudentWechat(StuId, StuPwd, result[1]);
    }

    /**
     * 获取选课列表
     * @return  返回选课列表
     */
    @RequestMapping(value = "lessonlist")
    public ResultVO LessonList() {
        List<StudentLessonInfo> lessonInfos = studentService.LessonList();
        return ResultVOUtil.success(lessonInfos, "获取成功");
    }

    /**
     * 学生自主修改相关信息
     * @param student   学生实体类
     * @return  返回修改结果
     */
    @RequestMapping(value = "infoupdate")
    public ResultVO InfoUpdate(Student student) {
        return studentService.UpdateInfo(student);
    }

    @RequestMapping(value = "quitelesson")
    public ResultVO quite(String StuId, String LessonId) {
        return studentService.QuiteLesson(StuId, LessonId);
    }


    /***
     * 这个请求需要验证token才能访问
     * @return String 返回类型
     */
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        // 取出token中带的用户id 进行操作
        log.info(TokenUtil.getTokenUserId());
        return "你已通过验证";
    }
}
