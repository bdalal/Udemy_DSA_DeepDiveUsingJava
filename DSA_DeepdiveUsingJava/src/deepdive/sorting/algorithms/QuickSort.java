package deepdive.sorting.algorithms;

import deepdive.sorting.constants.Constants;

public class QuickSort {
    public static void main(String... args) {
        int[] arr = Constants.getArray(Constants.NORMAL);
        quickSort(arr, 0, arr.length);
        Constants.printArr(arr);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (end - start < 2)
            return;
        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex);
        quickSort(arr, pivotIndex + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && arr[--j] >= pivot) ;
            if (i < j)
                arr[i] = arr[j];
            while (i < j && arr[++i] <= pivot) ;
            if (i < j)
                arr[j] = arr[i];
        }
        arr[j] = pivot;
        return j;
    }
}
