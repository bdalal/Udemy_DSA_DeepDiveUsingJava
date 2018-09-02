package deepdive.heap.datastructures;

import deepdive.heap.commons.Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayHeap<T> implements Heap<T> {

    private T[] heaparr;
    private int size;
    private int capacity = 10;
    private Comparator<T> c;
    private type heaptype;

    public ArrayHeap(Comparator<T> c, type heaptype) {
        heaparr = (T[]) new Object[capacity];
        this.c = c;
        this.heaptype = heaptype;
    }

    public ArrayHeap(Comparator<T> c, type heaptype, int capacity) {
        this.capacity = capacity;
        heaparr = (T[]) new Object[this.capacity];
        this.c = c;
        this.heaptype = heaptype;
    }

    public ArrayHeap(Comparator<T> c, type heaptype, T[] data) {
        this.c = c;
        capacity = data.length + 10;
        heaparr = (T[]) new Object[capacity];
        this.heaptype = heaptype;
        Arrays.stream(data).filter(Objects::nonNull).forEach(o -> insert(o));
    }

    @Override
    public void insert(T data) {
        if (size == capacity) {
            capacity += 10;
            T[] temparr = (T[]) new Object[capacity];
            System.arraycopy(heaparr, 0, temparr, 0, heaparr.length);
            heaparr = temparr;
        }
        heaparr[size++] = data;
        if (size > 1 && !compare(heaparr[parentPos(size - 1)], heaparr[size - 1]))
            heapify(true, size - 1);
    }

    @Override
    public T delete(T data) {
        boolean contains = Stream.of(heaparr).anyMatch(x -> c.compare(x, data) == 0);
        if (size == 0 || !contains)
            throw new RuntimeException(new IllegalAccessException("Heap is empty or does not have the data"));
        int pos = IntStream.range(0, size).filter(i -> c.compare(heaparr[i], data) == 0).findFirst().getAsInt();
        T deletedElem = heaparr[pos];
        heaparr[pos] = heaparr[size - 1];
        heaparr[--size] = null;
        if (!compare(heaparr[parentPos(pos)], heaparr[pos]))
            heapifyUp(pos);
        else if (!compare(heaparr[pos], heaparr[leftChildPos(pos)]) || !compare(heaparr[pos], heaparr[rightChildPos(pos)]))
            heapifyDown(pos);
        return deletedElem;
    }

    @Override
    public T peek() {
        if (size == 0)
            throw new RuntimeException(new IllegalAccessException("Heap is empty"));
        return heaparr[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void heapify(boolean up, int position) {
        if (up)
            heapifyUp(position);
        if (!up)
            heapifyDown(position);
    }

    private void heapifyDown(int elemPosition) {
        int lchildpos = leftChildPos(elemPosition);
        int rchildpos = rightChildPos(elemPosition);
        T elem = heaparr[elemPosition];
        T lchild = heaparr[lchildpos];
        T rchild = heaparr[rchildpos];
        T replchild = null;
        int replchildpos = -1;
        if (lchild == null && rchild == null)
            return;
        if (lchild == null) {
            replchild = rchild;
            replchildpos = rchildpos;
        } else if (rchild == null) {
            replchild = lchild;
            replchildpos = lchildpos;
        } else {
            boolean l;
            if (this.heaptype == type.MAX)
                l = c.compare(lchild, rchild) > 0;
            else
                l = c.compare(lchild, rchild) < 0;
            if (l) {
                replchild = lchild;
                replchildpos = lchildpos;
            } else {
                replchild = rchild;
                replchildpos = rchildpos;
            }
        }
        while (!compare(elem, replchild)) {
            heaparr[elemPosition] = (T) swap(heaparr[replchildpos], heaparr[replchildpos] = heaparr[elemPosition]);
            elemPosition = (int) swap(replchildpos, replchildpos = elemPosition);
            lchildpos = leftChildPos(elemPosition);
            rchildpos = rightChildPos(elemPosition);
            lchild = heaparr[lchildpos];
            rchild = heaparr[rchildpos];
            if (lchild == null && rchild == null)
                return;
            if (lchild == null) {
                replchild = rchild;
                replchildpos = rchildpos;
            } else if (rchild == null) {
                replchild = lchild;
                replchildpos = lchildpos;
            } else {
                boolean l;
                if (this.heaptype == type.MAX)
                    l = c.compare(lchild, rchild) > 0;
                else
                    l = c.compare(lchild, rchild) < 0;
                if (l) {
                    replchild = lchild;
                    replchildpos = lchildpos;
                } else {
                    replchild = rchild;
                    replchildpos = rchildpos;
                }
            }
        }
    }

    private void heapifyUp(int lastElementPosition) {
        int parentPosition = parentPos(lastElementPosition);
        T lastElement = heaparr[lastElementPosition];
        T parent = heaparr[parentPosition];
        while (!compare(parent, lastElement)) {
            heaparr[lastElementPosition] = (T) swap(heaparr[parentPosition], heaparr[parentPosition] = heaparr[lastElementPosition]);
            lastElementPosition = (int) swap(parentPosition, parentPosition = lastElementPosition);
            parentPosition = parentPos(lastElementPosition);
            lastElement = heaparr[lastElementPosition];
            parent = heaparr[parentPosition];
        }
    }

    private Object swap(Object o1, Object o2) {
        return o1;
    }

    public void printHeap() {
        System.out.println(Arrays.stream(heaparr).filter(Objects::nonNull).map(Object::toString).collect(Collectors.joining(", ")));
    }

    public int capacity() {
        return capacity;
    }

    public int checkHeap() {
        int pos = 0;
        while (pos <= parentPos(size - 1)) {
            T parent = heaparr[pos];
            T lchild = heaparr[leftChildPos(pos)];
            T rchild = heaparr[rightChildPos(pos)];
            if (!compare(parent, lchild) || !compare(parent, rchild))
                return pos;
            pos++;
        }
        return -1;
    }

    private boolean compare(T parent, T child) {
        switch (heaptype) {
            case MAX:
                if (c.compare(parent, child) < 0)
                    return false;
                break;
            case MIN:
                if (c.compare(parent, child) > 0)
                    return false;
                break;
        }
        return true;
    }

    private int leftChildPos(int pos) {
        return (2 * pos) + 1;
    }

    private int rightChildPos(int pos) {
        return (2 * pos) + 2;
    }

    private int parentPos(int pos) {
        return (int) Math.abs(Math.floor((pos - 1) / 2));
    }
}
