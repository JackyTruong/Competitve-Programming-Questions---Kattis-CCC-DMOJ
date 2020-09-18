import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int burger = sc.nextInt(), side = sc.nextInt(), drink = sc.nextInt(), dessert = sc.nextInt();
        int count = 0;
        if(burger == 1){
            count+=461;
        }
        else if(burger == 2){
            count+=431;
        }
        else if(burger == 3){
            count+= 420;
        }
        if(side == 1){
            count+= 100;
        }
        else if(side == 2){
            count += 57;
        }
        else if(side == 3){
            count += 70;
        }
        if(drink == 1){
            count+= 130;
        }
        else if(drink == 2){
            count+=160;
        }
        else if(drink == 3){
            count+=118;
        }
        if(dessert == 1){
            count += 167;
        }
        else if(dessert == 2){
            count += 266;
        }
        else if(dessert == 3){
            count += 75;
        }
        System.out.println("Your total Calorie count is " + count + ".");
    }
}
