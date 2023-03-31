package Practise.Week8_TreeTraversal;
import java.util.HashMap;
import java.util.Scanner;

public class TollCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        int cost = 0;

        for (int i = 0; i < n; i++){
            String mode = sc.next();
            String plate = sc.next();
            int time = sc.nextInt();

            if (map.containsKey(plate)){
                int spent = time - map.get(plate);
                int hrs = Math.round(spent / 60f);
                if (hrs >= 1){
                    cost += 60;
                    cost += (hrs - 1) * 30;
                }
            }
            else
                map.put(plate, time);
        }
        System.out.println(cost);
    }
}
