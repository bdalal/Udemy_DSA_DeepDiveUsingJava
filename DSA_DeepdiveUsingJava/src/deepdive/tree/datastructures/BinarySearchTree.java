package deepdive.tree.datastructures;

import deepdive.tree.commons.Tree;
import deepdive.tree.commons.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class BinarySearchTree<T> implements Tree<T> {

    private TreeNode<T> root;
    private int depth;
    private TreeNode node;
    private boolean found = false;

    public BinarySearchTree() {
        root = new TreeNode<>(null);
        root.setRoot();
    }

    public BinarySearchTree(T data) {
        root = new TreeNode<>(data);
        root.setRoot();
    }

    //    @Override
    public void insert(T data, Comparator c) throws IllegalAccessException {
        insert(data, c, root);
    }

    @Override
    public void insert(T data, Comparator c, TreeNode node) throws IllegalAccessException {
        if (node.getData() == null)
            throw new IllegalAccessException("Root has no data. Set root data first");
        if (c == null)
            throw new IllegalAccessException("Comparator needs to be specified");
        if (c.compare(node.getData(), data) > 0) {
            if (node.getLeftChild() == null)
                node.setLeftChild(new TreeNode<>(data));
            else {
                node = node.getLeftChild();
                insert(data, c, node);
            }
        } else if (c.compare(node.getData(), data) < 0) {
            if (node.getRightChild() == null)
                node.setRightChild(new TreeNode<>(data));
            else {
                node = node.getRightChild();
                insert(data, c, node);
            }
        } else {
            throw new IllegalArgumentException("Element is a duplicate, discarding.");
        }
    }

    @Override
    public TreeNode<T> get(T data) {
        return root.getData() == data ? root : get(data, root);
    }

    private TreeNode<T> get(T data, TreeNode<T> node) {
        TreeNode<T> nodeF = null;
        if (node.getLeftChild() != null)
            if (node.getLeftChild().getData() == data) {
                found = true;
                return node.getLeftChild();
            }
        if (node.getRightChild() != null)
            if (node.getRightChild().getData() == data) {
                found = true;
                return node.getRightChild();
            }
        if (!found && node.getLeftChild() != null)
            nodeF = get(data, node.getLeftChild());
        if (!found && node.getRightChild() != null)
            nodeF = get(data, node.getRightChild());
        return nodeF;
    }

    @Override
    public T min() {
        return min(root);
    }

    private T min(TreeNode<T> node) {
        T data = null;
        if (node.getLeftChild() == null)
            return node.getData();
        else
            data = min(node.getLeftChild());
        return data;
    }

    @Override
    public T max() {
        return max(root);
    }

    private T max(TreeNode<T> node) {
        T data = null;
        if (node.getRightChild() == null)
            return node.getData();
        else
            data = max(node.getRightChild());
        return data;
    }

    @Override
    public int depth(T data) {
        return 0;
    }

    @Override
    public int depth() {
        return 0;
    }

    @Override
    public int height(T data) {
        return 0;
    }

    @Override
    public T delete(T data) {
        return null;
    }

    @Override
    public List<T> traverse(String t) {
        List<T> data = new ArrayList<>();
        if (t == TraverseMode.LNR.toString()) {
            return traverseLNR(root, data);
        } else if (t == TraverseMode.LRN.toString()) {
            return traverseLRN(root, data);
        } else if (t == TraverseMode.NLR.toString()) {
            return traverseNLR(root, data);
        } else if (t == TraverseMode.BFS.toString()) {
            data.add(root.getData());
            return traverseBFS(root, data);
        }
        throw new IllegalArgumentException("This TraverseMode is not supported");
    }

    private List<T> traverseBFS(TreeNode<T> node, List<T> data) {
        if (node.getLeftChild() != null)
            data.add(node.getLeftChild().getData());
        else
            return data;
        if (node.getRightChild() != null)
            data.add(node.getRightChild().getData());
        else
            return data;
        traverseBFS(node.getLeftChild(), data);
        traverseBFS(node.getRightChild(), data);
        return data;
    }

    private List<T> traverseLRN(TreeNode<T> node, List<T> data) {
        if (node.getLeftChild() != null)
            traverseLRN(node.getLeftChild(), data);
        else {
            data.add(node.getData());
            return data;
        }
        if (node.getRightChild() != null)
            traverseLRN(node.getRightChild(), data);
        else {
            data.add(node.getData());
            return data;
        }
        data.add(node.getData());
        return data;
    }

    private List<T> traverseNLR(TreeNode<T> node, List<T> data) {
        data.add(node.getData());
        if (node.getLeftChild() != null)
            traverseNLR(node.getLeftChild(), data);
        else
            return data;
        if (node.getRightChild() != null)
            traverseNLR(node.getRightChild(), data);
        else
            return data;
        return data;
    }

    private List<T> traverseLNR(TreeNode<T> node, List<T> data) {
        if (node.getLeftChild() != null)
            traverseLNR(node.getLeftChild(), data);
        else {
            data.add(node.getData());
            return data;
        }
        if (node.getRightChild() != null) {
            data.add(node.getData());
            traverseLNR(node.getRightChild(), data);
        } else {
            data.add(node.getData());
            return data;
        }
        return data;
    }

}
