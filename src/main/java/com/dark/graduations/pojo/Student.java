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
    @TableId(value = "Stu_Id", type = IdType.INPUT)
    private String StuId;

    private String StuMajor;

    private String StuName;

    private String StuSex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime StuRegister;

    private String StuGrade;

    private String StuPwd;

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
