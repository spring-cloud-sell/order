package com.cczhilie.edu.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author: GZC
 * @create: 2020-04-10 13:28
 * @description:
 **/

public interface StreamClient {

    String INPUT = "myMessage";

    String OUTPUT = "myMessage";

    String INPUT2 = "myMessage2";

    String OUTPUT2 = "myMessage2";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();

    @Input(StreamClient.INPUT2)
    SubscribableChannel input2();

    @Output(StreamClient.OUTPUT2)
    MessageChannel output2();

}
