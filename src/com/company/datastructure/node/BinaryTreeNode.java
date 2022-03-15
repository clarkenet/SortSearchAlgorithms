package com.company.datastructure.node;

import java.util.StringJoiner;

public class BinaryTreeNode {
    private int value;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BinaryTreeNode.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .add("left=" + left)
                .add("right=" + right)
                .toString();
    }
}
