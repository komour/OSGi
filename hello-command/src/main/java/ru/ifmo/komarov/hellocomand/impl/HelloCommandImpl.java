package ru.ifmo.komarov.hellocomand.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Component;
import osgi.enroute.debug.api.Debug;
import ru.ifmo.komarov.hellocomand.HelloCommand;

@Component(property = {
        Debug.COMMAND_SCOPE + "=practice",
        Debug.COMMAND_FUNCTION + "=hello"
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
    public void hello(String param) {
        System.out.println(String.format("Hello, %s.", param));
    }

    @Override
    public void hello() {
        System.out.println("Hello, stranger.");
    }
}
