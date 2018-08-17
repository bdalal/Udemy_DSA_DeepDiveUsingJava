package deepdive.stack.stackeg;

import deepdive.stack.impl.StackListImpl;

public class LinkedListStack {
    public static void main(String... args) throws Exception {
        StackListImpl<String> s = new StackListImpl<>();
//        s.peek();
        s.push("Donna");
        s.push("Joe");
        System.out.println(s.peek());
        System.out.println(s.pop());
        s.push("Marcy");
        System.out.println(s.pop());
        System.out.println(s.pop());
//        System.out.println(s.pop());
    }
}
