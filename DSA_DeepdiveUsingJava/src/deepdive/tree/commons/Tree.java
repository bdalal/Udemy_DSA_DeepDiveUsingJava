package deepdive.tree.commons;

import java.util.Comparator;
import java.util.List;

public interface Tree<T> {

    enum TraverseMode {
        LNR, LRN, NLR, BFS
    }

    void insert(T data, Comparator c, TreeNode node) throws Exception;

//    void insert(T data) throws Exception;

    T get();

    T min();

    T max();

    int depth(T data);

    int depth();

    int height(T data);

    T delete(T data);

    List<T> traverse(String t);

}
