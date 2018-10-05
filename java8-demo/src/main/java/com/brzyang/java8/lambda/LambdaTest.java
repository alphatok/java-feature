package com.brzyang.java8.lambda;

import java.util.Arrays;

public class LambdaTest {

    interface LambdaInterfaceZeroArg{
        void test();
    }

    interface LambdaInterface{
        void test(int a);
    }


    public static void main(String[] args) {
        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);

        {
            LambdaInterface li = System.out::println;
            li.test(2);
        }

        {
            LambdaInterface li = a->System.out.println(a);
            li.test(2);
        }

        {
            LambdaInterfaceZeroArg li = ()->System.out.println("zero agrs");
            li.test();
        }
    }
}
