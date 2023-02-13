package Assignments.Week5_LinkedList;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class AsteroidHit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            // Asteroid Inputs
            int n = sc.nextInt();
            long[][] asteroids = new long[n][3];
            for (int i = 0; i < n; i++){
                asteroids[i][0] = sc.nextInt();         // direction
                asteroids[i][1] = sc.nextInt();         // size
                asteroids[i][2] = i + 1;                // index

            }
            // Stacks for Asteroids
            Stack<long[]> stack = new Stack<>();

            addAsteroids:
            for (int i = 0; i < n; i++){
                long[] currAst = asteroids[i];

                // Asteroid has Left direction
                if (currAst[0] == 0){
                    while (!stack.isEmpty()  && stack.peek()[0] == 1){
                        long[] astOnTop = stack.peek();

                        if (astOnTop[1] == currAst[1]){
                            stack.pop();
                            continue addAsteroids;
                        }
                        else if (astOnTop[1] > currAst[1]){
                            astOnTop[1] += currAst[1];
                            continue addAsteroids;
                        }
                        else {
                            currAst[1] += astOnTop[1];
                            stack.pop();
                        }
                    }
                    stack.push(currAst);
                }
                // Asteroid has Right direction
                else {
                    stack.push(currAst);
                }
            }

            // Answer: Sort all the indices and print them
            System.out.println(stack.size());
            if (!stack.isEmpty()){
                ArrayList<Long> indices = new ArrayList<>();
                while (!stack.isEmpty()){
                    indices.add(stack.pop()[2]);
                }
                indices.sort((a,b) -> (int) (a-b));
                for (long ind : indices)
                    System.out.print(ind + " ");
                System.out.println();
            }
        }
    }
}
