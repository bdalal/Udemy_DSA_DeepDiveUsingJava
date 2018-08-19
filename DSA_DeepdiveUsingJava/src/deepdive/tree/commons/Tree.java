package deepdive.tree.commons;

import java.util.List;

public interface Tree<T> {

    enum TraverseMode {
        LNR, LRN, NLR, BFS
    }

    void insert(T data) throws Exception;

    TreeNode<T> get(T data);

    T min();

    T max();

    int depth(T data);

    int depth();

    int height(T data);

    T delete(T data);

    List<T> traverse(String t);

}
