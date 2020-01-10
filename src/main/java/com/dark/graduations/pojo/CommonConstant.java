package com.dark.graduations.pojo;

import lombok.Data;

@Data
public class CommonConstant {
    /**
     * 主数据源
     */
    public static final String MASTER_DATASOURCE = "masterDruidDataSource";

    /**
     * 从数据源
     */
    public static final String SLAVE_DATASOURCE= "slaveDruidDataSource";
}
