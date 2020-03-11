package ru.ifmo.komarov.helloserviceuse;

import org.apache.felix.scr.annotations.*;
import ru.ifmo.komarov.helloservice.HelloService;

@SuppressWarnings("deprecation")
@Component
public class HelloServiceUse {

    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY, policyOption = ReferencePolicyOption.GREEDY)
    private HelloService hello;

    @Activate
    void onActivate() {
        hello.sayHello();
    }

    @Deactivate
    void goodbye() {
        System.out.println("Bye Bye!");
        ;
    }

}
