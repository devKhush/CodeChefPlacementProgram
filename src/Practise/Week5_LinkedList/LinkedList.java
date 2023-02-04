package Practise.Week5_LinkedList;
import java.util.Scanner;

public class LinkedList {
    static class Node{
        int val;
        Node next;
        public Node(int x){
            this.val = x;
            this.next = null;
        }
    }

    private static final Scanner sc = new Scanner(System.in);

    public static Node merge(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        Node dummy, ptr;
        if (head1.val < head2.val){
            dummy = head1;
            ptr = head1;
            head1 = head1.next;
        }
        else{
            dummy = head2;
            ptr = head2;
            head2 = head2.next;
        }

        // Node dummy = new Node(-1);
        // Node ptr = dummy;

        while (head1 != null || head2 != null){
            int val1 = head1 != null ? head1.val : Integer.MAX_VALUE;
            int val2 = head2 != null ? head2.val : Integer.MAX_VALUE;
            if (val1 <= val2){
                ptr.next = head1;
                head1 = head1.next;
            }
            else{
                ptr.next = head2;
                head2 = head2.next;
            }
            ptr = ptr.next;
        }
        // return dummy.next;
        return dummy;
    }


    private static Node getList(int n){
        Node head = null, ptr = null;
        for (int i = 0; i < n; i++){
            int val = sc.nextInt();
            if (head == null) {
                head = new Node(val);
                ptr = head;
            }
            else{
                ptr.next = new Node(val);
                ptr = ptr.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            Node h1 = getList(n1);
            Node h2 = getList(n2);
            Node finalList = merge(h1, h2);
            Node ptr = finalList;
            while (ptr != null){
                System.out.print(ptr.val + " ");
                ptr = ptr.next;
            }
        }
    }
}


