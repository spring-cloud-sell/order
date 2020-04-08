package com.cczhilie.edu.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by HH on 2020/4/8.
 */
@RestController
@Slf4j
public class ClientController {


    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/getProductMessage")
    public String getMsg(){
        //1.第一种方式
//        RestTemplate restTemplate = new RestTemplate();
//        String restTemplateForObject = restTemplate.getForObject("http://localhost:8080/getMsg", String.class);

        //2.第二种方式
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort() + "/getMsg");
        log.info("url={}", url);
        String restTemplateForObject = restTemplate.getForObject(url, String.class);
        log.info("response={}", restTemplateForObject);
        return restTemplateForObject;
    }
}
