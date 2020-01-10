package com.dark.graduations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


//排除DataSource自动配置类，否则会默认自动配置，不会使用自定义的DataSource，并且启动报错循环引用
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class GraduationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraduationsApplication.class, args);
    }

}
