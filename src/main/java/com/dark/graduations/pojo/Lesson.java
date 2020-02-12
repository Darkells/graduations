package com.dark.graduations.pojo;


import lombok.Data;

import java.io.Serializable;

/**
 * 课程类
 * 课程具体信息
 */
@Data
public class Lesson implements Serializable {

    //课程ID
    private String LessonId;

    //课程状态
    private Integer LessonRid;

    //课程名
    private String LessonName;

    //上课时间
    private String LessonTime;

    //上课地点
    private String LessonLocal;

    //课程余量
    private Integer LessonMargin;

    //教师ID
    private String TeaId;

    //课程所属院系
    private String LessonType;

    //课程介绍
    private String LessonDesc;


    /**
     * 课程类所有信息
     * @return  返回课程所有信息
     */
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
