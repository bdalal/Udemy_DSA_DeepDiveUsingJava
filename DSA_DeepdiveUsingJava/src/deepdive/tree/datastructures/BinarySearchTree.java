package deepdive.tree.datastructures;

import deepdive.queue.Queue;
import deepdive.queue.impl.QueueArrayImpl;
import deepdive.tree.commons.Tree;
import deepdive.tree.commons.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class BinarySearchTree<T> implements Tree<T> {

    private TreeNode<T> root;
    private int depth;
    private Comparator<T> c;
    private Queue<TreeNode<T>> queue;

    public BinarySearchTree(T data, Comparator<T> c) {
        root = new TreeNode<>(data);
        root.setRoot();
        this.c = c;
    }

    @Override
    public void insert(T data) throws IllegalAccessException {
        insert(data, root, 0);
    }

    private void insert(T data, TreeNode<T> node, int depth) throws IllegalAccessException {
        if (node.getData() == null)
            throw new IllegalAccessException("Root has no data. Set root data first");
        if (c == null)
            throw new IllegalAccessException("Comparator needs to be specified");
        if (c.compare(node.getData(), data) > 0) {
            if (node.getLeftChild() == null) {
                node.setLeftChild(new TreeNode<>(data));
                node.getLeftChild().setParent(node);
                node.getLeftChild().setDepth(++depth);
                node.getLeftChild().setIsLeftChild();
                node.setHasLeftChild(true);
                node.incNumChildren();
            } else {
                node = node.getLeftChild();
                insert(data, node, ++depth);
            }
        } else if (c.compare(node.getData(), data) < 0) {
            if (node.getRightChild() == null) {
                node.setRightChild(new TreeNode<>(data));
                node.getRightChild().setParent(node);
                node.getRightChild().setDepth(++depth);
                node.getRightChild().setIsRightChild();
                node.setHasRightChild(true);
                node.incNumChildren();
            } else {
                node = node.getRightChild();
                insert(data, node, ++depth);
            }
            this.depth = ++depth;
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
        return get(data).getDepth();
    }

    @Override
    public int depth() {
        return depth;
    }

    @Override
    public int height(T data) {
        return depth - depth(data);
    }

    @Override
    public T delete(T data) {
        TreeNode<T> del = get(data);
        if (del == null)
            return null;
        if (del.isLeaf()) {
            if (del.isLeftChild()) {
                del.getParent().setLeftChild(null);
                del.getParent().setHasLeftChild(false);
            } else {
                del.getParent().setRightChild(null);
                del.getParent().setHasRightChild(false);
            }
            del.getParent().decNumChildren();
            return data;
        }
        if (del.getNumChildren() == 1) {
            if (del.isLeftChild()) {
                if (del.hasLeftChild()) {
                    del.getLeftChild().setParent(del.getParent());
                    del.getParent().setLeftChild(del.getLeftChild());
                } else {
                    del.getRightChild().setParent(del.getParent());
                    del.getParent().setLeftChild(del.getRightChild());
                }
            } else {
                if (del.hasLeftChild()) {
                    del.getLeftChild().setParent(del.getParent());
                    del.getParent().setRightChild(del.getLeftChild());
                } else {
                    del.getRightChild().setParent(del.getParent());
                    del.getParent().setRightChild(del.getRightChild());
                }
            }
            return data;
        }
        // Get biggest from left subtree
        T dataDel = max(del.getLeftChild());
        delete(dataDel);
        del.setData(dataDel);
        return data;
    }

    @Override
    public List<T> traverse(String t) {
        List<T> data = new ArrayList<>();
        if (t.equals(TraverseMode.LNR.toString())) {
            return traverseLNR(root, data);
        } else if (t.equals(TraverseMode.LRN.toString())) {
            return traverseLRN(root, data);
        } else if (t.equals(TraverseMode.NLR.toString())) {
            return traverseNLR(root, data);
        } else if (t.equals(TraverseMode.BFS.toString())) {
//            data.add(root.getData());
            try {
                queue = new QueueArrayImpl<>((int) Math.pow(2, depth) - 1);
                return traverseBFS(root, data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException("This TraverseMode is not supported");
    }

    private List<T> traverseBFS(TreeNode<T> node, List<T> data) throws Exception {
        data.add(node.getData());
        if (node.getLeftChild() != null)
            queue.add(node.getLeftChild());
        if (node.getRightChild() != null)
            queue.add(node.getRightChild());
        if (!queue.isEmpty())
            traverseBFS(queue.remove(), data);
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
