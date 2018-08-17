package deepdive.tree.application;

import deepdive.tree.commons.TreeNode;
import deepdive.tree.datastructures.BinarySearchTree;

import java.util.Comparator;

public class BinarySearchTreeTest {
    public static void main(String args[]) throws IllegalAccessException {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(25);
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue() - o2.intValue();
            }
        };
        bst.insert(20, c);
        bst.insert(15, c);
        bst.insert(27, c);
        bst.insert(30, c);
        bst.insert(29, c);
        bst.insert(26, c);
        bst.insert(22, c);
        bst.insert(32, c);

        System.out.println(bst.traverse("BFS"));

        System.out.println(bst.min());
        System.out.println(bst.max());

        TreeNode<Integer> got = bst.get(2);
        System.out.println(got != null ? ((TreeNode) got).getData() : "NULL");
    }
}
