package ru.ifmo.komarov.helloservice.Impl;


import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import ru.ifmo.komarov.helloservice.HelloService;

@Component
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