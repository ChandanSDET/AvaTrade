package com.demo;

import java.util.Objects;

public class SingletonDemo {
    private static volatile SingletonDemo instance;

    private SingletonDemo(){}

    public static SingletonDemo getInstance(){
        if(Objects.isNull(instance)){
            synchronized (SingletonDemo.class) {
                if(Objects.isNull(instance)) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
