package com.cczhilie.edu.order.message;

import com.cczhilie.edu.order.server.OrderApplicationTests;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;


public class MqReceiverTest extends OrderApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void process() {

//        rabbitTemplate.convertAndSend("myQueue", "time:" + System.currentTimeMillis());

        rabbitTemplate.convertAndSend("myOrder","fruit", "time:" + System.currentTimeMillis());

        rabbitTemplate.convertAndSend("myOrder","computer", "time:" + System.currentTimeMillis());
    }
}