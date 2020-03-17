package ru.ifmo.komarov.hellocomand.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import osgi.enroute.debug.api.Debug;
import ru.ifmo.komarov.hellocomand.HelloCommand;
import ru.ifmo.komarov.helloservice.HelloService;

@Component(property = {
        Debug.COMMAND_SCOPE + "=practice",
        Debug.COMMAND_FUNCTION + "=helloTest"
})
public class HelloCommandImpl implements HelloCommand {

//    @Activate
//    protected void onActivate() {
//        System.out.println("hello-command activated.");
//    }
//
//    @Deactivate
//    protected void onDeactivate() {
//        System.out.println("hello-command deactivated.");
//    }

    @Override
    public void helloTest(String param) {
        System.out.println(String.format("Hello, %s.", param));
        hello.sayHello();
    }

    @Reference
    private HelloService hello;

    @Override
    public void helloTest() {
        System.out.println("Hello, stranger.");
    }
}
