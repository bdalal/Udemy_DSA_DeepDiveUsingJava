package deepdive.lists.dseg;

import deepdive.lists.datastructures.DoublyLinkedList;

public class DoublyLinkedListExample {
    public static void main(String... args) throws CloneNotSupportedException {
        String data[] = {"April", "Ann", "Chris", "Ron", "Leslie", "Andy", "Ben", "Tom", "Donna", "Garry"};
        int[] intTest = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        DoublyLinkedList<String> list = new DoublyLinkedList<>("Joe");
        DoublyLinkedList<Integer> intList = new DoublyLinkedList<>(0);
        for (int i = 0; i < data.length; i += 2) {
            list.addToHead(data[i]);
            list.addToTail(data[i + 1]);
            intList.addToHead(intTest[i]);
            intList.addToTail(intTest[i + 1]);
        }
        System.out.println(list.removeFromHead());
        System.out.println(list.removeFromTail());
        System.out.println(intList.removeFromHead());
        System.out.println(intList.removeFromTail());

        for (String d : list.traverseFromHead(list.getHead()))
            System.out.print(d + "\t");
        System.out.println();

        for (String d : list.traverseFromTail(list.getTail()))
            System.out.print(d + "\t");
        System.out.println();

        for (int i : intList.traverseFromHead(intList.getHead()))
            System.out.print(i + "\t");
        System.out.println();

        for (int i : intList.traverseFromTail(intList.getTail()))
            System.out.print(i + "\t");
        System.out.println();

        list.addBefore("Joe", "Binoy");
        list.addAfter("Ben", "Apu");

        for (String d : list.traverseFromHead(list.getHead()))
            System.out.print(d + "\t");
        System.out.println();

        intList.insertSorted(-4);
        intList.insertSorted(4);
        intList.insertSorted(-1);
        intList.insertSorted(2);

        for (int i : intList.traverseFromHead(intList.getHead()))
            System.out.print(i + "\t");
        System.out.println();

    }
}
