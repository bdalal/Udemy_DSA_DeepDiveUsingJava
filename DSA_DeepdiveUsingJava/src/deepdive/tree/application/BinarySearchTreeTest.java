package deepdive.tree.application;

import deepdive.tree.commons.TreeNode;
import deepdive.tree.datastructures.BinarySearchTree;

import java.util.Comparator;

public class BinarySearchTreeTest {
    public static void main(String args[]) throws IllegalAccessException {
        Comparator<Integer> c = (o1, o2) -> o1 - o2;
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(25, c);
        bst.insert(20);
        bst.insert(15);
        bst.insert(27);
        bst.insert(30);
        bst.insert(29);
        bst.insert(26);
        bst.insert(22);
        bst.insert(32);
        bst.insert(17);
        bst.insert(33);
        bst.insert(16);

        System.out.println("BFS : " + bst.traverse("BFS"));
        System.out.println("LNR : " + bst.traverse("LNR"));
        System.out.println("NLR : " + bst.traverse("NLR"));
        System.out.println("LRN : " + bst.traverse("LRN"));

        System.out.println(bst.min());
        System.out.println(bst.max());

        TreeNode<Integer> got = bst.get(33);
        System.out.println(got != null ? ((TreeNode) got).getData() : "NULL");
        System.out.println("Parent : " + got.getParent().getData());

        System.out.println("Depth : " + bst.depth());
        System.out.println("Depth of 25 : " + bst.depth(25));
        System.out.println("Depth of 16 : " + bst.depth(16));
//        System.out.println("Depth of 2 : " + bst.depth(2));
        System.out.println("Height of 25 : " + bst.height(25));
//        System.out.println("Depth of 2 : " + bst.height(2));
        System.out.println("Height of 16 : " + bst.height(16));
        System.out.println("Height of 20 : " + bst.height(20));

        System.out.println(bst.delete(16));
        System.out.println(bst.delete(17));
        System.out.println(bst.delete(25));
        System.out.println(bst.traverse("LNR"));
    }
}
