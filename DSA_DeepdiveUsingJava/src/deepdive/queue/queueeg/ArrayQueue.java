package deepdive.queue.queueeg;

import deepdive.queue.Queue;
import deepdive.queue.impl.QueueArrayImpl;

public class ArrayQueue {
    public static void main(String... args) throws Exception {
        Queue<String> q = new QueueArrayImpl<>();
        q.add("Binoy");
        q.add("Apurva");
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.peek());
    }
}
