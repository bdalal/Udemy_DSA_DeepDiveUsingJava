package deepdive.queue;

public interface Queue<T> {
    void add(T data) throws Exception;

    T remove() throws Exception;

    T peek() throws Exception;

    boolean isEmpty();
}
