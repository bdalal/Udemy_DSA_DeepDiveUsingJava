package deepdive.sorting.algorithms;

import deepdive.heap.commons.Heap;
import deepdive.heap.datastructures.ArrayHeap;
import deepdive.sorting.constants.Constants;

import java.util.Arrays;
import java.util.Comparator;

public class HeapSort {
    public static void main(String args[]) {
        Integer[] arr = Arrays.stream(Constants.getArray(Constants.NORMAL)).boxed().toArray(Integer[]::new);
        Comparator<Integer> c = (o1, o2) -> o1 - o2;
        ArrayHeap<Integer> ah = new ArrayHeap(c, Heap.type.MIN, (arr));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ah.delete(ah.peek());
        }
        Constants.printArr(Arrays.stream(arr).mapToInt(Integer::intValue).toArray());
    }
}
