package com.dark.graduations.pojo;

/**
 * 选课表
 */
public class Order {
    //选课订单ID
    private String OrderId;

    //选课订单－学号
    private String StuId;

    //选课订单－课程ID
    private String LessonId;

    //学生成绩
    private Float Grade;

    /**
     * 测试所用
     * @return  返回选课订单
     */
    @Override
    public String toString() {
        return "Order{" +
                "OrderId='" + OrderId + '\'' +
                ", StuId='" + StuId + '\'' +
                ", LessonId='" + LessonId + '\'' +
                ", Grade=" + Grade +
                '}';
    }
}
