package com.brzyang.safepoint;

class SafePointTestx  {
    
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while(true){
                    new Object();
                }
            }
            
        }).start();
        
        new Thread(new SafePointTest()).start();
    }
    
    public static class SafePointTest implements Runnable{
        public void run() {
            long k = 0;
            System.out.println("开始执行");
            for(int j =0;j<100000;j++)
                for(long i = 0;i<200;i++){
                    k++;
                }
            System.out.println("执行结束");
            System.exit(0);
        }
    }
}


