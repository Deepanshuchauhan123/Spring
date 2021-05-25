package com.deepanshu.di.controller;

import com.deepanshu.di.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello()
    {
        System.out.println(greetingService.sayGreeting());
        return "Hello Deepanshu!";
    }
}
