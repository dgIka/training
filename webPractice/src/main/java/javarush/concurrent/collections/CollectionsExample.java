package javarush.concurrent.collections;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;

public class CollectionsExample {
    private static final CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
    private static final ConcurrentHashMap<Integer, String > map = new ConcurrentHashMap<>();
    private static final BlockingDeque<String> queue = new LinkedBlockingDeque<>();

    public static void main(String[] args) {
        Thread listThread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.add("Element: " + i);
                System.out.println("List Thread 1 added: " + i);
            }
        });
        Thread listThread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                map.put(i, "Value: " + i);
                System.out.println("Map Thread 1 added: " + i);
            }
        });
        listThread1.start();
        listThread2.start();
    }

}
