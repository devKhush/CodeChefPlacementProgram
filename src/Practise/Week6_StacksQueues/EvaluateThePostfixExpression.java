package Practise.Week6_StacksQueues;
import java.util.Scanner;
import java.util.Stack;

public class EvaluateThePostfixExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String expression = sc.next();
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++){
                char ch = expression.charAt(i);
                if (ch == '+') {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a + b);
                }
                else if (ch == '-'){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a);
                }
                else if (ch == '*'){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a * b);
                }
                else if (ch == '/'){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                }
                else if (ch == '^'){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push((int)Math.pow(b, a));
                }
                else
                    stack.push(ch - '0');
            }
            System.out.println(stack.peek());
        }
    }
}
