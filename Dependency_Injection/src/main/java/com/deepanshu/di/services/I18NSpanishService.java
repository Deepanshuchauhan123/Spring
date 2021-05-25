package com.deepanshu.di.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("SP")
@Service("I18NService")
public class I18NSpanishService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hola- SPanish";
    }

}
