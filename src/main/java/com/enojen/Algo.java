package com.enojen;


public class Algo {

    public static void main(String[] args) {
       /* Scanner input = new Scanner(System.in);
        System.out.println("Enter size of arr:");
        int sizeOfArr = input.nextInt();
        int[] arr = new int[sizeOfArr];
        System.out.println("Enter the number you want to find:");
        int numberWantToFind = input.nextInt();
        System.out.println("Enter " + sizeOfArr + " number(s) to create arr:");

        for (int i = 0; i < sizeOfArr; i++) {
            arr[i] = input.nextInt();
        }

        System.out.println(find(sizeOfArr, arr, numberWantToFind));
        System.out.println(findWithBinarySearch(arr, 0, sizeOfArr - 1, numberWantToFind));
        int[] arr1 = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};

        System.out.println(findWithJumpSearch(arr1, 144));*/

        Node a = newNode(1);
        a.next = newNode(2);
        a.next.next = newNode(3);
        a.next.next.next = newNode(4);

        Node b = newNode(1);
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

    static boolean findlist(Node first, Node second) {
        Node ptr1 = first, ptr2 = second;
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

    static Node newNode(int key) {
        Node temp = new Node();
        temp.data = key;
        temp.next = null;
        return temp;
    }

    static int findWithJumpSearch(int[] arr, int numberWantToFind) {
        int step = (int) Math.floor(Math.sqrt(arr.length));
        int prev = 0;
        while (arr[step - 1] < numberWantToFind) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(arr.length));
        }


        while (arr[prev] < numberWantToFind) {
            prev++;
            if (prev == step)
                return -1;
        }
        if (arr[prev] == numberWantToFind)
            return prev;


        return -1;
    }

    static int find(int sizeOfArr, int[] arr, int numberWantToFind) {
        int result = -1;

        for (int i = 0; i < sizeOfArr; i++) {
            if (arr[i] == numberWantToFind) {
                result = i;
            }
        }
        return result;
    }

    static int findWithBinarySearch(int[] arr, int left, int right, int numberWantToFind) {
        if (right >= 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == numberWantToFind)
                return mid;
            if (arr[mid] > numberWantToFind)
                return findWithBinarySearch(arr, left, mid - 1, numberWantToFind);

            return findWithBinarySearch(arr, mid + 1, right, numberWantToFind);
        }
        return -1;
    }

    static void print(Node node) {
        while (node != null) {
            System.out.printf("%d", node.data);
            node = node.next;
        }
    }

    static class Node {
        int data;
        Node next;
    }

}
