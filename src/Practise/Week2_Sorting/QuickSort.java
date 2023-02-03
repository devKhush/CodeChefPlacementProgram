package Practise.Week2_Sorting;
import java.util.Scanner;

public class QuickSort {
    private static int partition(int low, int high, int[] arr){
        int i = low + 1, j = high;
        int pivot = arr[low];

        while (i <= j){
            while (i <= high && arr[i] <= pivot)
                i++;
            while (j > low && arr[j] > pivot)
                j--;
            if (i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[low] = arr[j];
        arr[j] = pivot;
        return j;
    }

    private static void quickSort(int low ,int high, int[] arr){
        if (low >= high)
            return;
        int partitionIndex = partition(low, high, arr);
        quickSort(low, partitionIndex - 1, arr);
        quickSort(partitionIndex + 1, high, arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        quickSort(0, n - 1, arr);

        for (int i = 0; i < n; i++)
            System.out.println(arr[i]);
    }
}
