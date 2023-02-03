package Practise.Week2_Sorting;
import java.util.Scanner;

public class CoinsAndTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int S = sc.nextInt();

            // AP formula
            int ans = 1;
            for (int n = 1; n <=Integer.MAX_VALUE/2; n++){
                if (n*n + n <= 2*S)
                    ans = n;
                else break;
            }
            System.out.println(ans);
        }
    }
}
