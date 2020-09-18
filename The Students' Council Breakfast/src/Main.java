import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int count = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> holder;

    private static void possibilities(Integer[] colours, int totalNeed, int[] soFar){
        if(totalNeed == 0){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < 4; i++){
                temp.add(soFar[i]);
            }
            if(!holder.contains(temp)){
                holder.add(temp);
                System.out.println("# of PINK is " + temp.get(0) + " # of GREEN is " + temp.get(1) + " # of RED is " + temp.get(2) + " # of ORANGE is " + temp.get(3));

            }
            int sum = Arrays.stream(soFar).sum();
            if(sum < count){
                count = sum;
            }
            return;
        }
        if(totalNeed > 0){
            for(int i = 0; i < 4; i++){
                soFar[i]++;
                possibilities(colours, totalNeed - colours[i], soFar);
                soFar[i]--;
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        holder = new ArrayList<>();
        Integer[] colours = new Integer[4];
        for(int i = 0 ; i < 4; i++){
            colours[i] = sc.nextInt();
        }
        int totalNeed = sc.nextInt();
        int[] soFar = new int[4];
        Arrays.fill(soFar, 0);
        possibilities(colours, totalNeed, soFar);
        System.out.println("Total combinations is " + holder.size() + ".");
        System.out.println("Minimum number of tickets to print is " + count + ".");


    }
}
