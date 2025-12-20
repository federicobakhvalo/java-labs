package _3._5;

public class BinaryTree {

    Node root;

    void insert(int data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node current, int data) {
        if (current == null)
            return new Node(data);
        if (data < current.value)
            current.left = insertRecursive(current.left, data);
        else if (data > current.value)
            current.right = insertRecursive(current.right, data);
        return current;
    }

    boolean search(int key) {
        return searchRecursive(root, key);
    }

    private boolean searchRecursive(Node current, int key) {
        if (current == null)
            return false;
        if (key == current.value)
            return true;
        return key < current.value ? searchRecursive(current.left, key) : searchRecursive(current.right, key);
    }

    void printTree(Node node) { // Прямой обход (Сверху-вниз)
        if (node != null) {
            System.out.print(node.value + " ");
            printTree(node.left);
            printTree(node.right);
        }
    }
}

