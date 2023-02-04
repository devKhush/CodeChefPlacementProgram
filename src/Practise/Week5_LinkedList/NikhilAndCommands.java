package Practise.Week5_LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

public class NikhilAndCommands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt(); sc.nextLine();
            ArrayList<String> path = new ArrayList<>();

            for (int i = 0; i < n; i++){
                String command = sc.nextLine();

                if (command.equals("pwd")){
                    for (String folder : path)
                        System.out.print("/" + folder);
                    System.out.println("/");
                }
                else{ // for command "cd"
                    String newPath = command.split(" ")[1];
                    String[] destination = newPath.split("/");
                    int index = 0;

                    if (destination.length == 0){
                        // for case "cd /"
                        path.clear();
                    }
                    else if (newPath.charAt(0) == '/'){
                        // for absolute paths
                        path.clear();
                        index = 1;
                    }
                    // for both absolute and relative paths
                    for (int j = index; j < destination.length; j++){
                        String folder = destination[j];
                        if (folder.equals(".."))
                            path.remove(path.size() - 1);
                        else
                            path.add(folder);
                    }
                }
            }
        }
    }
}
