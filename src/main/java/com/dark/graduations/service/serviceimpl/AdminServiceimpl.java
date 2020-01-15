package com.dark.graduations.service.serviceimpl;

import com.dark.graduations.enums.ResultEnums;
import com.dark.graduations.mapper.AdminMapper;
import com.dark.graduations.pojo.Admin;
import com.dark.graduations.service.AdminService;
import com.dark.graduations.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceimpl implements AdminService {

    private AdminMapper adminMapper;

    @Autowired
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }


    @Override
    public JsonResult AdminLogin(Admin admin) {
        String password = adminMapper.querryByAdminId(admin.getAdminId());
        JsonResult jsonResult = JsonResult.build(200, ResultEnums.LOGIN_SUCCESS.toString(), "响应成功");
        if (password == null) {
            jsonResult.setData(ResultEnums.LOGIN_ACCOUNT.toString());
        } else if (!password.equals(admin.getAdminPwd())) {
            jsonResult.setData(ResultEnums.LOGIN_PASSWORD.toString());
        } else {
            jsonResult.setData(ResultEnums.LOGIN_SUCCESS.toString());
        }
        return jsonResult;
    }
}
