package com.brzyang.java8.intf;

public class MultiInterfaceImpl implements DefaultMethodInterface,InterfaceTest {
    @Override
    public void test() {

    }

    @Override
    public void defaultMethod() {
        InterfaceTest.super.defaultMethod();
    }
}
