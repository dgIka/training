package javarush.concurrent.synchronizers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int threadId = i;
            new Thread(() -> {
                try{
                    System.out.println("Поток " + threadId + " выполняет работу");
                    Thread.sleep(1000 * threadId);
                    System.out.println("Поток " + threadId + " достиг барьера");
                    cyclicBarrier.await();
                    System.out.println("Поток " + threadId + " продолжает работу");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
