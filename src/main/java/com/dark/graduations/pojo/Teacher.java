package com.dark.graduations.pojo;


import lombok.Data;

@Data
public class Teacher {
    private String TeaId;

    private String TeaDept;

    private String TeaName;

    private String TeaSex;

    private String TeaTel;

    private String TeaTile;

    private String TeaPwd;


    /**
     * 测试用
     * @return
     */
    @Override
    public String toString() {
        return "Teacher{" +
                "TeaId='" + TeaId + '\'' +
                ", TeaDept='" + TeaDept + '\'' +
                ", TeaName='" + TeaName + '\'' +
                ", TeaSex='" + TeaSex + '\'' +
                ", TeaTel='" + TeaTel + '\'' +
                ", TeaTile='" + TeaTile + '\'' +
                ", TeaPwd='" + TeaPwd + '\'' +
                '}';
    }
}
