package com.dark.graduations.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dark.graduations.pojo.Admin;
import com.dark.graduations.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AdminMapper extends BaseMapper<Admin> {

    String querryByAdminAcount(String username);

    List<Student> querryAllStudent();
}
