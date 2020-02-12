package com.dark.graduations.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.dark.graduations.dto.MenusDto;
import com.dark.graduations.mapper.AdminMapper;
import com.dark.graduations.mapper.StudentMapper;
import com.dark.graduations.pojo.Student;
import com.dark.graduations.pojo.Teacher;
import com.dark.graduations.service.AdminService;
import com.dark.graduations.service.TokenService;
import com.dark.graduations.vo.Menus;
import com.dark.graduations.vo.ResultVO;
import com.dark.graduations.dto.ResultVOUtil;
import com.dark.graduations.vo.TeacherLoginResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class AdminServiceimpl implements AdminService {

    private AdminMapper adminMapper;

    private StudentMapper studentMapper;

    private TokenService tokenService;

    @Autowired
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Autowired
    public void setTokenService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    /**
     * 登陆逻辑处理
     * @param username 管理员用户名
     * @param password 密码
     * @return  返回封装好登陆结果
     */
    @Override
    public ResultVO AdminLogin(String username, String password) {
        Teacher user = adminMapper.querryByAdminAcount(username);
        //查询不到对象，即该用户不存在
        if (user == null) {
            return ResultVOUtil.error("帐号不存在", 500);
        } else if (!password.equals(user.getTeaPwd())) {
            //密码错误
            return ResultVOUtil.error("密码错误", 500);
        }
        TeacherLoginResult result = new TeacherLoginResult(user, tokenService.getToken(user.getTeaId(), user.getTeaPwd()));
        return ResultVOUtil.success(result, "登陆成功");
    }

    @Override
    public ResultVO Menus(String username) {
        Integer rid = adminMapper.querryByAdminAcount(username).getTeaRid();
        List<Menus> result = MenusDto.buildMenus();
        ResultVO resultVO = ResultVOUtil.success("获取成功");
        //0：教师　１：管理员　２:超级管理员
        if (rid == 2) {
            resultVO.setData(result);
        } else if (rid == 1) {
            result.get(0).getChildren().remove(0);
            resultVO.setData(result);
        } else if (rid == 0) {
            resultVO.setData(MenusDto.teacher());
        } else {
            return ResultVOUtil.error("获取失败", 500);
        }
        return resultVO;
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
        return ResultVOUtil.success(results, "获取成功");
    }

    @Override
    public ResultVO AddStudent(Student student) {
        int i = studentMapper.insert(student);
        if (i != 0) {
            return ResultVOUtil.success("插入成功");
        }
        return ResultVOUtil.error("插入失败", 500);
    }

    @Override
    public ResultVO UpdateStudent(Student student) {
        UpdateWrapper<Student> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("Stu_Id",student.getStuId());
        int update = studentMapper.update(student, updateWrapper);
        if (update != 0) {
            return ResultVOUtil.success("更新成功");
        }
        return ResultVOUtil.error("更新失败", 500);
    }

    @Override
    public ResultVO DeleteStudent(String StuId) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Stu_Id",StuId);
        int delete = studentMapper.delete(queryWrapper);
        if (delete != 0) {
            return ResultVOUtil.success("删除成功");
        }
        return ResultVOUtil.error("删除失败", 500);
    }
}
