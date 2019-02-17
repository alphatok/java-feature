package com.brzyang;

import com.brzyang.innerclz.OuterOfInnerClassTest.InnerOfInnerClassTest;
import com.sun.javafx.util.Logging;

import java.util.ArrayList;
import com.brzyang.unused.UnusedClassA;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("%s" + new Date());
        System.out.println( "Hello World!" );
        // jvm 不会加载 OuterOfInnerClassTest，如果反射区拿它的成员变量如何？
        System.out.printf("%s", new InnerOfInnerClassTest());

    }
}
