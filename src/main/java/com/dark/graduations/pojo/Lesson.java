package com.dark.graduations.pojo;


import lombok.Data;

import java.io.Serializable;

/**
 * 课程类
 * 课程具体信息
 */
@Data
public class Lesson implements Serializable {
    private String LessonId;

    private String LessonName;

    private String LessonTime;

    private String LessonLocal;

    private Integer LessonMargin;

    private String TeaId;

    private String LessonType;

    private String LessonDesc;


    @Override
    public String toString() {
        return "Lesson{" +
                "LessonId='" + LessonId + '\'' +
                ", LessonName='" + LessonName + '\'' +
                ", LessonTime='" + LessonTime + '\'' +
                ", LessonLocal='" + LessonLocal + '\'' +
                ", LessonMargin=" + LessonMargin +
                ", TeaId='" + TeaId + '\'' +
                ", LessonType='" + LessonType + '\'' +
                ", LessonDesc='" + LessonDesc + '\'' +
                '}';
    }
}
