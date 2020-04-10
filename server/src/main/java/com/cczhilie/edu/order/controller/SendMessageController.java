package com.cczhilie.edu.order.controller;

import com.cczhilie.edu.order.dto.OrderDTO;
import com.cczhilie.edu.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: GZC
 * @create: 2020-04-10 13:34
 * @description:
 **/
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;


//    @GetMapping("/sendMessage")
//    public void process(){
//        streamClient.output().send(MessageBuilder.withPayload("now" + System.currentTimeMillis()).build());
//    }

    @GetMapping("/sendMessage")
    public void process(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("564984984");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
