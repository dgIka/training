package javarush.memory;

public class StackHeap {
    public static void main(String[] args) {
        int number = 5; // в Stack
        String name = "Java"; // ссылка в Stack, объект в StringPool
        Object object = new Object(); // Ссылка в Stack, объект в Heap

        // Stack: number = 5, name ->,
        // StringPool: "Java"
    }
}
