import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void mapCreator(int[][] battleMap){
        System.out.println("    0123456789");
        for(int i = 0;i  < 10; i++){
            System.out.print(i);
            System.out.print(" | ");
            for(int o = 0; o < 10; o++){
                if(battleMap[i][o] == 0){
                    System.out.print(" ");
                }
                else {
                    System.out.print("@");
                }
            }
            System.out.print(" | ");
            System.out.println(i);
        }
        System.out.println("    0123456789");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[][] battleMap = new int[10][10];
        mapCreator(battleMap);
        for(int a = 0; a < 5; a++) {
            System.out.print("Enter X coordinate for your ship "+ (a+1) + " :");
            int x = input.nextInt();
            while(x > 9 || x < 0){
                System.out.println("That isn't within the parameters, please pick another number");
                System.out.print("Enter X coordinate for your ship "+ (a+1) + " :");
                x = input.nextInt();
            }
            System.out.print("Enter Y coordinate for your ship "+ (a+1) + " :");
            int y = input.nextInt();
            while(y > 9 || y < 0){
                System.out.println("That isn't within the parameters, please pick another number");
                System.out.print("Enter Y coordinate for your ship "+ (a+1) + " :");
                y = input.nextInt();
            }
            battleMap[x][y]++;
        }
        mapCreator(battleMap);
        System.out.println("Computer is deploying ships");
        for(int b = 0; b < 5; b++){
            System.out.println(b + ". ship DEPLOYED");
            Random rand = new Random();
            int randInt1 = rand.nextInt(10);
            int randInt2 = rand.nextInt(10);
            battleMap[randInt1][randInt2]++;
        }
        mapCreator(battleMap);
    }
}
