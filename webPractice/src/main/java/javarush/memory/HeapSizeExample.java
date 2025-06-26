package javarush.memory;

public class HeapSizeExample {
    public static void main(String[] args) {
        long maxHeapSize = Runtime.getRuntime().maxMemory();
        long heapSize = Runtime.getRuntime().totalMemory();

        System.out.println("Max heap size: " + maxHeapSize/1024/1024 + "MB");
        System.out.println("Heap size: " + heapSize/1024/1024 + "MB");
    }
}
