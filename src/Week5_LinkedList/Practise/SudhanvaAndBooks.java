package Week5_LinkedList.Practise;
import java.util.Scanner;
import java.util.Stack;

public class SudhanvaAndBooks {
    public static void main (String[] args) throws java.lang.Exception{
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        sc.nextLine();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < q; i++) {
            String[] inp = sc.nextLine().split(" ");
            int option = Integer.parseInt(inp[0]);

            if (option == -1) {
                if (!stack.isEmpty())
                    System.out.println(stack.pop());
                else
                    System.out.println("kuchbhi?");
            } else {
                int num = Integer.parseInt(inp[1]);
                stack.push(num);
            }
        }

        sc.close();
    }
}
