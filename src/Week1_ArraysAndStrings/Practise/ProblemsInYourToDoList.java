package Week1_ArraysAndStrings.Practise;
import java.util.Scanner;

public class ProblemsInYourToDoList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            int remove = 0;
            for (int j = 0; j < n; j++){
                if (sc.nextInt() >= 1000)
                    remove += 1;
            }
            System.out.println(remove);
        }
    }
}
