package data_structures.linear.linked_lists;

import java.util.NoSuchElementException;

class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }

        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public int indexOf(int data) {
        if (!isEmpty()) {
            Node temp = head;
            for (int i = 0; temp != null; i++) {
                if (data == temp.data) {
                    return i;
                }
            }
        }

        return -1;
    }

    public boolean contains(int data) {
        return indexOf(data) != -1;
    }

    public void insertAtStart(int data) {
        Node newNode = new Node(data); // creates a new node instance
        if (isEmpty()) { // case-I: if the linked list if empty
            head = newNode;
        } else { // case-II: if the linked list is not empty
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtLast(int data) {
        Node newNode = new Node(data); // creates a new node instance
        if (isEmpty()) { // case-I: if the linked list if empty
            insertAtStart(data);
        } else { // case-II: if the linked list is not empty
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void insertAtPosition(int position, int data) {
        if (isEmpty() && position != 1) { // if the linked list is empty or the position is out of bounds`
            throw new IllegalArgumentException("Empty");
        }

        int size = size();
        int index = position - 1;

        if (index > size || index < 0) {
            throw new IllegalArgumentException("Empty");
        }

        if (index == 0) { // if the new node is to be inserted as the start of the linked list
            insertAtStart(data);
            return;
        }

        if (index == size) {
            insertAtLast(data);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) { // take the cursor till the given position
            temp = temp.next;
        }
        Node newNode = new Node(data); // creates a new node instance
        // insert the new node at the given position
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void displayList() {
        if (head == null) {
            throw new NoSuchElementException("Empty");
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("EOL");
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();

        myList.insertAtStart(4);
        myList.insertAtLast(5);
        myList.insertAtStart(3);
        myList.displayList();

        myList.insertAtPosition(2, 10);
        myList.displayList();
    }
}