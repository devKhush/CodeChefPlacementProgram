package Week1_ArraysAndStrings.Assignment;
import java.util.HashSet;
import java.util.Scanner;

public class ICPCBalloons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i <= 7; i++)
                set.add(i);

            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            int i = 0;
            while (i < n && !set.isEmpty()){
                if (set.contains(arr[i]))
                    set.remove(arr[i]);
                i++;
            }
            System.out.println(i);
        }
    }
}
