package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] abc = reader.readLine().split(" ");
        int first = Integer.parseInt(abc[0]);

        int second = Integer.parseInt(abc[1]);
        Math m = new Math();
        System.out.println(m.divide(first, second));
    }

}

class Math {
    private boolean digitIsNotNull(int a) {
        if (a != 0) {
            return true;
        } else return false;
    }
    public int divide(int x, int y) {
        if (digitIsNotNull(y)) {
            return x/y;
        } else {
            System.out.println("Нельзя делить на 0");
            return 0;
        }
    }
}
