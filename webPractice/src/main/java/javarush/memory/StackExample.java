package javarush.memory;

public class StackExample {
    public static void main(String[] args) {
        int a = 1;
        firstMethod();
    }

    static void firstMethod() {
        int b = 2;
        secondMethod();
    }

    static void secondMethod() {
        int c = 3;
    }
}
