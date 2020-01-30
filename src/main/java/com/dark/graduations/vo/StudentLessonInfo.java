package com.dark.graduations.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 学生选课信息查询
 */
@Data
public class StudentLessonInfo {

    @JsonProperty("id")
    private String LessonId;

    @JsonProperty("name")
    private String LessonName;

    @JsonProperty("time")
    private String LessonTime;

    @JsonProperty("local")
    private String LessonLocal;

    @JsonProperty("type")
    private String LessonType;

    @JsonProperty("desc")
    private String LessonDesc;

    @JsonProperty("teaname")
    private String TeaName;

    @JsonProperty("sex")
    private String TeaSex;

    @JsonProperty("tel")
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
