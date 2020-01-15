package com.dark.graduations.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


/**
 * 管理员相关信息
 */
@Data
public class Admin {
    //管理员Id
    @TableId(value = "Admin_Id", type = IdType.INPUT)
    private String AdminId;

    //管理员名字
    private String AdminName;

    //管理员性别
    private String AdminSex;

    //管理员电话
    private String AdminTel;

    //管理员帐号
    private String AdminAcount;

    //管理员密码
    private String AdminPwd;

    /**
     * 管理员类toString
     * @return  返回管理员所有信息
     */
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
