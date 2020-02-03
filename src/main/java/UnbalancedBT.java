import java.util.logging.Logger;

public class UnbalancedBT {

    public UnbalancedBT() {
        head = null;
    }

    static class Node {
        private int value;
        private Node left, right;

        Node(int value) {
            this.value = value;
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
            return (find(x, nodeToCheck.right));
        } else if (nodeToCheck.value < x) {
            return (find(x, nodeToCheck.left));
        } else {
            return true;
        }
    }

    public Node insert(int valueToAdd, Node nodeToCheck) {
        Node newNode = new Node(valueToAdd);
        if(nodeToCheck == null) {
            return newNode;
        }
        if (nodeToCheck.value > valueToAdd) {
            return (insert(valueToAdd, nodeToCheck.right));
        } else if (nodeToCheck.value < valueToAdd) {
            return (insert(valueToAdd, nodeToCheck.left));
        } else {
            ;
        }
        return nodeToCheck;
    }

    public static void main (String[] args) {
        UnbalancedBT t = new UnbalancedBT();
        t.head = new Node(3);
        t.insert( 4, t.head );
        System.out.println("inserted 4");
        t.insert( 5, t.head);
        System.out.println("inserted 5");
        t.insert(1, t.head);
        System.out.println("inserted 1");
        t.find(1, t.head);
    }

}
