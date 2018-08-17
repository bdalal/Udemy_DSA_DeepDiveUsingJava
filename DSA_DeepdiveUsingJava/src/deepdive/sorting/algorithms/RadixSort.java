package deepdive.sorting.algorithms;

import deepdive.sorting.constants.Constants;

public class RadixSort {
    public static void main(String... args) {
        int[] arr = Constants.getArray(Constants.RADIX);
        int min = 0;
        int max = 9;
        int radix = 10;
        int width = 4;

        for (int i = 0; i < width; i++) {
            int[] digitArray = getDigitArray(i, arr, radix);
            int[] countingArray = CountingSort.count(digitArray, min, max);
            adjustCountedArray(countingArray);
            int[] temp = stableCountingSort(countingArray, digitArray, arr);
            System.arraycopy(temp, 0, arr, 0, arr.length);
        }

        Constants.printArr(arr);
    }

    public static int[] getDigitArray(int pos, int[] arr, int radix) {
        int[] digitArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            digitArray[i] = (arr[i] / (int) (Math.pow(10, pos))) % radix;
        return digitArray;
    }

    public static void adjustCountedArray(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            arr[i] += arr[i - 1];
    }

    public static int[] stableCountingSort(int[] countingArray, int[] digitArray, int[] arr) {
        int[] temp = new int[arr.length];
        for (int k = arr.length - 1; k >= 0; k--)
            temp[--countingArray[digitArray[k]]] = arr[k];
        return temp;
    }
}
