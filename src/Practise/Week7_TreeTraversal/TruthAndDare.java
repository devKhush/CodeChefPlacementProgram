package Practise.Week7_TreeTraversal;
import java.util.HashSet;
import java.util.Scanner;

public class TruthAndDare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            HashSet<Integer> truthRam = new HashSet<>();
            HashSet<Integer> dareRam = new HashSet<>();

            int tr = sc.nextInt();
            for (int i = 0; i < tr; i++)
                truthRam.add(sc.nextInt());

            int dr = sc.nextInt();
            for (int i = 0; i < dr; i++)
                dareRam.add(sc.nextInt());

            boolean ranCanWin = true;

            int ts = sc.nextInt();
            for (int i = 0; i < ts; i++){
                int task = sc.nextInt();
                if (!truthRam.contains(task))
                    ranCanWin = false;
            }

            int ds = sc.nextInt();
            for (int i = 0; i < ds; i++){
                int task = sc.nextInt();
                if (!dareRam.contains(task))
                    ranCanWin = false;
            }
            if (ranCanWin)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
