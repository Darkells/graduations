package com.dark.graduations.util.RabbitMQ;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 消息队列：消费消息入队列处理类
 */
@Component
@Slf4j
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private int i = 0;

    public void sendDirectQueue(String msg) {
        log.info(">>>>>>>>>>>>>>秒杀请求已发送，商品ID为："+msg);
        try {
            //第一个参数是指要发送到哪个队列里面， 第二个参数是指要发送的内容
            amqpTemplate.convertAndSend(RabbitMQConfig.QUEUE, msg);
            //此处为了记录并发请求下，请求的次数及消息传递的次数
            log.info("发送请求>>>>>>>>>>>>>"+i++);
        } catch (AmqpException e) {
            log.error("请求发送异常："+e.getMessage());
        }
    }
}
