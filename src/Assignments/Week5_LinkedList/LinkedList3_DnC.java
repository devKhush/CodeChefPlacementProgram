package Assignments.Week5_LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

public class LinkedList3_DnC {
    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    private static Node merge(Node h1, Node h2){
        Node dummy = new Node(-1), ptr = dummy;
        while (h1 != null || h2 != null){
            int val1 = h1 != null ? h1.val : Integer.MAX_VALUE;
            int val2 = h2 != null ? h2.val : Integer.MAX_VALUE;
            if (val1 <= val2){
                ptr.next = h1;
                h1 = h1.next;
            }
            else{
                ptr.next = h2;
                h2 = h2.next;
            }
            ptr = ptr.next;
        }
        return dummy.next;
    }

    private static Node mergeKLists(int low, int high, ArrayList<Node> allLists){
        if (low > high)
            return null;
        if (low == high)
            return allLists.get(low);

        int mid = low + ((high - low)>>1);
        Node l1 = mergeKLists(low, mid, allLists);
        Node l2 = mergeKLists(mid + 1, high, allLists);
        return merge(l1, l2);
    }

    public static void main(String[] args) {
        int k = sc.nextInt();
        ArrayList<Node> allLists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();
            allLists.add(getList(n));
        }

        Node ptr = mergeKLists(0, k - 1, allLists);
        while (ptr != null){
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
        System.out.println();
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
    private static Scanner sc = new Scanner(System.in);
}
