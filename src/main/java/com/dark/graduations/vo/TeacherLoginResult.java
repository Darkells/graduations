package com.dark.graduations.vo;

import com.dark.graduations.pojo.Teacher;
import lombok.Data;

@Data
public class TeacherLoginResult {

    private String id;

    private Integer rid;

    private String name;

    private String mobile;

    private String email;

    private String token;

    public TeacherLoginResult(Teacher teacher, String token) {
        this.id = teacher.getTeaId();
        this.rid = teacher.getTeaRid();
        this.name = teacher.getTeaName();
        this.mobile = teacher.getTeaTel();
        this.email = teacher.getTeaEmail();
        this.token = token;
    }
}
