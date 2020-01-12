package com.dark.graduations.service;

import com.dark.graduations.pojo.Admin;
import com.dark.graduations.vo.JsonResult;

public interface AdminService {
    JsonResult AdminLogin(Admin admin);
}
