package com.dark.graduations.vo;

import lombok.Data;

/**
 * 学生选课信息查询
 */
@Data
public class StudentLessonInfo {

    private String LessonId;

    private String LessonName;

    private String LessonTime;

    private String LessonLocal;

    private String LessonType;

    private String LessonDesc;

    private String TeaName;

    private String TeaSex;

    private String TeaTel;

    @Override
    public String toString() {
        return "StudentLessonInfo{" +
                "LessonId='" + LessonId + '\'' +
                ", LessonName='" + LessonName + '\'' +
                ", LessonTime='" + LessonTime + '\'' +
                ", LessonLocal='" + LessonLocal + '\'' +
                ", LessonType='" + LessonType + '\'' +
                ", LessonDesc='" + LessonDesc + '\'' +
                ", TeaName='" + TeaName + '\'' +
                ", TeaSex='" + TeaSex + '\'' +
                ", TeaTel='" + TeaTel + '\'' +
                '}';
    }
}
