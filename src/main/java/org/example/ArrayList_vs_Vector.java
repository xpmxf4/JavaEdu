package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ArrayList_vs_Vector {
    public static void main(String[] args) {
        // 요소의 개수
        int elementsCount = 100000000;

        // Vector 사용
        Vector<Integer> vector = new Vector<>();
        long startVector = System.currentTimeMillis();
        for (int i = 0; i < elementsCount; i++) {
            vector.add(i);
        }
        long endVector = System.currentTimeMillis();
        System.out.println("Vector time: " + (endVector - startVector) + " ms");

        // ArrayList 사용
        List<Integer> arrayList = new ArrayList<>();
        long startArrayList = System.currentTimeMillis();
        for (int i = 0; i < elementsCount; i++) {
            arrayList.add(i);
        }
        long endArrayList = System.currentTimeMillis();
        System.out.println("ArrayList time: " + (endArrayList - startArrayList) + " ms");
    }
}
