package com.dark.graduations.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 学生相关信息
 */
@Data
public class Student {
    //学号
    @TableId(value = "Stu_Id", type = IdType.INPUT)
    private String StuId;

    //学生专业
    private String StuMajor;

    //学生姓名
    private String StuName;

    //学生性别
    private String StuSex;

    //学生注册时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime StuRegister;

    //学生年级
    private String StuGrade;

    //学生密码
    private String StuPwd;

    /**
     * 测试所用
     * @return 返回学生实体类所有信息
     */
    @Override
    public String toString() {
        return "Student{" +
                "StuId='" + StuId + '\'' +
                ", StuMajor='" + StuMajor + '\'' +
                ", StuName='" + StuName + '\'' +
                ", StuSex='" + StuSex + '\'' +
                ", StuRegister='" + StuRegister + '\'' +
                ", StuGrade='" + StuGrade + '\'' +
                ", StuPwd='" + StuPwd + '\'' +
                '}';
    }
}
