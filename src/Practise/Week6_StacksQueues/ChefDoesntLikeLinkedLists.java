package Practise.Week6_StacksQueues;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefDoesntLikeLinkedLists {
    static class Node{
        int data;
        Node next;
        public Node(int val){
            this.data = val;
        }
    }

    private static Node merge(Node head1, Node head2){
        Node dummy = new Node(-1), ptr = dummy;
        while (head1 != null || head2 != null){
            int val1 = head1 != null ? head1.data : Integer.MAX_VALUE;
            int val2 = head2 != null ? head2.data : Integer.MAX_VALUE;
            if (val1 <= val2) {
                ptr.next = head1;
                head1 = head1.next;
            }
            else {
                ptr.next = head2;
                head2 = head2.next;
            }
            ptr = ptr.next;

        }
        return dummy.next;
    }


    private static Node getList(int n, String[] list){
        Node head = null, ptr = null;
        for (int i = 0; i < n; i++){
            int val = Integer.parseInt(list[i]);
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


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0){
            String[] size = bf.readLine().split(" ");
            String[] l1 = bf.readLine().split(" ");
            String[] l2 = bf.readLine().split(" ");
            int n1 = Integer.parseInt(size[0]);
            int n2 = Integer.parseInt(size[1]);
            Node h1 = getList(n1, l1);
            Node h2 = getList(n2, l2);
            Node ptr = merge(h1, h2);
            while (ptr != null){
                System.out.print(ptr.data + " ");
                ptr = ptr.next;
            }
            System.out.println();
        }
    }
}
