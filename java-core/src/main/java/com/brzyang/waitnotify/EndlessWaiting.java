package com.brzyang.waitnotify;

/**
 * https://blog.csdn.net/z69183787/article/details/88319623
 * lock.wait会释放锁，超时之后 需要重新抢
 */
public class EndlessWaiting {
    
    public static void main(String[] args) throws InterruptedException {
        
        Object lock = new Object();
        Thread threadA = new Thread(new RunA(lock));
        threadA.start();
//        threadA.wait();
        Thread.sleep(1000);
        
        Thread threadB = new Thread(new RunB(lock));
        threadB.start();
    }
    
    
    public static class RunA implements Runnable {
        
        private final Object lock;
        
        public RunA(Object lock) {
            this.lock = lock;
        }
        
        @Override
        public void run() {
            
            synchronized (lock){
                try  {
                    System.out.println("A begin");
                    // lock.wait(); // 永远等待着，不会执行下去
                    lock.wait(2000);// 会释放锁，等待了 2 秒之后，继续执行下去
                    // 还需要抢Monitor锁，虽然已经位于锁内，
                    System.out.println("A end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static class RunB implements Runnable {
        private final Object lock;
        public RunB(Object lock) {
            this.lock = lock;
        }
        
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("b come");
                while (true) {
                }
            }
        }
    }
}
