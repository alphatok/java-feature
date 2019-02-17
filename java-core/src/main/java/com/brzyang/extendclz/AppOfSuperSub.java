package com.brzyang.extendclz;

/**
 * Hello world!
 *
 */
public class AppOfSuperSub
{
    public static void main( String[] args )
    {
        // SubClass 不会被初始化
        System.out.println("SubClass.value = " + SubClass.value);
    }
}
