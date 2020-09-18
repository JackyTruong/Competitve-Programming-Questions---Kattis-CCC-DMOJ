import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coins = sc.nextInt();
        Integer[] machines = new Integer[3];
        machines[0] = sc.nextInt();
        machines[1] = sc.nextInt();
        machines[2] = sc.nextInt();
        int plays = 0;
        while(coins > 0){
            //System.out.println(machines[0] + " " + machines[1] + " " + machines[2] + " the amount of coins " + coins);
            if(machines[0] >= 35){
                coins += 30;
                machines[0] = 0;
            }
            if(machines[1] >= 100){
                coins += 60;
                machines[1] = 0;
            }
            if(machines[2] >= 10){
                coins += 9;
                machines[2] = 0;
            }
            for(int i = 0 ; i < 3 && coins > 0;i++){
                coins--;
                machines[i]++;
                plays++;
            }
        }
        System.out.println("Martha plays " + plays + " times before going broke.");
    }
}
