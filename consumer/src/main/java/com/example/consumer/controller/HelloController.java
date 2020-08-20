package com.example.consumer.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.HelloService;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @DubboReference//订阅zookeeper的注册中心，用来查找服务。@Reference注解已经弃用
    private HelloService helloService;


    /**
      *  @Author Liu Haonan
      *  @Date 2020/8/19 18:36
      *  @Description 虽然consumer拷贝了接口，但是最终仍然调用provider中的方法
      *               一个项目调用另一个项目的接口，两个项目也不在一个容器中
     *                可见dubbo是一个网络技术。
      */
    @RequestMapping("/sayHello")
    @ResponseBody //返回字符串到前端
    public String sayHello(String name){
        return helloService.sayHello(name);
    }
}
