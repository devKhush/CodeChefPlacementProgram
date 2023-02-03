package Week1_ArraysAndStrings.Practise;
import java.util.Scanner;

public class TheBlockGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            int N = n, rev = 0;

            while (n != 0){
                rev = rev*10 + n % 10;
                n /= 10;
            }
            if (rev == N)
                System.out.println("wins");
            else
                System.out.println("loses");
        }
    }
}
