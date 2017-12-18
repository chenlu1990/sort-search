package com.example.demo.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenlu on 2017/12/5.
 */
public class BinaryTreeTest {
    private int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static List<Node> nodeList = null;

    public void createBinTree() {
        nodeList = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            nodeList.add(new Node(array[i]));
        }
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
        }
        int lastParentIndex = array.length / 2 - 1;
        nodeList.get(lastParentIndex).leftChild = nodeList.get(lastParentIndex * 2 + 1);
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList.get(lastParentIndex * 2 + 2);
        }
    }

    //先序遍历
    public static void preOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    //中序遍历
    public static void inOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);
    }

    //后续遍历
    public static void postOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinaryTreeTest bTree = new BinaryTreeTest();
        bTree.createBinTree();
        System.out.print("原始数据：");
        for (Node node : nodeList) {
            System.out.print(node.data + " ");
        }
        System.out.println();
        Node root = nodeList.get(0);
        System.out.print("先序遍历：");
        preOrderTraverse(root);
        System.out.println();
        System.out.print("中序遍历：");
        inOrderTraverse(root);
        System.out.println();
        System.out.print("后序遍历：");
        postOrderTraverse(root);
    }

}

class Node {
    Node leftChild;
    Node rightChild;
    int data;

    Node(int data) {
        leftChild = null;
        rightChild = null;
        this.data = data;
    }
}
