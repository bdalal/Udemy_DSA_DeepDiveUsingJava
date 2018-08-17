package deepdive.stack.impl;

import deepdive.lists.commons.Node;
import deepdive.lists.datastructures.SinglyLinkedList;
import deepdive.stack.Stack;

public class StackListImpl<T> implements Stack<T> {

    SinglyLinkedList<T> list = new SinglyLinkedList<>();
    private final int size;
    private int ctr;

    public StackListImpl() {
        size = 20;
    }

    public StackListImpl(int size) {
        this.size = size;
    }

    @Override
    public void push(T data) throws StackOverflowError {
        if (ctr == size)
            throw new StackOverflowError("Stack is full. Create a bigger stack");
        list.add(data);
        ctr++;
    }

    @Override
    public T peek() throws IllegalAccessException {
        if (list.getHead() == null)
            throw new IllegalAccessException("Stack is empty");
        return list.getHead().getData();
    }

    @Override
    public T pop() throws IllegalAccessException {
        if (list.getHead() == null)
            throw new IllegalAccessException("Stack is empty");
        ctr--;
        return list.remove();
    }

    @Override
    public boolean isEmpty() {
        return list.getHead() == null;
    }
}
