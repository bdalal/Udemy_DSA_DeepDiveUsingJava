package deepdive.tree.commons;

public class TreeNode<T> {
    private TreeNode<T> parent;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;
    private T data;
    private boolean isRoot;
    private int depth;

    private TreeNode() {
    }

    public TreeNode(T data) {
        this.data = data;
        isRoot = false;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public boolean isLeaf() {
        return getLeftChild() == null && getRightChild() == null;
    }

    public void setRoot() {
        isRoot = true;
    }

}
