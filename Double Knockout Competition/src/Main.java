import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int ud = sc.nextInt();
            int temp = ud;
            int doneRounds = 0;
            int ol = 0;
            int el = 0;
            while(el != temp-1){
                System.out.println("Round " + doneRounds + ": " + ud + " undefeated, " + ol + " one-loss, " + el + " eliminated");
                if(ud == 1 && ol == 1){
                    ol = 2;
                    ud = 0;
                }
                else{
                    el = el + ol/2;
                    ol = ol - ol/2 + ud/2;
                    ud = ud - ud/2;
                }
                doneRounds++;
            }
            System.out.println("Round " + doneRounds + ": " + ud + " undefeated, " + ol + " one-loss, " + el + " eliminated");
            System.out.println("There are " + doneRounds + " rounds.");
        }
    }
}
