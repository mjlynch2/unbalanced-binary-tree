import java.util.logging.Logger;

public class UnbalancedBT {

//    create an empty binary tree
    public UnbalancedBT() {
        head = null;
    }

    class Node {
        private int value;
        private Node left, right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node head;

    private int size = 0;

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public boolean find(int x, Node nodeToCheck) {
        if (nodeToCheck == null) {
            return false;
        }
        if (nodeToCheck.value > x) {
            return (find(x, nodeToCheck.left));
        } else if (nodeToCheck.value < x) {
            return (find(x, nodeToCheck.right));
        } else {
            return true;
        }
    }

    public void insert(int value){
        head = insert(value, head);
        size++;
    }

    public Node insert(int valueToAdd, Node nodeToCheck) {
        Node newNode = new Node(valueToAdd);
        if(nodeToCheck == null) {
            return newNode;
        }

        if (nodeToCheck.value > valueToAdd) {
            nodeToCheck.left = insert(valueToAdd, nodeToCheck.left);
        } else if (nodeToCheck.value < valueToAdd) {
            nodeToCheck.right = insert(valueToAdd, nodeToCheck.right);
        }
        return nodeToCheck;
    }

    public static void main (String[] args) {
        UnbalancedBT t = new UnbalancedBT();
        t.insert(3);
        t.insert(1);
        t.insert(4);
        t.insert(7);
        t.insert(5);
        t.insert(2);
        t.insert(12);
        t.insert(9);
    }

}
