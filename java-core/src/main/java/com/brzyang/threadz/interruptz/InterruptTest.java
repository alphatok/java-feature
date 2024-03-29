package com.brzyang.threadz.interruptz;

public class InterruptTest {
    //这里用来打印消耗的时间
    private static long time = 0;
    private static void resetTime(){
        time = System.currentTimeMillis();
    }
    
    private static void printContent(String content){
        System.out.println(content + " 时间：" + (System.currentTimeMillis() - time));
    }
    
    public static void main(String[] args) {
        test1();
    }
    
    private static void test1(){
        Thread1 thread1 = new Thread1();
        thread1.start();
        //延时3秒后interrupt中断
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        thread1.interrupt();
        printContent("执行中断");
    }
    
    private static class Thread1 extends Thread{
        @Override public void run() {
            resetTime();
            int num = 0;
            
            while (true){
                if(isInterrupted()){
                    printContent("当前线程 isInterrupted=true");
                    break;
                }
                num++;
                
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    // false
                    printContent("醒来后 isInterrupted= " + isInterrupted());
                    e.printStackTrace();
                }
                
                if(num % 100 == 0){
                    printContent("num : " + num);
                }
            }
        }
        
    }
}
