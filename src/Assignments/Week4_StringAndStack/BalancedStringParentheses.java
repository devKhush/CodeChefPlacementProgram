package Assignments.Week4_StringAndStack;
import java.util.Scanner;
import java.util.Stack;

public class BalancedStringParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            String s = sc.next();
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;

            for (int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);

                if (ch == '}'){
                    if (stack.isEmpty() || stack.peek() != '{'){
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
                else if (ch == ')'){
                    if (stack.isEmpty() || stack.peek() != '('){
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
                else if (ch == ']'){
                    if (stack.isEmpty() || stack.peek()!='['){
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
                else
                    stack.push(ch);
            }

            System.out.println(isValid ? 1 : 0);
        }
    }
}
