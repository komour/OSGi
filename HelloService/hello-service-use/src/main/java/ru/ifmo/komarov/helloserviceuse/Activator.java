package ru.ifmo.komarov.helloserviceuse;

import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleActivator;

import ru.ifmo.komarov.helloservice.HelloService;
import ru.ifmo.komarov.helloservice.impl.HelloServiceImpl;

public class Activator implements BundleActivator {

    public void start(BundleContext context)
    {
        System.out.println("Start ServiceUse bundle");
        HelloService helloServiceObject = new HelloServiceImpl();
        helloServiceObject.sayHello();
    }

    public void stop(BundleContext context)
    {
        System.out.println("Stop ServiceUse bundle");
    }
}