package javarush.concurrent.synchronizers;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static Semaphore semaphore = new Semaphore(2);
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int threadId = i;
            new Thread(() -> {
                try{
                    System.out.println("Поток " + threadId + " ожидает доступ к ресурсу");
                    semaphore.acquire();
                    System.out.println("Поток " + threadId + " получил доступ к ресурсу");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Поток " + threadId + " освободил доступ к ресурсу");
                    semaphore.release();
                }
            }).start();
        }
    }
}
