package com.brzyang.bytes;

import com.javamex.classmexer.MemoryUtil;

import java.lang.instrument.Instrumentation;

/**
 * todo https://blog.csdn.net/liuyueyi25/article/details/104896455
 * https://www.javamex.com/classmexer/
 * -javaagent:"F:\repo\classmexer\classmexer\0.03\classmexer-0.03.jar"
 */
public class ClassmexerTest {
    
    /**
     * jvm 参数形式启动，运行此方法
     *
     * @param agentArgs
     * @param inst
     */
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("premain");
    }
    
    /**
     * 动态 attach 方式启动，运行此方法
     *
     * @param agentArgs
     * @param inst
     */
    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("agentmain");
    }
    
    //
    public static void main(String[] args) {
        String str = "Some string or other";
        long noBytes = MemoryUtil.deepMemoryUsageOf(str);
        System.out.println(noBytes);
    }
}
