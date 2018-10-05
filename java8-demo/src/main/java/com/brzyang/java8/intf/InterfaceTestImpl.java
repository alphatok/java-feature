package com.brzyang.java8.intf;

public class InterfaceTestImpl implements InterfaceTest {
    @Override
    public void defaultMethod() {

    }

    @Override
    public void test() {

    }

    public static void main(String[] args) {
        InterfaceTest.defaultMethoatStatic();
        InterfaceTestImpl interfaceTest = new InterfaceTestImpl();
        interfaceTest.defaultMethod();
        interfaceTest.test();
        System.out.println(InterfaceTest.b);
    }
}
