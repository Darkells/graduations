package com.dark.graduations.pojo;


import lombok.Data;

@Data
public class Teacher {
    private String TeaId;

    private Integer TeaRid;

    private String TeaDept;

    private String TeaName;

    private Integer TeaSex;

    private String TeaTel;

    private String TeaEmail;

    private String TeaTile;

    private String TeaPwd;


    @Override
    public String toString() {
        return "Teacher{" +
                "TeaId='" + TeaId + '\'' +
                ", TeaRid=" + TeaRid +
                ", TeaDept='" + TeaDept + '\'' +
                ", TeaName='" + TeaName + '\'' +
                ", TeaSex=" + TeaSex +
                ", TeaTel='" + TeaTel + '\'' +
                ", TeaMail='" + TeaEmail + '\'' +
                ", TeaTile='" + TeaTile + '\'' +
                ", TeaPwd='" + TeaPwd + '\'' +
                '}';
    }
}
