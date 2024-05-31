package Assignment;
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // Method to insert a node at a specified position
    public void insertAtPos(int data, int pos) {
        Node newNode = new Node(data);
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            for (int i = 1; i < pos - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp != null) {
                newNode.next = temp.next;
                temp.next = newNode;
            } else {
                System.out.println("Invalid position");
            }
        }
    }

    // Method to delete a node at a specified position
    public void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (pos == 1) {
            head = head.next;
        } else {
            Node temp = head;
            for (int i = 1; i < pos - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp != null && temp.next != null) {
                temp.next = temp.next.next;
            } else {
                System.out.println("Invalid position");
            }
        }
    }

    // Method to delete the node after a given node
    public void deleteAfterNode(Node prevNode) {
        if (prevNode == null || prevNode.next == null) {
            System.out.println("No node to delete after");
            return;
        }
        prevNode.next = prevNode.next.next;
    }

    // Method to search for a node with specific value
    public boolean searchNode(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}

class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    // Method to push an element onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    // Method to pop an element from the stack
    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1; // or throw an exception
        } else {
            int data = top.data;
            top = top.next;
            return data;
        }
    }

    // Method to peek the top element of the stack
    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return top.data;
        }
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtPos(1, 1);
        list.insertAtPos(2, 2);
        list.insertAtPos(3, 3);
        list.insertAtPos(4, 4);

        list.deleteAtPosition(3);

        Node node = list.head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();

        System.out.println("Is 2 present in the list? " + list.searchNode(2));

        Stack stack = new Stack();
        stack.push(50);
        stack.push(60);
        stack.push(70);

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek after pop: " + stack.peek());
    }
}
