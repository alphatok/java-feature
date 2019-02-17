package com.brzyang.innerclz;

import com.brzyang.innerclz.OuterOfInnerClass.InnerOfInnerClass;


public class AppOfOuterOfInnerClass
{
    public static void main( String[] args )
    {
        // jvm 不会加载 OuterOfInnerClass，如果反射区拿它的成员变量如何？
        System.out.println("new InnerOfInnerClass() = " + new InnerOfInnerClass());
    }
}
