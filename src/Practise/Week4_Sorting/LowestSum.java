package Practise.Week4_Sorting;
import java.util.*;

public class LowestSum {
    /************************************** Smart & Efficient Solution ************************************/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            long[] A = new long[n];
            long[] B = new long[n];
            int[] queries = new int[q];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextLong();
            }
            for (int i = 0; i < n; i++) {
                B[i] = sc.nextLong();
            }
            for (int i = 0; i < q; i++) {
                queries[i] = sc.nextInt();
            }

            Arrays.sort(A);
            Arrays.sort(B);

            PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < Math.min(n, 10000); i++){
                for (int j = 0; j < Math.min(n, 10000/(i+1)); j++) {
                    maxHeap.add(A[i] + B[j]);
                    if (maxHeap.size() > 10000)
                        maxHeap.remove();
                }
            }

            ArrayList<Long> arrayList = new ArrayList<>();
            while (!maxHeap.isEmpty())
                arrayList.add(0, maxHeap.remove());

            for (int i = 0; i < q; i++)
                System.out.println(arrayList.get(queries[i] - 1));
        }
    }


    /********************************** Brute Force Solution ***********************************************/
    public static void bruteForceSolution(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextInt();

        while (t-- > 0){
            int K = sc.nextInt();
            int Q = sc.nextInt();
            long[] A = new long[K];
            long[] B = new long[K];
            int[] queries = new int[Q];
            for (int i = 0; i < K; i++)
                A[i] = sc.nextLong();
            for (int i = 0; i < K; i++)
                B[i] = sc.nextLong();
            for (int i = 0; i < Q; i++)
                queries[i] = sc.nextInt();

            ArrayList<Long> sum = new ArrayList<>();
            for (long a1 : A)
                for (long b1 : B)
                    sum.add(a1 + b1);
            Collections.sort(sum);
            for (int query : queries){
                System.out.println(sum.get(query - 1));
            }
        }
    }
}
