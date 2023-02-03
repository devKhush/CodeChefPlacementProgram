package Week4_Sorting.Practise;
import java.util.Scanner;

public class MakeThemEqual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
                max = Math.max(max, arr[i]);
            }
            int op = 0;
            for (int i = 0; i < n; i++){
                op = Math.max(op, max - arr[i]);
            }
            System.out.println(op);
        }
    }
}
