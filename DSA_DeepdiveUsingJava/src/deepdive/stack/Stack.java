package deepdive.stack;

public interface Stack<T> {

    public void push(T data) throws Exception;

    public T peek() throws Exception;

    public T pop() throws Exception;

    public boolean isEmpty();

}
