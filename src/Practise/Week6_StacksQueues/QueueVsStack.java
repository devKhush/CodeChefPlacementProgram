package Practise.Week6_StacksQueues;
import java.util.Scanner;
import java.util.Stack;

public class QueueVsStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0; i < q; i++){
            int op = sc.nextInt();
            if (op == 1){
                int num = sc.nextInt();
                stack1.push(num);
            }
            else if (op == 2){
                while (!stack1.isEmpty())
                    stack2.push(stack1.pop());
                stack2.pop();
                while (!stack2.isEmpty())
                    stack1.push(stack2.pop());
            }
            else{
                while (!stack1.isEmpty())
                    stack2.push(stack1.pop());
                System.out.println(stack2.peek());
                while (!stack2.isEmpty())
                    stack1.push(stack2.pop());
            }
        }
    }
}
