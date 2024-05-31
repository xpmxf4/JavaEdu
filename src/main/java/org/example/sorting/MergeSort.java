package org.example.sorting;

/**
 * 배열을 반으로 나눈 후,
 * 정렬하고 병합하는 방식
 */
public class MergeSort {
    public static void merge(int[] array, int left, int mid, int right) {
        // 왼쪽과 오른쪽 부분 배열의 크기 계산
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 임시 배열 생성
        int[] L = new int[n1];
        int[] R = new int[n2];

        // 데이터를 임시 배열로 복사
        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = array[mid + 1 + i];
        }

        // 임시 배열들을 병합하여, 원래 배열에 저장
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if(left < right) {
            // 중간 포인트 찾기
            int mid = (left + right) / 2;

            // 중간점을 기준으로 두 부분으로 나눠 각각 정렬합니다.
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // 정렬된 두 부분을 병합
            merge(array, left, mid, right);
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("Given Array");
        for (int i = 0; i < array.length; ++i)
            System.out.print(array[i] + " ");
        System.out.println();

        mergeSort(array, 0, array.length - 1);

        System.out.println("\nSorted array");
        for (int i = 0; i < array.length; ++i)
            System.out.print(array[i] + " ");
    }
}
