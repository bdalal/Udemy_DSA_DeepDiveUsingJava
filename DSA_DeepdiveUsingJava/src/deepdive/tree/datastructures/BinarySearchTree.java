package deepdive.tree.datastructures;

import deepdive.tree.commons.Tree;
import deepdive.tree.commons.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class BinarySearchTree<T> implements Tree<T> {

    private TreeNode<T> root;
    private int depth;
    private Comparator<T> c;

    public BinarySearchTree(T data, Comparator c) {
        root = new TreeNode<>(data);
        root.setRoot();
        this.c = c;
    }

    //    @Override
    public void insert(T data) throws IllegalAccessException {
        insert(data, root);
    }

    @Override
    public void insert(T data, TreeNode<T> node) throws IllegalAccessException {
        if (node.getData() == null)
            throw new IllegalAccessException("Root has no data. Set root data first");
        if (c == null)
            throw new IllegalAccessException("Comparator needs to be specified");
        if (c.compare(node.getData(), data) > 0) {
            if (node.getLeftChild() == null) {
                depth++;
                node.setLeftChild(new TreeNode<>(data));
                node.getLeftChild().setParent(node);
                node.getLeftChild().setDepth(depth);
            } else {
                node = node.getLeftChild();
                insert(data, node);
            }
        } else if (c.compare(node.getData(), data) < 0) {
            if (node.getRightChild() == null) {
                depth++;
                node.setRightChild(new TreeNode<>(data));
                node.getRightChild().setParent(node);
                node.getRightChild().setDepth(depth);
            } else {
                node = node.getRightChild();
                insert(data, node);
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
        if (c.compare(node.getData(), data) == 0)
            return node;
        if (c.compare(node.getData(), data) > 0 && node.getLeftChild() != null)
            nodeF = get(data, node.getLeftChild());
        if (c.compare(node.getData(), data) < 0 && node.getRightChild() != null)
            nodeF = get(data, node.getRightChild());
        return nodeF;
    }

    @Override
    public T min() {
        return min(root);
    }

    private T min(TreeNode<T> node) {
        T data;
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
        T data;
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
        TreeNode<T> del = get(data);
        if (del == null)
            return null;
        if (del.isLeaf()) {
            if (del.getParent().getLeftChild() == del)
                del.getParent().setLeftChild(null);
            else
                del.getParent().setRightChild(null);
            return data;
        }
        if (del.getLeftChild() == null || del.getRightChild() == null) {
            del.getParent().setData(del.getData());
            del.getParent().setLeftChild(null);
            del.getParent().setRightChild(null);
            return data;
        }

        return data;
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
        if (node.getRightChild() != null)
            traverseLRN(node.getRightChild(), data);
        data.add(node.getData());
        return data;
    }

    private List<T> traverseNLR(TreeNode<T> node, List<T> data) {
        data.add(node.getData());
        if (node.getLeftChild() != null)
            traverseNLR(node.getLeftChild(), data);
        if (node.getRightChild() != null)
            traverseNLR(node.getRightChild(), data);
        return data;
    }

    private List<T> traverseLNR(TreeNode<T> node, List<T> data) {
        if (node.getLeftChild() != null)
            traverseLNR(node.getLeftChild(), data);
        data.add(node.getData());
        if (node.getRightChild() != null) {
            traverseLNR(node.getRightChild(), data);
        }
        return data;
    }

}
