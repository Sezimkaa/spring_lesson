package com.example.component;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application_context4.xml");
        Cat cat = context.getBean("catBean++" +
                "" +  "", Cat.class);
        cat.say();
        context.close();
    }
}
