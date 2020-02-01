package com.dark.graduations.service;

import com.dark.graduations.pojo.Student;
import com.dark.graduations.vo.ResultVO;

public interface AdminService {
    ResultVO AdminLogin(String username, String password);

    //学生CURD
    ResultVO StudentList();

    ResultVO AddStudent(Student student);

    ResultVO UpdateStudent(Student student);

    ResultVO DeleteStudent(String StuId);
}
