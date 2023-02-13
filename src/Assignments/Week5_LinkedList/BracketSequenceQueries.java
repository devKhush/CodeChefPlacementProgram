package Assignments.Week5_LinkedList;
import java.util.Scanner;

public class BracketSequenceQueries {
    public static void main(String[] args) {
        // TODO: Was unable to submit this question
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            int q = sc.nextInt();

            int[] maxLenTillIndex = new int[n];
            int currMax = 0, prevMax = 0;
            int open = 0;

            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == ')') {
                    if (open == 0) {
                        currMax = 0;
                    } else {
                        open--;
                        currMax += 2;
                    }
                    prevMax = Math.max(prevMax, currMax);
                } else {
                    open++;
                }
                maxLenTillIndex[i] = Math.max(prevMax, currMax);
            }
            // System.out.println(Arrays.toString(maxLenTillIndex));

            for (int i = 0; i < q; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                // System.out.println(a + " " + b);
                if (a == b)
                    System.out.print(0 + " ");
                else if (b - a + 1 < maxLenTillIndex[b] - maxLenTillIndex[a])
                    System.out.print((maxLenTillIndex[b] - maxLenTillIndex[a] - 2) + " ");
                else
                    System.out.print((maxLenTillIndex[b] - maxLenTillIndex[a]) + " ");
            }
            System.out.println();
        }
    }
}
