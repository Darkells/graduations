package com.dark.graduations.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void test() {
        log.info(studentMapper.selectById("2016044743001").toString());
    }

    @Test
    public void querryAlltest() {
        log.info(studentMapper.querryAll("2016044743004").toString());
    }
}
