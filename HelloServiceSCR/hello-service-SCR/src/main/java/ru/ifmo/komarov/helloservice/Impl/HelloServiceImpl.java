package ru.ifmo.komarov.helloservice.Impl;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Service;
import ru.ifmo.komarov.helloservice.HelloService;

@SuppressWarnings("deprecation")
@Component
@Service
public class HelloServiceImpl implements HelloService {
    public void sayHello() {
        System.out.println("Hello OSGi world!");
    }

    @Activate
    void open() {
        System.out.println("Start Hello-Service bundle");
    }

    @Deactivate
    void close() {
        System.out.println("Stop Hello-Service bundle");
    }
}