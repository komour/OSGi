package ru.ifmo.komarov.hellocomand.impl;

import org.apache.felix.scr.annotations.*;
import ru.ifmo.komarov.hellocomand.HelloCommand;

@SuppressWarnings("deprecation")
@Component
@Service
@Properties({
        @Property(name = "osgi.command.scope", value = "practice"),
        @Property(name = "osgi.command.function", value = "hello")
})
public class HelloCommandImpl implements HelloCommand {

//    @Activate
//    protected void onActivate() {
//        System.out.println("hello-command activated.");
//    }

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
