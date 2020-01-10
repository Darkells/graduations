package com.dark.graduations.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


/**
 * 管理员相关信息
 */
@Data
public class Admin {
    @TableId(value = "Admin_Id", type = IdType.INPUT)
    private String AdminId;

    private String AdminName;

    private String AdminSex;

    private String AdminTel;

    private String AdminAcount;

    private String AdminPwd;

    @Override
    public String toString() {
        return "Admin{" +
                "AdminId='" + AdminId + '\'' +
                ", AdminName='" + AdminName + '\'' +
                ", AdminSex='" + AdminSex + '\'' +
                ", AdminTel='" + AdminTel + '\'' +
                ", AdminAccount='" + AdminAcount + '\'' +
                ", AdminPwd='" + AdminPwd + '\'' +
                '}';
    }
}
