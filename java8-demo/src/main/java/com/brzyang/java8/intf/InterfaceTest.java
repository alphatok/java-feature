package com.brzyang.java8.intf;

public interface InterfaceTest {
    int a = 5;
    static int b = 5;
    default void defaultMethod(){
        System.out.println("default method in interface");
    }

    static void defaultMethoatStatic(){
        System.out.println("default method in interface");
    }

    void test();
}
