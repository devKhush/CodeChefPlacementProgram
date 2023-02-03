package Practise.Week1_ArraysAndStrings;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumNumberOfPizza {
    private static int gcd(int a, int b){
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader  bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        for (int i = 0; i < t; i++){
            String[] input = bf.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            long lcm = n / gcd(n, k);
            System.out.println(lcm);
        }
    }
}
