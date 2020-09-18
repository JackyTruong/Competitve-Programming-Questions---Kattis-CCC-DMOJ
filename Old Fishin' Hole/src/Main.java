import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer[]> combinations;
    static int t, pike, pick, total;

    private static void add(int count, int numT, int numPike, int numPick){
        Integer[] temp = {numT, numPike, numPick};
        boolean shouldAdd = true;
        for(int i = 1 ; i < combinations.size(); i++){
            if(temp[0] == combinations.get(i)[0] && temp[1] == combinations.get(i)[1] && temp[2] == combinations.get(i)[2]){
                shouldAdd = false;
            }
        }
        if(shouldAdd){
            combinations.add(temp);
        }
        if(count+pike <= total){
            add(count+pike, numT, numPike+1, numPick);
        }
        if(count+t <= total){
            add(count+t, numT+1, numPike, numPick);
        }
        if(count+pick <= total){
            add(count+pick, numT, numPike, numPick+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        combinations = new ArrayList<>();
        t = sc.nextInt();
        pike = sc.nextInt();
        pick = sc.nextInt();
        total = sc.nextInt();
        add(0, 0, 0, 0);
        for(int i = 1 ; i < combinations.size(); i++){
            System.out.println(combinations.get(i)[0] + " Brown Trout, " + combinations.get(i)[1] + " Northern Pike, " + combinations.get(i)[2] +  " Yellow Pickerel");
        }
        System.out.println("Number of ways to catch fish: " + (combinations.size()-1));
    }
}
