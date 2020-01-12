package com.dark.graduations.controller;

import com.dark.graduations.pojo.Admin;
import com.dark.graduations.service.AdminService;
import com.dark.graduations.vo.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dark/admin")
@Slf4j
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public JsonResult Login(Admin admin) {
        return adminService.AdminLogin(admin);
    }


}
