package org.example.sorting;

import java.util.*;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            System.out.println("array = " + Arrays.toString(array));
            System.out.println("key = " + key);
            int j = i - 1;

            // key 보다 큰 값들을 한 칸씩 뒤로 옮김
            System.out.println("(before)j = " + j);
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j--];
                System.out.println("array = " + Arrays.toString(array));
                System.out.println("j = " + j);
            }
            System.out.println("(after)j = " + j);
            // 옮겨진 자리에 key를 삽입합니다.
            array[j + 1] = key;
            System.out.println("(result)array = " + Arrays.toString(array));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 1, 4, 3};
        System.out.println("Original array:");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.println();
        insertionSort(array);
        System.out.println();

        System.out.println("Sorted array:");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
