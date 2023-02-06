package Assignments.Week4_StringAndStack;
import java.util.Scanner;
import java.util.Stack;

public class OptimalAdjacentRemoval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            String s = sc.next();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);

                if (!stack.isEmpty() && stack.peek() == ch)
                    stack.pop();
                else
                    stack.push(ch);
            }
            System.out.println(stack.size());
        }
    }
}
