package deepdive.heap.commons;

public interface Heap<T> {

    enum type {
        MAX, MIN;
    }

    void insert(T data);

    T delete(T data);

    T peek();

    int size();

    void heapify(boolean up, int position);

    int capacity();

    int checkHeap();
}
