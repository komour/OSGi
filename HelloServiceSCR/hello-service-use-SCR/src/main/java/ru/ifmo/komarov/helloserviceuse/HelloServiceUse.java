package ru.ifmo.komarov.helloserviceuse;

import org.osgi.service.component.annotations.*;
import ru.ifmo.komarov.helloservice.HelloService;

@Component
public class HelloServiceUse {

    @Reference
    private HelloService hello;

    @Activate
    void onActivate() {
        hello.sayHello();
    }

    @Deactivate
    void goodbye() {
        System.out.println("Bye Bye!");
    }

}
