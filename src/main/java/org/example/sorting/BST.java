package org.example.sorting;

public class BST {
    class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    Node root;

    public BST() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (root.key < key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    void inOrder() {
        inOrderSec(root);
    }

    private void inOrderSec(Node root) {
        if(root != null) {
            inOrderSec(root.left);
            System.out.printf("root = %d\n", root.key);
            inOrderSec(root.right);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the given tree:");
        tree.inOrder();
    }
}
