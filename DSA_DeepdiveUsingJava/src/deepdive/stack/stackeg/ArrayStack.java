package deepdive.stack.stackeg;

import deepdive.stack.impl.StackArrImpl;

public class ArrayStack {
    public static void main(String... args) throws Exception {
        StackArrImpl<String> s = new StackArrImpl<>();
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
