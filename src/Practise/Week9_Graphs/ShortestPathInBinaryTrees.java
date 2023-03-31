package Practise.Week9_Graphs;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ShortestPathInBinaryTrees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            ArrayList<Integer> pathA = new ArrayList<>();
            ArrayList<Integer> pathB = new ArrayList<>();
            while (a >= 1){
                pathA.add(0, a);
                a /= 2;
            }
            while (b >= 1){
                pathB.add(0, b);
                b /= 2;
            }
            int i = pathA.size(), j = pathB.size();
            int lca = -1, k = 0;
            for (k = 0; k < Math.min(i, j); k++){
                if (Objects.equals(pathA.get(k), pathB.get(k)))
                    lca = pathA.get(k);
                else break;
            }
            System.out.println(i - k + j - k);
        }
    }
}
