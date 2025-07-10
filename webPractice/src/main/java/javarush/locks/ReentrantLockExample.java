package javarush.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private static int counter = 0;
    private  static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new ConcurrentTask());
            threads[i].start();


            }
        for(Thread thread : threads) {
            thread.join();
        }
        System.out.println(counter);
    }

    static class ConcurrentTask implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try{
                for (int i = 0; i < 1000; i++) {
                    counter++;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
