package com.brzyang.java8.intf;

public interface DefaultMethodInterface {
    default void defaultMethod(){
        System.out.println("default method in interface");
    }
}
