package com.dark.graduations.service.serviceimpl;

import com.dark.graduations.enums.ResultEnums;
import com.dark.graduations.mapper.AdminMapper;
import com.dark.graduations.service.AdminService;
import com.dark.graduations.vo.ResultVO;
import com.dark.graduations.vo.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceimpl implements AdminService {

    private AdminMapper adminMapper;

    @Autowired
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    /**
     * 登陆逻辑处理
     * @param username 管理员用户名
     * @param password 密码
     * @return  返回封装好登陆结果
     */
    @Override
    public ResultVO AdminLogin(String username, String password) {
        String AdminPwd = adminMapper.querryByAdminAcount(username);
        if (AdminPwd == null) {
            return ResultVOUtil.error(ResultEnums.LOGIN_ACCOUNT.toMap());
        } else if (!password.equals(AdminPwd)) {
            return ResultVOUtil.error(ResultEnums.LOGIN_PASSWORD.toMap());
        }
        return ResultVOUtil.success();
    }
}
