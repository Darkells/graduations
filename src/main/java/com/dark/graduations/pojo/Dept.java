package com.dark.graduations.pojo;

import lombok.Data;

/**
 * 专业（院系）
 */
@Data
public class Dept {

    //系ID
    private String DeptId;

    //系名
    private String DeptName;

    //系主任
    private String DeptChairman;

    //系介绍
    private String DeptDesc;
}
