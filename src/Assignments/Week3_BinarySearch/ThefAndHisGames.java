package Assignments.Week3_BinarySearch;

import java.util.Scanner;

public class ThefAndHisGames {
    public static void main (String[] args) throws java.lang.Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){

            String[] inp = sc.nextLine().split(" ");
            String a = inp[0];
            String b = inp[1];

            if (a.substring(1).equals(b.substring(1))){
                System.out.println("Yes");
                continue;
            }
            String a_rev = (new StringBuilder(a).reverse()).toString();
            if (a_rev.substring(1).equals(b.substring(1))){
                System.out.println("Yes");
                continue;
            }
            String b_rev = (new StringBuilder(b).reverse()).toString();
            if (b_rev.substring(1).equals(a.substring(1))){
                System.out.println("Yes");
                continue;
            }
            System.out.println("No");
        }
    }
}
