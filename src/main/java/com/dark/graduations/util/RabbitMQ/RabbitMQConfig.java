package com.dark.graduations.util.RabbitMQ;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    static final String QUEUE = "Lesson_secondsKill";

    /**
     * Direct模式
     */
    @Bean
    public Queue directQueue() {

        //参数　第一个是队列名字，第二个是是否开启持久化
        return new Queue(QUEUE, true);
    }
}
