package com.dark.graduations.service.serviceimpl;

import com.dark.graduations.enums.ResultEnums;
import com.dark.graduations.mapper.LessonMapper;
import com.dark.graduations.mapper.OrderMapper;
import com.dark.graduations.mapper.StudentMapper;
import com.dark.graduations.pojo.Student;
import com.dark.graduations.service.StudentService;
import com.dark.graduations.vo.ResultVO;
import com.dark.graduations.vo.ResultVOUtil;
import com.dark.graduations.vo.StudentLessonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {
    private StudentMapper studentMapper;

    private OrderMapper orderMapper;

    private LessonMapper lessonMapper;

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Autowired
    public void setLessonMapper(LessonMapper lessonMapper) {
        this.lessonMapper = lessonMapper;
    }


    /**
     * 学生网页登陆
     * @param StuId　学号
     * @param StuPwd　密码
     * @return
     */
    @Override
    public ResultVO StudentLogin(String StuId, String StuPwd) {
        String password = studentMapper.querryByStuId(StuId);
        if (password == null) {
            return ResultVOUtil.error(ResultEnums.LOGIN_ACCOUNT.toMap());
        } else if (!password.equals(StuPwd)) {
            return ResultVOUtil.error(ResultEnums.LOGIN_PASSWORD.toMap());
        }
        return ResultVOUtil.success();
    }


    /**
     * 微信登陆
     * @param OpenId openid
     * @return
     */
    @Override
    public ResultVO WechatLogin(String OpenId) {
        Student student = studentMapper.querryByOpenId(OpenId);

        if (student == null) {
            return ResultVOUtil.error(ResultEnums.LOGIN_ACCOUNT.toMap());
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO StudentWechat(String StuId, String StuPwd,String OpenId) {
        String password = studentMapper.querryByStuId(StuId);
        if (password == null) {
            return ResultVOUtil.error(ResultEnums.LOGIN_ACCOUNT.toMap());
        } else if (!password.equals(StuPwd)) {
            return ResultVOUtil.error(ResultEnums.LOGIN_PASSWORD.toMap());
        }
        studentMapper.studentWechat(StuId, OpenId);
        return ResultVOUtil.success();
    }

    /**
     * 取消选课
     * @param StuId 学号
     * @param LessonId 课程id
     * @return  取消结果
     */
    @Override
    public ResultVO QuiteLesson(String StuId, String LessonId) {
        /*
          取消选课：
          1、消除oders表里对应的数据
          2、对应的课程容量+1
         */
        String OrderId = orderMapper.getOrder(StuId, LessonId);

        if (OrderId == null) {
            return ResultVOUtil.error(ResultEnums.EMPTY_ORDER.toMap());
        }

        //删除orders表内对应的数据
        orderMapper.deleteOrder(OrderId);

        int margin = lessonMapper.getMargin(LessonId) + 1;

        lessonMapper.updateMargin(LessonId, margin);

        return ResultVOUtil.success();
    }

    /**
     * 学生选课信息
     * @param StuId 学号
     * @return  所有选课
     */
    @Override
    public List<StudentLessonInfo> InfoLesson(String StuId) {

        return studentMapper.querryAll(StuId);
    }

    /**
     * 获取选课信息
     * @return 所有选课信息
     */
    @Override
    public List<StudentLessonInfo> LessonList() {
        return lessonMapper.querryLessoninfo();
    }

    @Override
    public ResultVO UpdateInfo(Student student) {
        studentMapper.updateInfo(student);
        return ResultVOUtil.success();
    }
}
