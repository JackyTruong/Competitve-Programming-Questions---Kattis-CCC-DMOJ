import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int timeL = sc.nextInt();
        int en = sc.nextInt();
        double needed = 0;
        for(int i = 0 ; i < en; i++){
            int temp = sc.nextInt();
            if(temp == 1){
                needed += 0.5;
            }
            else if(temp == 2){
                needed++;
            }
            else{
                needed += 5;
            }
        }
        if(timeL >= needed){
            System.out.println("Continue");
        }
        else{
            System.out.println("Return");
        }
    }
}
