package com.brzyang.safepoint;

import java.util.Calendar;

/**
 * -XX:+SafepointTimeout
 * -XX:SafepointTimeoutDelay=3000
 * -XX:-PrintGC
 * -XX:+PrintSafepointStatistics
 * -XX:+UnlockDiagnosticVMOptions
 * -XX:+PrintFlagsFinal
 */
public class VmThreadCycle {
//    public static AtomicInteger num = new AtomicInteger(0);
    public volatile static int num = 0;
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()-> {
            for (int i = 0; i < 230000000; i++) {
//                num.getAndAdd(1);\
                num++;
            }
        };
        
        new Thread(runnable, "t1").start();
        new Thread(runnable, "t2").start();
        System.out.println(Calendar.getInstance().get(Calendar.SECOND) + " main gonna sleep");
        Thread.sleep(1000);
        
        // after runnable
        System.out.println(Calendar.getInstance().get(Calendar.SECOND) + " main wake up");
        System.out.println(Calendar.getInstance().get(Calendar.SECOND) + " print num:" + num);
        
    }
}
