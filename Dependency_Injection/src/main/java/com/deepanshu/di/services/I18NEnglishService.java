package com.deepanshu.di.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"EN","default"})
@Service("I18NService")
public class I18NEnglishService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello-World- EN";
    }
}
