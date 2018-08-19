package deepdive.tree.commons;

public class TreeNode<T> {
    private TreeNode<T> parent;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;
    private T data;
    private boolean isRoot;
    private int depth;
    private boolean isLeftChild;
    private boolean isRightChild;
    private boolean hasLeftChild;
    private boolean hasRightChild;
    private int numChildren;

    private TreeNode() {
    }

    public TreeNode(T data) {
        this.data = data;
        isRoot = false;
    }

    public void incNumChildren() {
        numChildren++;
    }

    public void decNumChildren() {
        numChildren--;
    }

    public int getNumChildren() {
        return numChildren;
    }

    public void setHasRightChild(boolean hasRightChild) {
        this.hasRightChild = hasRightChild;
    }

    public void setHasLeftChild(boolean hasLeftChild) {
        this.hasLeftChild = hasLeftChild;
    }

    public boolean hasLeftChild() {
        return hasLeftChild;
    }

    public boolean hasRightChild() {
        return hasRightChild;
    }

    public void setIsLeftChild() {
        isLeftChild = true;
    }

    public void setIsRightChild() {
        isRightChild = true;
    }

    public boolean isLeftChild() {
        return isLeftChild;
    }

    public boolean isRightChild() {
        return isRightChild;
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
        return !(hasLeftChild || hasRightChild);
    }

    public void setRoot() {
        isRoot = true;
    }

}
