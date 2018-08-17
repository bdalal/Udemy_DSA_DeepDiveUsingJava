package deepdive.lists.commons;

public class Node<T> implements Cloneable, Comparable<T> {
    private Node<T> next;
    private Node<T> prev;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        Node<T> node = (Node<T>) obj;
        node.setNext(this.getNext());
        node.setPrev(this.getPrev());
        node.setData(this.getData());
        return node;
    }

    @Override
    public int compareTo(Object o) {
        Node<T> current = (Node<T>) o;
        if (current.getData() instanceof Integer) {
            if (((Integer) this.getData()).intValue() <= ((Integer) current.getData()).intValue()) {
                return 1;
            }
            return 0;
        } else if (current.getData() instanceof Character) {
            if ((Character) this.data <= (Character) current.getData()) {
                return 1;
            }
            return 0;
        } else
            throw new IllegalArgumentException("Data type cannot be compared to determine order. Use Character or Integer");
    }

}
