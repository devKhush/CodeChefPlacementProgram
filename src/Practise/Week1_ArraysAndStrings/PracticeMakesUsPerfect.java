package Practise.Week1_ArraysAndStrings;
import java.util.Scanner;

public class PracticeMakesUsPerfect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int count = 0;

        for (int i = 0; i < 4; i++)
            if (Integer.parseInt(arr[i]) >= 10)
                count++;
        System.out.println(count);
    }
}
