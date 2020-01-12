package com.dark.graduations.controller;

import com.dark.graduations.pojo.Student;
import com.dark.graduations.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dark/student")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("login")
    public String Login(Student student) {
        return studentService.StudentLogin(student);
    }


}
