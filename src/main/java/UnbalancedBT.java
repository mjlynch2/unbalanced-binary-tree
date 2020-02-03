import java.util.logging.Logger;

public class UnbalancedBT {

    public UnbalancedBT() {
        head = null;
    }

    class Node {
        private int value;
        private Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node curr;

    private int size = 0;

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public int find(int x) {
        curr = head;
        while(curr != null){
            if(x < curr.value){
                curr = curr.left;
            } else if (x > curr.value) {
                curr = curr.right;
            } else {
                return curr.value;
            }
        }
        return x;
    }

    public void insert(int valueToAdd) {
        Node newNode = new Node(valueToAdd);
        if(head == null) {
            head = newNode;
//            return;
        }

        if(find(valueToAdd) == valueToAdd) {
            return;
        } else if (curr.value < valueToAdd) {
            curr.left.value = valueToAdd;
        } else {
            curr.right.value = valueToAdd;
        }
    }

    public static void main (String[] args) {
        UnbalancedBT t = new UnbalancedBT();
        t.insert( 4);
        System.out.println("inserted 4");
        t.insert( 5);
        System.out.println("inserted 5");
        t.insert(1);
        System.out.println("inserted 1");
    }

}
