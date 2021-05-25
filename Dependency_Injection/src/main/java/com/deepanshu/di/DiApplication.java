package com.deepanshu.di;

import com.deepanshu.di.controller.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DiApplication.class, args);

        MyController controller = (MyController) ctx.getBean("myController");

        System.out.println(controller.sayHello());

        System.out.println("---------property");

        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("-----------Setter");

        SetterInjectedController setterInjectedController = (SetterInjectedController)ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());


        System.out.println("----------Constructor");

        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

        I18NController i18NController = (I18NController) ctx.getBean("i18NController");
        System.out.println(i18NController.sayHello());
    }

}
