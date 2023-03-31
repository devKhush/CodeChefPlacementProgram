package Practise.Week7_TreeTraversal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortingTasks {
    // Main function
    private static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);;
        int n = sc.nextInt();
        int m = sc.nextInt();

        solve(n, m);
    }

    // Solution
    private static void solve(int n, int m){
        Value[] values = new Value[m + 1];

        for (int i = 0; i < m + 1; i++)
            values[i] = new Value(i, 0, -1);

        for (int i = 0; i < n; i++){
            int val = sc.nextInt();
            if (values[val].firstIndex == -1) {
                values[val] = new Value(val, 1, i);
            }
            else
                values[val].count++;
        }
        Arrays.sort(values, new MyComparator());

        for (int i = 0; i < m; i++){
            for (int j = 0; j < values[i].count; j++){
                System.out.print(values[i].val + " ");
            }
        }
        System.out.println();
    }

    // Value class to hash count, value, first index of occurrence
    static class Value{
        int val, count, firstIndex;
        public Value(int val, int count, int firstIndex){
            this.val = val;
            this.count = count;
            this.firstIndex = firstIndex;
        }
    }

    // Comparator to sort values
    static class MyComparator implements Comparator<Value>{
        @Override
        public int compare(Value a, Value b){
            if (a.count != b.count)
                return b.count - a.count;
            else
                return a.firstIndex - b.firstIndex;
        }
    }
}


/*
Python code:
from functools import cmp_to_key
n, m = list(map(int, input().split()))
lst = list(map(int, input().split()))

def compare(a, b):
    if a.cnt != b.cnt:
        return b.cnt - a.cnt
    return a.firstIndex - b.firstIndex

class Value:
    def __init__(self, val, cnt, first_index):
        self.val = val
        self.cnt = cnt
        self.firstIndex = first_index

freq = [Value(i, 0, -1) for i in range(m + 1)]

for i in range(n):
    val = lst[i]
    if freq[val].firstIndex == -1:
        freq[val] = Value(val, 1, i)
    else:
        freq[val].cnt += 1
freq.sort(key=cmp_to_key(compare))

for i in range(m):
    for j in range(freq[i].cnt):
        print(freq[i].val, end=' ')
print()
 */