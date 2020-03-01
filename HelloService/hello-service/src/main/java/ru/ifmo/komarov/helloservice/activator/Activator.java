package ru.ifmo.komarov.helloservice.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
    public void start(BundleContext bundleContext) {
        System.out.println("Start HelloService bundle");
    }

    public void stop(BundleContext bundleContext) {
        System.out.println("Stop HelloService bundle");
    }
}