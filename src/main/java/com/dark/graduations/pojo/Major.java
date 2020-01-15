package com.dark.graduations.pojo;

import lombok.Data;

/**
 * 专业
 */
@Data
public class Major {

    //专业
    private String MajorId;

    //系ID
    private String DeptId;

    //专业名
    private String MajorName;

    //专业主任
    private String MajorAssistant;

    //专业介绍
    private String MajorDesc;
}
