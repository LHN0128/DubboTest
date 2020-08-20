package com.example.provider.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import service.HelloService;

@Service(loadbalance = "random")//这里使用dubbo的service注解,将这个类发布为服务,loadbalance指定负载均衡方法random默认。
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "8081: Hello "+name;
    }
}
