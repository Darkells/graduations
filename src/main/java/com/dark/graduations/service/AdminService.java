package com.dark.graduations.service;

import com.dark.graduations.vo.ResultVO;

public interface AdminService {
    ResultVO AdminLogin(String username, String password);
}
