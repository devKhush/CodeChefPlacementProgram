package Week3_BinarySearch.Practise;
import java.util.Scanner;
import java.util.Stack;

public class A_Books {
    /*************************** Method 1 using Stack of next greater element *********************/
    public static void usingNextGreaterElement(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] nextGreater = new int[n];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++){
                while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                    nextGreater[stack.pop()] = n - i;
                }
                stack.push(i);
            }
            for (int i = 0; i < n-1; i++)
                System.out.print(nextGreater[i] + " ");
            System.out.println(nextGreater[n-1]);
        }
    }

    /********************************* Method 2 using Binary search *******************************/
    private static int findNextGreaterElement(int[] arr, int n, int val){
        int low = 0, high = n-1;
        int ans = -1;
        while (low <= high){
            int mid = low + ((high-low)>>1);
            if (arr[mid] <= val){
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return ans + 1;
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

            for (int i = 0; i < n; i++) {
                int nextGreaterIndex = findNextGreaterElement(arr, n, arr[i]);
                System.out.print((n - nextGreaterIndex) + " ");
            }
        }
    }
}
