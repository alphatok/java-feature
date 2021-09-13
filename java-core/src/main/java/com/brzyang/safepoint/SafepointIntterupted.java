package com.brzyang.safepoint;

import java.time.Duration;
import java.time.Instant;

/**
 * 只有open jdk11，jdk8不是这样
 * -Xlog:jit+compilation=debug:file=jit_compile%t.log:uptime,level,tags:filecount=10,filesize=100M
 * -XX:+UseCountedLoopSafepoints
 * -Xlog:safepoint=trace:stdout:utctime,level,tags
 * https://juejin.cn/post/6854573211968143373
 */
public class SafepointIntterupted {
    static int algorithm(int n) {
        int bestSoFar = 0;
        int i;
        for (i = 0; i < n; ++i) {
            if (Thread.interrupted()) {
                System.out.println("broken by interrupted");
                break;
            }
            //增加pow计算，增加计算量，防止循环执行不超过1s就结束了
            bestSoFar = (int) Math.pow(i, 0.3);
        }
        System.out.println("bestSoFar " + bestSoFar + " i: " + i);
        return bestSoFar;
    }
    
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            Instant start = Instant.now();
            int bestSoFar = algorithm(1000000000);
            double durationInMillis = Duration.between(start, Instant.now()).toMillis();
            System.out.println("after "+durationInMillis+" ms, the result is "+bestSoFar);
        };
        
        //延迟1ms之后interrupt
        Thread t = new Thread(task);
        t.start();
        Thread.sleep(1);
        t.interrupt();

        //延迟10ms之后interrupt
        t = new Thread(task);
        t.start();
        Thread.sleep(10);
        t.interrupt();
        
        //延迟100ms之后interrupt
        t = new Thread(task);
        t.start();
        Thread.sleep(100);
        t.interrupt();
 
        //延迟1s之后interrupt
        //这时候 algorithm 里面的for循环调用次数应该足够了，会发生代码即时编译优化并 OSR
        t = new Thread(task);
        t.start();
        Thread.sleep(100000);
        //发现线程这次不会对 interrupt 有反应了( JIT OSR替换）
        t.interrupt();
    }
}
