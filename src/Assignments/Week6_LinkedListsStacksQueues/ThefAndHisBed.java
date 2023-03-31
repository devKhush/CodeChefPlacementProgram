package Assignments.Week6_LinkedListsStacksQueues;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ThefAndHisBed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();
            int q = sc.nextInt();

            long sum = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Value> maxHeap = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                sum += val;
                map.put(val, map.getOrDefault(val, 0) + 1);
                maxHeap.add(new Value(val, map.get(val)));
            }

            for (int i = 0; i < q; i++){
                int query = sc.nextInt();
                if (query == 1){
                    int val = sc.nextInt();
                    sum += val;
                    n++;
                    map.put(val, map.getOrDefault(val, 0) + 1);
                    maxHeap.add(new Value(val, map.get(val)));
                }
                else if (query == 2){
                    System.out.println(sum / n);
                }
                else{
                    System.out.println(maxHeap.peek().val);
                }
            }
        }
    }

    static class Value implements Comparable<Value>{
        int val, freq;
        public Value(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
        @Override
        public int compareTo(Value b){
            if (this.freq != b.freq)
                return b.freq - this.freq;
            return this.val - b.val;
        }
    }
}

// TODO: Assignment -> 6, 8, 9, 10
// TODO: Practise -> 7, 8, 9, 10