package Practise.Week6_StacksQueues;

import java.util.Scanner;
import java.util.Stack;

public class CustomStackOperation {
    static class Node{
        int data, min;
        public Node(int data, int min){
            this.data = data;
            this.min = min;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < q; i++){
            int op = sc.nextInt();
            if (op == 1){
                int val = sc.nextInt();
                if (stack.isEmpty())
                    stack.push(new Node(val, val));
                else
                    stack.push(new Node(val, Math.min(val, stack.peek().min)));
            }
            else if (op == 2){
                stack.pop();
            }
            else if (op == 3){
                System.out.println(stack.peek().data);
            }
            else if (op == 4){
                System.out.println(stack.peek().min);
            }
        }
    }
}
