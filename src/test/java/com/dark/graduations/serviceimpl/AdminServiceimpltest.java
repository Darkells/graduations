package com.dark.graduations.serviceimpl;


import com.dark.graduations.pojo.Admin;
import com.dark.graduations.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AdminServiceimpltest {
    @Autowired
    private AdminService adminService;

    /**
     * 管理员登陆测试
     */
    @Test
    public void logintest() {
        Admin admin = new Admin();
        admin.setAdminId("1");
        admin.setAdminPwd("123456");
//        log.info(adminService.AdminLogin(admin).toString());
    }
}
