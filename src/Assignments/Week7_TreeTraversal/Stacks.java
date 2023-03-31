package Assignments.Week7_TreeTraversal;
import java.util.ArrayList;
import java.util.Scanner;

public class Stacks {
    private static int search(ArrayList<Integer> list, int val){
        int low = 0, high = list.size() - 1;
        while (low <= high){
            int mid = low + ((high - low)>>1);
            if (list.get(mid) <= val)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();
            ArrayList<Integer> stack  = new ArrayList<>();

            for (int i = 0; i < n; i++){
                int val = sc.nextInt();
                int ind = search(stack, val);
                if (ind == stack.size())
                    stack.add(val);
                else
                    stack.set(ind, val);
            }
            System.out.print(stack.size() + " ");
            for (int val : stack)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}
