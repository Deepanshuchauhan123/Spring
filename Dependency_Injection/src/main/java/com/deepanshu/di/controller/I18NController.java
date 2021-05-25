package com.deepanshu.di.controller;

import com.deepanshu.di.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


@Controller
public class I18NController {

private final GreetingService greetingService;

    public I18NController(@Qualifier("I18NService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello()
    {
        return greetingService.sayGreeting();
    }

}
