package com.dark.graduations.util.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;



@Configuration
@Slf4j
public class DynamicDataSourceConfig {
    /**
     * 创建 TargetDataSource Bean
     */
    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterDataSource() {
        DataSource dataSource = DruidDataSourceBuilder.create().build();
        return dataSource;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave")
    public DataSource slaveDataSource() {
        DataSource dataSource = DruidDataSourceBuilder.create().build();
        return dataSource;
    }

    /**
     * 如果还有数据源,在这继续添加 TargetDataSource Bean
     */

    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource masterDataSource, DataSource slaveDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(2);
        targetDataSources.put(CommonConstant.MASTER_DATASOURCE, masterDataSource);
        targetDataSources.put(CommonConstant.SLAVE_DATASOURCE, slaveDataSource);
        // 还有数据源,在targetDataSources中继续添加
//        log.info("^o^= DataSources:" + targetDataSources);
        //默认的数据源是oneDataSource
        return new DynamicDataSource(masterDataSource, targetDataSources);
    }
}
