import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int time = sc.nextInt();
        int ground = -1;
        for(int i = 1 ; i <= time; i++){
            double temp = -(6*Math.pow(i, 4)) + ((h*Math.pow(i,3)) + (2*Math.pow(i,2) + i ));
            if(temp <= 0){
                ground = i;
                break;
            }
        }
        if(ground == -1){
            System.out.println("The balloon does not touch ground in the given time.");
        }
        else{
            System.out.println("The balloon first touches ground at hour: " + ground);
        }
    }
}
