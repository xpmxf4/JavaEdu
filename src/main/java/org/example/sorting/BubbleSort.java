package org.example.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {13, 51, 34, 32, 22, 67, 4, 31, 90};
        System.out.println("(before)array = " + Arrays.toString(array));
        bubbleSort(array);
        System.out.println("(after)array = " + Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                // 특징 : 인접한 두 data를 비교하며, 큰 값을 배열 끝으로 이동
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
