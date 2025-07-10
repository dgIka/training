package javarush.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private static int counter = 0;
    private static ReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        Thread thread = new Thread(new WriteTask());
        Thread thread1 = new Thread(new ReadTask());
        Thread thread2 = new Thread(new ReadTask());

        thread.start();
        thread1.start();
        thread2.start();
        try{
            thread.join();
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class WriteTask implements Runnable {
        @Override
        public void run() {
            lock.writeLock().lock();
            try{
                System.out.println("Запись данных");
                counter++;
                Thread.sleep(1000);
                System.out.println("Данные записаны: " + counter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.writeLock().unlock();
            }
        }
    }
    static class ReadTask implements Runnable {
        @Override
        public void run() {
            lock.readLock().lock();
            try{
                System.out.println("Чтение данных: " + counter);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.readLock().unlock();
            }
        }
    }
}
