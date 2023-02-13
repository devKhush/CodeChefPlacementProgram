package Assignments.Week5_LinkedList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LinkedList3 {
    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    static class NodeComparator implements Comparator<Node>{
        @Override
        public int compare(Node a, Node b){
            return a.val - b.val;
        }
    }

    // Solution
    private static Node mergeKLists(ArrayList<Node> allLists){
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new NodeComparator());
        for (Node node : allLists)
            minHeap.add(node);

        Node dummy = new Node(-1), ptr = dummy;
        while (!minHeap.isEmpty()){
            Node minNode = minHeap.remove();
            if (minNode.next != null)
                minHeap.add(minNode.next);
            ptr.next = minNode;
            ptr = ptr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int K = sc.nextInt();
        ArrayList<Node> lists = new ArrayList<>();

        for (int i = 0; i < K; i++){
            int n = sc.nextInt();
            lists.add(getList(n));
        }

        Node ptr = mergeKLists(lists);
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
