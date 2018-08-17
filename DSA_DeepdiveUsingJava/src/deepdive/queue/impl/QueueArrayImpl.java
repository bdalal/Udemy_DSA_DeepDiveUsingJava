package deepdive.queue.impl;

import deepdive.queue.Queue;

import java.util.Arrays;

public class QueueArrayImpl<T> implements Queue<T> {

    private int back;
    private T[] arr;

    private final int size;

    public QueueArrayImpl() {
        size = 20;
        arr = (T[]) new Object[size];
    }

    public QueueArrayImpl(int size) {
        this.size = size;
        arr = (T[]) new Object[size];
    }

    @Override
    public void add(T data) throws IllegalAccessException {
        if (back == size)
            throw new IllegalAccessException("Queue is full. Create a bigger queue");
        arr[back++] = data;
    }

    @Override
    public T remove() throws IllegalAccessException {
        if (isEmpty())
            throw new IllegalAccessException("Queue is empty");
        back--;
        T elem = arr[0];
        System.arraycopy(arr, 1, arr, 0, size - 1);
        return elem;
    }

    @Override
    public T peek() throws IllegalAccessException {
        if (isEmpty())
            throw new IllegalAccessException("Queue is empty");
        return arr[0];
    }

    @Override
    public boolean isEmpty() {
        return arr[0] == null;
    }
}
