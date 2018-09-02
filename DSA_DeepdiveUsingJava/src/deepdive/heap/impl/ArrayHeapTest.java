package deepdive.heap.impl;

import deepdive.heap.commons.Heap;
import deepdive.heap.datastructures.ArrayHeap;

import java.util.Comparator;

public class ArrayHeapTest {
    public static void main(String args[]) {
        Comparator<Integer> c = (o1, o2) -> o1 - o2;
        ArrayHeap<Integer> ah = new ArrayHeap(c, Heap.type.MAX);
        ah.insert(20);
        ah.insert(15);
        ah.insert(27);
        ah.insert(30);
        ah.insert(29);
        ah.insert(26);
        ah.insert(22);
        ah.insert(32);
        ah.printHeap();

        System.out.println(ah.delete(32));
        ah.printHeap();

        Integer[] arr = {20, 15, 27, 30, 29, 26, 22, 32};
        ah = new ArrayHeap(c, Heap.type.MAX, arr);
        System.out.println();
        ah.printHeap();

        ah = new ArrayHeap(c, Heap.type.MIN, arr);
        System.out.println();
        ah.printHeap();

        System.out.println(ah.delete(15));
        ah.printHeap();
    }
}
