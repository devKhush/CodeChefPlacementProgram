package Practise.Week8_TreeTraversal;
import java.util.HashSet;
import java.util.Scanner;

public class ZennyAndSimpleSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();
            HashSet<Integer> pos = new HashSet<>();
            HashSet<Integer> neg = new HashSet<>();
            for (int i = 0; i < n; i++){
                int val = sc.nextInt();
                if (val > 0)
                    pos.add(val);
                else if (val < 0)
                    neg.add(val);
            }
            int sumPos = 0, sumNeg = 0;
            for (int val : pos)
                sumPos += val;
            for (int val : neg)
                sumNeg += val;
            System.out.println(sumPos + " " + sumNeg);
        }
    }
}
