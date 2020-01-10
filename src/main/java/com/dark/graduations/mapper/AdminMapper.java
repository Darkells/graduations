package com.dark.graduations.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dark.graduations.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AdminMapper extends BaseMapper<Admin> {
}
