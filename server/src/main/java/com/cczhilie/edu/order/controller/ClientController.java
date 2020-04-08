package com.cczhilie.edu.order.controller;

import com.cczhilie.edu.product.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductClient productClient;

//    @GetMapping("/getProductMessage")
//    public String getMsg(){
        //1.第一种方式(直接使用restTemplate ,url写死)
//        RestTemplate restTemplate = new RestTemplate();
//        String restTemplateForObject = restTemplate.getForObject("http://localhost:8080/getMsg", String.class);
//        log.info("url={}", url);
//        String restTemplateForObject = restTemplate.getForObject(url, String.class);

        //2.第二种方式(使用LoadBalancerClient通过应用名获取url)
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort() + "/getMsg");
//        log.info("url={}", url);
//        String restTemplateForObject = restTemplate.getForObject(url, String.class);

        //3.第三种方式(使用注解 @LoadBalanced,可以直接使用应用的名字调用服务)
//        String response = restTemplate.getForObject("http://PRODUCT/getMsg", String.class);

        //4.使用feign
//        String response = productClient.getProductGMsg();

//        log.info("response={}", response);
//        return response;
//    }

//    @GetMapping("/getProductList")
//    public String getProductList(){
//        List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("157875196366160022", "157875227953464068"));
//        log.info("productInfoList={}",productInfoList);
//        return "ok";
//    }
//
//    @GetMapping("/decreaseProductStock")
//    public String decreaseProductStock(){
//        productClient.decreaseStock(Arrays.asList(new CartDTO("157875196366160022",3),new CartDTO("157875227953464068",5)));
//        return "ok";
//    }
}
