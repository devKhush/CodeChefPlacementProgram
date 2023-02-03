package Week4_Sorting.Practise;
import java.util.Scanner;

public class ChefAndTheWildcardMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();

            boolean answerFound = true;
            for (int i = 0; i < s1.length(); i++){
                if (s1.charAt(i)=='?' || s2.charAt(i)=='?')
                    continue;
                else if (s1.charAt(i) != s2.charAt(i)){
                    answerFound = false;
                    break;
                }
            }
            if (answerFound)
                System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
