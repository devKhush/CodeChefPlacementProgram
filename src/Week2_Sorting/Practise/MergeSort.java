package Week2_Sorting.Practise;
import java.util.Scanner;

public class MergeSort {
    private static void merge(int low, int mid, int high, int[] arr, int[] temp){
        int i = low, j = mid + 1, k = low;

        while (i <= mid || j <= high){
            int min_I = i <= mid ? arr[i] : Integer.MAX_VALUE;
            int min_J = j <= high ? arr[j] : Integer.MAX_VALUE;
            if (min_I <= min_J)
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }
        for (int a = low; a <= high; a++)
            arr[a] = temp[a];
    }

    private static void mergeSort(int low, int high, int[] arr, int[] temp){
        if (low >= high)
            return;
        int mid = low + (high - low)/2;
        mergeSort(low, mid, arr, temp);
        mergeSort(mid + 1, high, arr, temp);
        merge(low, mid, high, arr, temp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        mergeSort(0, n - 1, arr, new int[n]);

        for (int i = 0; i < n; i++)
            System.out.println(arr[i]);
    }
}
