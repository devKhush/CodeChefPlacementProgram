package Practise.Week7_TreeTraversal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class PlaneDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            System.out.println(solve(sc, n));
        }
    }

    private static int solve(Scanner sc, int n){
        HashMap<Double, HashSet<Double>> lines = new HashMap<>();

        for (int i = 0; i < n; i++){
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double c = sc.nextDouble();

            double slope = 1e9, intercept = 1e9;
            if (b != 0) {
                slope = -a/b;
                intercept = -c/b;
            }
            else {
                slope = 1e9;
                intercept = -c/a;
            }
            HashSet<Double> set = lines.getOrDefault(slope, new HashSet<>());
            set.add(intercept);
            lines.put(slope, set);
        }
        int largestSubset = 0;
        for (HashSet<Double> intercepts : lines.values())
            largestSubset = Math.max(largestSubset, intercepts.size());

        return largestSubset;
    }
}


/*
Python code:

t = int(input())
while t:
    t -= 1
    n = int(input())
    lines = dict()

    for i in range(n):
        a, b, c = list(map(int, input().split()))
        if b != 0:
            slope = -a/b
            intercept = -c/b
        else:
            slope = 1e9
            intercept = -c/a
        s = lines.get(slope, set())
        s.add(intercept)
        lines[slope] = s

    print(max(list(map(len, lines.values()))))
 */
