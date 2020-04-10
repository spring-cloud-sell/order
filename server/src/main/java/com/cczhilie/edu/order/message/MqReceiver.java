package com.cczhilie.edu.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: GZC
 * @create: 2020-04-09 18:31
 * @description:
 **/
@Component
@Slf4j
public class MqReceiver {

    //1.@RabbitListener(queues = "myQueue")
    //2.自动创建queue
//    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //3.自动创建queue和exchange
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String msg){
        log.info("MqReceiver message is :{}", msg);
    }

    /**
     * 数码
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")

    ))
    public void computerProcess(String msg){
        log.info("computerProcess message is :{}", msg);
    }


    /**
     * 水果
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")

    ))
    public void fruitProcess(String msg){
        log.info("fruit message is :{}", msg);
    }

}
