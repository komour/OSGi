package ru.ifmo.komarov.helloservice.impl;

import ru.ifmo.komarov.helloservice.HelloService;

public class HelloServiceImpl implements HelloService {
    public void sayHello() {
        System.out.println("Hello OSGi world!");
    }
}