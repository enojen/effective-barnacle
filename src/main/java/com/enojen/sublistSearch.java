package com.enojen;

public class sublistSearch {
    public static void main(String[] args) {

        Algo.Node a = newNode(1);
        a.next = newNode(2);
        a.next.next = newNode(3);
        a.next.next.next = newNode(4);

        Algo.Node b = newNode(1);
        b.next = newNode(2);
        b.next.next = newNode(1);
        b.next.next.next = newNode(2);
        b.next.next.next.next = newNode(3);
        b.next.next.next.next.next = newNode(4);

        print(a);
        print(b);

        boolean result = findlist(a, b);

        if (result)
            System.out.println("inside");
        else
            System.out.println("not inside");
    }

    static Algo.Node newNode(int key) {
        Algo.Node temp = new Algo.Node();
        temp.data = key;
        temp.next = null;
        return temp;
    }

    static void print(Algo.Node node) {
        while (node != null) {
            System.out.printf("%d", node.data);
            node = node.next;
        }
    }

    static boolean findlist(Algo.Node first, Algo.Node second) {
        Algo.Node ptr1 = first, ptr2 = second;
        if (first == null && second == null) {
            return true;
        }

        if (first == null || second == null) {
            return false;
        }

        while (second != null) {

            ptr2 = second;

            while (ptr1 != null) {
                if (ptr2 == null)
                    return false;
                else if (ptr1.data == ptr2.data) {
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;

                } else
                    break;
            }

            if (ptr1 == null)
                return true;

            ptr1 = first;

            second = second.next;
        }
        return false;
    }

    static class Node {
        int data;
        Algo.Node next;
    }

}
