package Practise.Week8_TreeTraversal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MaximumPossibleSweetness {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();
            int money = sc.nextInt();
            int[] price = new int[n];
            int[] sweet = new int[n];
            for (int i = 0; i < n; i++)
                price[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                sweet[i] = sc.nextInt();

            ArrayList<Sweet> list = new ArrayList<>();
            for (int i = 0; i < n; i++){
                list.add(new Sweet(price[i], sweet[i], sweet[i]/(double)price[i]));
            }
            list.sort(new MyComparator());

            int limit = 2;
            int sweetness = 0;
            for (int i = 0; i < n; i++){
                Sweet swt = list.get(i);
                if (money >= swt.price && limit > 0){
                    sweetness += swt.sweet;
                    money -= swt.price;
                    limit--;
                }
            }
            System.out.println(sweetness);
        }
    }

    static class Sweet{
        int price;
        int sweet;
        double sweetnessPerPrice;
        public Sweet(int price, int sweet, double sweetnessPerPrice) {
            this.price = price;
            this.sweet = sweet;
            this.sweetnessPerPrice = sweetnessPerPrice;
        }

        @Override
        public String toString(){
            return "Sweet{sweet:" + sweet + ", price:" + price + ", spp:" + sweetnessPerPrice + "}";
        }
    }

    static class MyComparator implements Comparator<Sweet>{
        @Override
        public int compare(Sweet a, Sweet b){
            if (b.sweetnessPerPrice > a.sweetnessPerPrice)
                return 1;
            else if (a.sweetnessPerPrice > b.sweetnessPerPrice)
                return -1;
            return b.price - a.price;
        }
    }
}
