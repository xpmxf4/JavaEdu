package org.example.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {13, 51, 34, 32, 22, 67, 4, 31, 90};

        bubbleSort(array);

        System.out.println("array = " + Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[i + 1] = tmp;
                }
            }
        }
    }
}
