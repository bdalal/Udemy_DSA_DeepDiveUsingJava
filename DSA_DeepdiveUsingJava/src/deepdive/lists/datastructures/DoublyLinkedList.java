package deepdive.lists.datastructures;

import deepdive.lists.commons.Node;

import java.lang.reflect.Array;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList(T data) {
        this.head = new Node<>(data);
        this.tail = head;
        this.size++;
    }

    public void addToHead(T data) {
        Node<T> next = new Node<>(data);
        next.setNext(head);
        head.setPrev(next);
        this.head = next;
        this.size++;
    }

    public void addToTail(T data) {
        Node<T> prev = new Node<>(data);
        prev.setPrev(tail);
        tail.setNext(prev);
        this.tail = prev;
        this.size++;
    }

    public T removeFromHead() {
        Node<T> node = this.head;
        this.head = this.head.getNext();
        this.size--;
        return node.getData();
    }

    public T removeFromTail() {
        Node<T> node = this.tail;
        this.tail = this.tail.getPrev();
        this.size--;
        return node.getData();
    }

    public <T> T[] traverseFromHead(Node<T> head) {
        T[] data = (T[]) Array.newInstance(head.getData().getClass(), this.size);
        for (int i = 0; i < this.size; i++) {
            data[i] = head.getData();
            head = head.getNext();
        }
        return data;
    }

    public <T> T[] traverseFromTail(Node<T> tail) {
        T[] data = (T[]) Array.newInstance(tail.getData().getClass(), this.size);
        for (int i = 0; i < this.size; i++) {
            data[i] = tail.getData();
            tail = tail.getPrev();
        }
        return data;
    }

    public void addBefore(T existing, T newO) {
        if (head == tail) {
            //there's only one element
            addToHead(newO);
            return;
        }
        Node<T> current = this.head;
        for (int i = 0; i < size; i++)
            if (current.getData().equals(existing)) {
                if (i == 0)
                    addToHead(newO);
                else {
                    Node<T> newNode = new Node<>(newO);
                    current.getPrev().setNext(newNode);
                    newNode.setPrev(current.getPrev());
                    newNode.setNext(current);
                    current.setPrev(newNode);
                    size++;
                }
                break;
            } else {
                current = current.getNext();
            }
    }

    public void addAfter(T existing, T newO) {
        if (head == tail) {
            //there's only one element
            addToTail(newO);
            return;
        }
        Node<T> current = this.head;
        for (int i = 0; i < size; i++)
            if (current.getData().equals(existing)) {
                if (i == size - 1)
                    addToTail(newO);
                else {
                    Node<T> newNode = new Node<>(newO);
                    current.getNext().setPrev(newNode);
                    newNode.setPrev(current);
                    newNode.setNext(current.getNext());
                    current.setNext(newNode);
                    size++;
                }
                break;
            } else {
                current = current.getNext();
            }
    }

    public void insertSorted(T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.compareTo(newNode) == 0) {
                this.addBefore(current.getData(), data);
                break;
            }
            if (i < size - 1) {
                current = current.getNext();
            } else if (i == size - 1) {
                this.addAfter(current.getData(), data);
                break;
            }
        }
    }

    public int getSize() {
        return this.size;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }
}