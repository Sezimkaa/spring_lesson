package com.example;

public class Dog implements Pet {
  @Override
    public void say(){
        System.out.println("Gav");



    }
    public void init(){
        System.out.println("Class Dog: init method");
    }
    public void destroy(){
        System.out.println("Class Dog: destroy method");
    }
    public Dog(){
        System.out.println("Dog bean is created");
    }

}
