package com.dark.graduations.controller;

import com.dark.graduations.pojo.Lesson;
import com.dark.graduations.pojo.Student;
import com.dark.graduations.pojo.Teacher;
import com.dark.graduations.service.AdminService;
import com.dark.graduations.util.token.TokenUtil;
import com.dark.graduations.util.token.UserLoginToken;
import com.dark.graduations.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    private AdminService adminService;

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * 管理员登陆控制
     * @param username 管理员帐号
     * @param password 管理员密码
     * @return  登陆相关信息
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultVO Login(@RequestParam(value = "username")String username, @RequestParam(value = "password") String password) {
        return adminService.AdminLogin(username, password);
    }

    /**
     * 获取左侧方的菜单
     * 从请求头中的token获取userid,查询对于的权限，返回对应的菜单
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "menus", method = RequestMethod.GET)
    public ResultVO Menus() {
        String userId = TokenUtil.getTokenUserId();
        log.info(userId);
        return adminService.Menus(userId);
    }

    //这部分内容方便测试，所有数据应该从校方同步过来
    /**
     * 学生信息列表
     * @return 所有学生信息
     */
    @RequestMapping("students")
    public ResultVO StudentList() {
        return adminService.StudentList();
    }

    /**
     * 添加学生信息
     * @param student   封装的学生的实体类
     * @return  添加结果
     */
    @RequestMapping("/students/add")
    public ResultVO StudentAdd(Student student) {
        return adminService.AddStudent(student);
    }

    /**
     * 更新学生信息
     * @param student   封装的学生实体类
     * @return  更新结果
     */
    @RequestMapping("/students/update")
    public ResultVO StudentUpdate(Student student) {
        return adminService.UpdateStudent(student);
    }

    /**
     * 删除学生
     * @param StuId     学号
     * @return  删除结果
     */
    @RequestMapping("/students/delete")
    public ResultVO StudentDelete(String StuId) {
        return adminService.DeleteStudent(StuId);
    }

    /**
     * 教师信息列表
     * @return  返回教师信息列表
     */
    @RequestMapping("teachers")
    public ResultVO TeacherList() {
        return null;
    }

    /**
     * 添加教师
     * @param teacher   封装教师实体类
     * @return  返回添加教师的结果
     */
    @RequestMapping("teachers/add")
    public ResultVO TeacherAdd(Teacher teacher) {
        log.info(teacher.toString());
        return null;
    }

    /**
     * 更新教师信息
     * @param teacher   封装教师实体类
     * @return  返回更新教师信息结果
     */
    @RequestMapping("teachers/update")
    public ResultVO TeacherUpdate(Teacher teacher) {
        log.info(teacher.toString());
        return null;
    }

    /**
     * 删除教师
     * @param TeaId     教师工号
     * @return  返回删除教师结果
     */
    @RequestMapping("teachers/delete")
    public ResultVO TeacherUpdate(String TeaId) {
        log.info(TeaId);
        return null;
    }



    /**
     * 课程列表
     * @return  返回课程列表
     */
    @RequestMapping("lessons")
    public ResultVO LessonList() {
        return null;
    }

    /**
     * 添加课程
     * @param lesson 添加的课程实体
     * @return  返回添加结果
     */
    @RequestMapping("lessons/add")
    public ResultVO LessonAdd(Lesson lesson) {
        log.info(lesson.toString());
        return null;
    }

    /**
     * 删除课程
     * @param LessonId 课程号
     * @return  返回删除结果
     */
    @RequestMapping("lessons/delete")
    public ResultVO LessonDelete(String LessonId) {
        log.info(LessonId);
        return null;
    }

    /**
     * 修改课程信息
     * @param lesson    修改课程实体
     * @return  返回修改结果
     */
    @RequestMapping("lessons/update")
    public ResultVO LessonUpdate(Lesson lesson) {
        log.info(lesson.toString());
        return null;
    }

    /**
     * 单个课程的详细信息
     * @param LessonId  课程号
     * @return  返回指定课程的详细信息
     */
    @RequestMapping("lessons/select")
    public ResultVO LessonSelect(String LessonId) {
        log.info(LessonId);
        return null;
    }




}
