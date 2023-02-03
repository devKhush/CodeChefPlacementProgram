package Week5_LinkedList.Practise;
import java.util.Scanner;
import java.util.Stack;

public class CompilersAndParsers {
    public static void main (String[] args) throws java.lang.Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0){
            String s = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            int pairs = 0;

            for (int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if (stack.isEmpty() && ch == '>')
                    break;
                if (!stack.isEmpty() && ch == '>' && stack.peek()=='<'){
                    pairs++;
                    stack.pop();
                }
                else
                    stack.push(ch);
            }

            stack = new Stack<>();
            for (int i = 0; i < 2*pairs; i++){
                char ch = s.charAt(i);
                if (!stack.isEmpty() && ch=='>' && stack.peek()=='<'){
                    stack.pop();
                }
                else
                    stack.push(ch);
            }

            if (stack.isEmpty())
                System.out.println(2*pairs);
            else
                System.out.println(0);
        }
        sc.close();
    }
}
