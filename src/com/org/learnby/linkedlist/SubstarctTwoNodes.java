package com.org.learnby.linkedlist;

public class SubstarctTwoNodes {
    static class Node {
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    Node head;

    // Function to remove leading zeros from the linked list
    private static Node removeLeadingZeros(Node head)
    {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }

    // Function to subtract two numbers represented as
    // linked lists
    public static Node subtract(Node l1, Node l2)
    {
        // Remove leading zeros
        l1 = removeLeadingZeros(l1);
        l2 = removeLeadingZeros(l2);

        // Reverse both linked lists
        l1 = reverse(l1);
        l2 = reverse(l2);

        // Determine which linked list represents the larger
        // number
        Node larger = getLarger(l1, l2);

        Node result = null;
        Node prev = null;
        int borrow = 0;

        // Traverse both linked lists simultaneously and
        // subtract
        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.data : 0;
            int val2 = (l2 != null) ? l2.data : 0;

            int diff = val1 - val2 - borrow;

            if (diff < 0) {
                diff += 10;
                borrow = 1;
            }
            else {
                borrow = 0;
            }

            // Create a new node for the result
            Node newNode = new Node(diff);

            if (result == null) {
                result = newNode;
            }
            else {
                prev.next = newNode;
            }
            prev = newNode;

            // Move to the next nodes
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        // Reverse the result linked list
        result = reverse(result);

        return result;
    }

    // Function to reverse a linked list
    private static Node reverse(Node head)
    {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Function to determine which linked list represents
    // the larger number
    private static Node getLarger(Node l1, Node l2)
    {
        while (l1 != null && l2 != null) {
            if (l1.data > l2.data) {
                return l1;
            }
            else if (l2.data > l1.data) {
                return l2;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        // If both numbers are equal, return either linked
        // list
        return l1 != null ? l1 : l2;
    }

    // Function to print the linked list
    public static void printList(Node head)
    {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();

        // Example input
        Node l1 = new Node(1);
        l1.next = new Node(0);
        l1.next.next = new Node(0);

        Node l2 = new Node(1);

        System.out.println("Input Lists:");
        printList(l1);
        printList(l2);

        Node result = subtract(l1, l2);

        System.out.println("Subtraction Result:");
        printList(result);
    }
}
