package Practise.Week8_TreeTraversal;
import java.util.HashMap;
import java.util.Scanner;

public class NothingInCommon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int m = sc.nextInt();
            int n = sc.nextInt();
            HashMap<Integer, Integer> alice = new HashMap<>();

            for (int i = 0; i < m; i++){
                int val = sc.nextInt();
                alice.put(val, alice.getOrDefault(val, 0) + 1);
            }
            int remove = 0;
            for (int i = 0; i < n; i++){
                int val = sc.nextInt();
                if (alice.containsKey(val))
                    remove += alice.get(val);
            }
            System.out.println(remove);
        }
    }
}
