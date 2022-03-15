package com.company.datastructure;

import com.company.datastructure.node.BinaryTreeNode;

import java.util.*;

public class BinarySearchTree {
    private BinaryTreeNode root;

    public boolean insert(int value) {
        BinaryTreeNode newNode = new BinaryTreeNode(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        BinaryTreeNode temp = root;
        while (temp != null) {
            if (newNode.getValue() == temp.getValue()) {
                return false;
            }
            if (newNode.getValue() < temp.getValue()) {
                if (temp.getLeft() == null) {
                    temp.setLeft(newNode);
                    return true;
                }
                temp = temp.getLeft();
            } else {
                if (temp.getRight() == null) {
                    temp.setRight(newNode);
                    return true;
                }
                temp = temp.getRight();
            }
        }
        return false;
    }

    public boolean contains(int value) {
        if (root == null) {
            return false;
        }
        BinaryTreeNode temp = root;
        while (temp != null) {
            if (value == temp.getValue()) {
                return true;
            } else if (value < temp.getValue()) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        return false;
    }

    //Breadth First Search
    public List<Integer> bfs() {
        List<Integer> result = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        BinaryTreeNode currentNode = root;
        queue.offer(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            result.add(currentNode.getValue());
            if (currentNode.getLeft() != null) {
                queue.offer(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue.offer(currentNode.getRight());
            }
        }
        return result;
    }

    //Deep First Search: Pre-order Traverse
    private void preOrderTraverse(List<Integer> result, BinaryTreeNode node) {
        result.add(node.getValue());
        if (node.getLeft() != null) {
            preOrderTraverse(result, node.getLeft());
        }
        if (node.getRight() != null) {
            preOrderTraverse(result, node.getRight());
        }
    }

    //Deep First Search: Pre-order
    public List<Integer> dfsPreOrder() {
        List<Integer> result = new ArrayList<>();
        preOrderTraverse(result, root);
        return result;
    }

    //Deep First Search: Post-order Traverse
    private void postOrderTraverse(List<Integer> result, BinaryTreeNode node) {
        if (node.getLeft() != null) {
            postOrderTraverse(result, node.getLeft());
        }
        if (node.getRight() != null) {
            postOrderTraverse(result, node.getRight());
        }
        result.add(node.getValue());
    }

    //Deep First Search: Post-order
    public List<Integer> dfsPostOrder() {
        List<Integer> result = new ArrayList<>();
        postOrderTraverse(result, root);
        return result;
    }

    //Deep First Search: Pre-order Traverse
    private void inOrderTraverse(List<Integer> result, BinaryTreeNode node) {
        if (node.getLeft() != null) {
            inOrderTraverse(result, node.getLeft());
        }
        result.add(node.getValue());

        if (node.getRight() != null) {
            inOrderTraverse(result, node.getRight());
        }
    }

    //Deep First Search: Pre-order
    public List<Integer> dfsInOrder() {
        List<Integer> result = new ArrayList<>();
        inOrderTraverse(result, root);
        return result;
    }
}