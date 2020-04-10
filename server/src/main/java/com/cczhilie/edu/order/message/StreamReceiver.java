package com.cczhilie.edu.order.message;

import com.cczhilie.edu.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author: GZC
 * @create: 2020-04-10 13:27
 * @description:
 **/
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

//    @StreamListener(value = StreamClient.INPUT)
//    public void process(Object msg){
//        log.info("StreamReceiver msg :{}",msg);
//    }

    @StreamListener(value = StreamClient.INPUT)
    @SendTo(StreamClient.INPUT2)
    public String process(OrderDTO msg){
        log.info("StreamReceiver msg :{}",msg);
        return "success";
    }

    @StreamListener(value = StreamClient.INPUT2)
    public void process2(String msg){
        log.info("INPUT2 msg :{}",msg);
    }

}
