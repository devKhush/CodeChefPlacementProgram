package Assignments.Week2_Sorting;
import java.util.ArrayList;
import java.util.Scanner;

public class StacksOfSlices {
    private static int findIndexToInsert(int[] arr, int val, ArrayList<Integer> stack){
        int low = 0, high = stack.size() - 1;
        while (low <= high){
            int mid = low + ((high - low)>>1);
            if (stack.get(mid) > val)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            ArrayList<Integer> stack = new ArrayList<>();
            stack.add(arr[0]);

            for (int i = 1; i < n; i++){
                int index = findIndexToInsert(arr, arr[i], stack);
                if (index == stack.size())
                    stack.add(arr[i]);
                else
                    stack.set(index, arr[i]);
            }

            System.out.print(stack.size() + " ");
            for (int i = 0; i < stack.size(); i++)
                System.out.print(stack.get(i) + " ");
        }
    }
}
