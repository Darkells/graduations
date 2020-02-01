package com.dark.graduations.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.dark.graduations.enums.ResultEnums;
import com.dark.graduations.mapper.AdminMapper;
import com.dark.graduations.mapper.StudentMapper;
import com.dark.graduations.pojo.Student;
import com.dark.graduations.service.AdminService;
import com.dark.graduations.vo.ResultVO;
import com.dark.graduations.vo.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AdminServiceimpl implements AdminService {

    private AdminMapper adminMapper;

    private StudentMapper studentMapper;

    @Autowired
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
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

    /**
     * 获取学生列表
     * @return  所有学生信息
     */
    @Override
    public ResultVO StudentList(){
        //使用xml配置文件
        List<Student> result = adminMapper.querryAllStudent();
        List<Student> results = studentMapper.selectList(null);
        return ResultVOUtil.success(results);
    }

    @Override
    public ResultVO AddStudent(Student student) {
        int i = studentMapper.insert(student);
        if (i != 0) {
            return ResultVOUtil.success("插入成功");
        }
        return ResultVOUtil.error("插入失败");
    }

    @Override
    public ResultVO UpdateStudent(Student student) {
        UpdateWrapper<Student> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("Stu_Id",student.getStuId());
        int update = studentMapper.update(student, updateWrapper);
        if (update != 0) {
            return ResultVOUtil.success("更新成功");
        }
        return ResultVOUtil.error("更新失败");
    }

    @Override
    public ResultVO DeleteStudent(String StuId) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Stu_Id",StuId);
        int delete = studentMapper.delete(queryWrapper);
        if (delete != 0) {
            return ResultVOUtil.success("删除成功");
        }
        return ResultVOUtil.error("删除失败");
    }
}
