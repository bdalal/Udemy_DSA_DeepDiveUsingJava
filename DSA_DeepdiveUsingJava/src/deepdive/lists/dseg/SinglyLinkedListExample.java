package deepdive.lists.dseg;

import deepdive.lists.datastructures.SinglyLinkedList;

public class SinglyLinkedListExample {
    public static void main(String... args) throws CloneNotSupportedException {
        String data[] = {"April", "Ann", "Chris", "Ron", "Leslie", "Andy", "Ben", "Tom", "Donna", "Garry"};
        int[] intTest = {1, 2, 3, 4, 5, 6, 7};
        SinglyLinkedList<String> list = new SinglyLinkedList<>("Joe");
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<>(0);
        for (String d : data)
            list.add(d);
        for (int i : intTest)
            intList.add(i);
        System.out.println(list.remove());
        System.out.println(intList.remove());
        for (String d : list.traverse(list.getHead()))
            System.out.print(d + "\t");
        System.out.println();
        for (int i : intList.traverse(intList.getHead()))
            System.out.print(i + "\t");
        System.out.println();
    }
}
