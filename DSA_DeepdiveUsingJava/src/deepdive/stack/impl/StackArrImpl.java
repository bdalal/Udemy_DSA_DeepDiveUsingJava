package deepdive.stack.impl;

import deepdive.stack.Stack;

public class StackArrImpl<T> implements Stack<T> {

    private int top;
    private T[] arr;

    private final int size;

    public StackArrImpl() {
        size = 20;
        arr = (T[]) new Object[size];
        top = 0;
    }

    public StackArrImpl(int size) {
        this.size = size;
        arr = (T[]) new Object[size];
        top = 0;
    }


    @Override
    public void push(T data) throws Error {
        if (top == size)
            throw new StackOverflowError("Stack is full. Create a bigger stack");
        arr[top++] = data;
    }

    @Override
    public T peek() throws IllegalAccessException {
        if (top == 0)
            throw new IllegalAccessException("Stack is empty");
        return arr[top - 1];
    }

    @Override
    public T pop() throws IllegalAccessException {
        if (top == 0)
            throw new IllegalAccessException("Stack is empty");
        return arr[--top];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
