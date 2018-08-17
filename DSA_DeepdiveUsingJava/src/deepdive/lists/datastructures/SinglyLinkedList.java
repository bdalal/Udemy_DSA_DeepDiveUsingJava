package deepdive.lists.datastructures;

import deepdive.lists.commons.Node;

import java.lang.reflect.Array;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(T data) {
        this.head = new Node<>(data);
        this.size++;
    }

    public void add(T data) {
        Node<T> next = new Node<>(data);
        next.setNext(head);
        this.head = next;
        this.size++;
    }

    public T remove() {
        Node<T> node = this.head;
        this.head = this.head.getNext();
        this.size--;
        return node.getData();
    }

    public <T> T[] traverse(Node<T> head) throws CloneNotSupportedException {
        head = (Node<T>) head.clone();
        T[] data = (T[]) Array.newInstance(head.getData().getClass(), this.size);
        for (int i = 0; i < this.size; i++) {
            data[i] = head.getData();
            head = head.getNext();
        }
        return data;
    }

    public int getSize() {
        return this.size;
    }

    public Node<T> getHead() {
        return this.head;
    }

}
