package org.example.sorting;

import java.util.Arrays;

// 참고 링크
// https://www.youtube.com/watch?v=WprjBK0p6rw
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {3, 2, 5, 0, 1, 8, 7, 6, 9, 4};
        quickSort(array, 0, array.length - 1);
        System.out.println("array = " + Arrays.toString(array));
    }

    private static void quickSort(int[] array, int begin, int end) {

        if (begin < end) {
            int partitionIdx = partition(array, begin, end);

            quickSort(array, begin, partitionIdx - 1);
            quickSort(array, partitionIdx + 1, end);
        }
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int swapMarker = begin - 1;

        for (int currIdx = begin; currIdx < end; currIdx++) {

            if (array[currIdx] <= pivot) {

                swapMarker++;
                int swapTemp = array[currIdx];
                array[currIdx] = array[swapMarker];
                array[swapMarker] = swapTemp;
            }
        }

        int swapTemp = array[swapMarker + 1];
        array[swapMarker+1] = pivot;
        array[end] = swapTemp;


        return swapMarker + 1;
    }


}
