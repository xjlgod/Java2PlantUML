package com.xjl.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingliu_xiong@foxmail.com
 */
public class Tree {
    private List<Tree> trees;
    private Tree root;
    private String name;

    public Tree(List<Tree> trees, Tree root) {
        this.trees = new ArrayList<>();
        this.root = root;
    }

    public void addTree(Tree tree) {
        trees.add(tree);
    }

    public Tree getTree(int index) {
        return trees.get(index);
    }

}
