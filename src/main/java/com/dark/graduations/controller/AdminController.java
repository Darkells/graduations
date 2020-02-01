package com.dark.graduations.controller;

import com.dark.graduations.pojo.Lesson;
import com.dark.graduations.pojo.Student;
import com.dark.graduations.pojo.Teacher;
import com.dark.graduations.service.AdminService;
import com.dark.graduations.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dark/admin")
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
    public ResultVO Login(String username, String password) {
        return adminService.AdminLogin(username, password);
    }

    //这部分内容方便测试，所有数据应该从校方同步过来
    /**
     * 学生信息列表
     * @return 所有学生信息
     */
    @RequestMapping("studentlist")
    public ResultVO StudentList() {
        return adminService.StudentList();
    }

    /**
     * 添加学生信息
     * @param student   封装的学生的实体类
     * @return  添加结果
     */
    @RequestMapping("/studentlist/add")
    public ResultVO StudentAdd(Student student) {
        return adminService.AddStudent(student);
    }

    /**
     * 更新学生信息
     * @param student   封装的学生实体类
     * @return  更新结果
     */
    @RequestMapping("/studentlist/update")
    public ResultVO StudentUpdate(Student student) {
        return adminService.UpdateStudent(student);
    }

    /**
     * 删除学生
     * @param StuId     学号
     * @return  删除结果
     */
    @RequestMapping("/studentlist/delete")
    public ResultVO StudentDelete(String StuId) {
        return adminService.DeleteStudent(StuId);
    }

    /**
     * 教师信息列表
     * @return  返回教师信息列表
     */
    @RequestMapping("teacherlist")
    public ResultVO TeacherList() {
        return null;
    }

    /**
     * 添加教师
     * @param teacher   封装教师实体类
     * @return  返回添加教师的结果
     */
    @RequestMapping("teacherlist/add")
    public ResultVO TeacherAdd(Teacher teacher) {
        log.info(teacher.toString());
        return null;
    }

    /**
     * 更新教师信息
     * @param teacher   封装教师实体类
     * @return  返回更新教师信息结果
     */
    @RequestMapping("teacherlist/update")
    public ResultVO TeacherUpdate(Teacher teacher) {
        log.info(teacher.toString());
        return null;
    }

    /**
     * 删除教师
     * @param TeaId     教师工号
     * @return  返回删除教师结果
     */
    @RequestMapping("teacherlist/delete")
    public ResultVO TeacherUpdate(String TeaId) {
        log.info(TeaId);
        return null;
    }



    /**
     * 课程列表
     * @return  返回课程列表
     */
    @RequestMapping("lessonlist")
    public ResultVO LessonList() {
        return null;
    }

    /**
     * 添加课程
     * @param lesson 添加的课程实体
     * @return  返回添加结果
     */
    @RequestMapping("lessonlist/add")
    public ResultVO LessonAdd(Lesson lesson) {
        log.info(lesson.toString());
        return null;
    }

    /**
     * 删除课程
     * @param LessonId 课程号
     * @return  返回删除结果
     */
    @RequestMapping("lessonlist/delete")
    public ResultVO LessonDelete(String LessonId) {
        log.info(LessonId);
        return null;
    }

    /**
     * 修改课程信息
     * @param lesson    修改课程实体
     * @return  返回修改结果
     */
    @RequestMapping("lessonlist/update")
    public ResultVO LessonUpdate(Lesson lesson) {
        log.info(lesson.toString());
        return null;
    }

    /**
     * 单个课程的详细信息
     * @param LessonId  课程号
     * @return  返回指定课程的详细信息
     */
    @RequestMapping("lessonlist/select")
    public ResultVO LessonSelect(String LessonId) {
        log.info(LessonId);
        return null;
    }




}
