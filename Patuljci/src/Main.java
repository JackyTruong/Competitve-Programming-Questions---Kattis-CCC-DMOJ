import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int[] hats;
    static boolean done;

    private static void findC(ArrayList<Integer> soFar, int total){
        if(!done){
            if(soFar.size() == 7 && total == 100){
                for(int i = 0 ; i < 7; i++){
                    System.out.println(soFar.get(i));
                }
                done = true;
            }
            else{
                for(int i = 0 ; i < hats.length; i++){
                    if(!soFar.contains(hats[i])){
                        soFar.add(hats[i]);
                        findC(soFar, total + hats[i]);
                        soFar.remove(soFar.size()-1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        hats = new int[9];
        done = false;
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 9; i++){
            hats[i] = sc.nextInt();
        }
        findC(new ArrayList<>(), 0);
    }
}
