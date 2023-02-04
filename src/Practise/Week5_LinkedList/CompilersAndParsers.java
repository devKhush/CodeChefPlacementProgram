package Practise.Week5_LinkedList;
import java.util.Scanner;

public class CompilersAndParsers {
    public static void main (String[] args) throws java.lang.Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            String s = sc.nextLine();
            int maxPrefixSize = 0;
            int lessNum = 0;

            for (int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);

                if (ch == '<')
                    lessNum++;
                else
                    lessNum--;
                if (lessNum < 0)
                    break;
                if (lessNum == 0)
                    maxPrefixSize = i + 1;
            }
            System.out.println(maxPrefixSize);
        }
    }
}