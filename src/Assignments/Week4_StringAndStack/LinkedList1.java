package Assignments.Week4_StringAndStack;
import java.util.Scanner;

public class LinkedList1 {
    private static Scanner sc = new Scanner(System.in);
    static class Node{
        int val;
        Node next;
        Node(int x){
            val = x; next = null;
        }
    }

    private static Node createList(int n){
        Node head = null, ptr = null;
        for (int i = 0; i < n; i++){
            Node node = new Node(sc.nextInt());
            if (ptr == null){
                head = node;
                ptr = node;
            }
            else{
                ptr.next = node;
                ptr = ptr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int t = sc.nextInt();

        while (t-- > 0){
            int len = sc.nextInt();
            int n = sc.nextInt();

            Node head = createList(len);
            Node ptr = head;
            int index = len - n;
            int count = 0;

            while (count++ < index) {
                ptr = ptr.next;
            }
            System.out.println(ptr.val);
        }
    }
}
