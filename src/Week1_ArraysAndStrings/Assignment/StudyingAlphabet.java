package Week1_ArraysAndStrings.Assignment;
import java.util.Scanner;

public class StudyingAlphabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String learned = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();

        loop:
        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();

            for (int j = 0; j < learned.length(); j++)
                if (!learned.contains(Character.toString(word.charAt(j)))) {
                    System.out.println("No");
                    continue loop;
                }
            System.out.println("Yes");
        }
        sc.close();
    }
}
