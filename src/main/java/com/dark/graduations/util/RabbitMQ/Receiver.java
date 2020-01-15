package com.dark.graduations.util.RabbitMQ;


import com.dark.graduations.exception.sellException;
import com.dark.graduations.mapper.LessonMapper;
import com.dark.graduations.mapper.OrderMapper;
import com.dark.graduations.util.KeyUtil;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 消息队列：消费消息出队列处理类
 */
@Component
@Slf4j
public class Receiver {

    private final String key = "lesson";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private LessonMapper lessonMapper;

    @Autowired
    private OrderMapper orderMapper;

    private int i = 0;

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiverDirectQueue(String msg, Channel channel, Message message) throws IOException {
        log.info(">>>>>>>>>>>>>>>>>接收到秒杀请求，商品ID为："+msg+"检查Redis中库存是否为0");
        try {
            int num = (int)redisTemplate.boundHashOps(key).get(msg);
            if(num <= 0) {
                throw new sellException(100, "课程余量不足");
            }
            log.info("接收时>>>>>>>>>>>"+ i++);
            //根据商品的id和库存同步数据到MySQL
            redisTemplate.boundHashOps(key).put(msg, num - 1);
            lessonMapper.updateMargin(msg, num - 1);
            orderMapper.addOrder(KeyUtil.genUniqueKey(), "2016044743004", msg);
        } catch (Exception e) {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            log.error(e.getMessage());
        }
    }


}
