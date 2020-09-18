import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n; i++){
            int temp = sc.nextInt();
            int amount = 0;
            for(int o = 0 ; o < temp; o++){
                amount += sc.nextInt();
            }
            if(amount != 0){
                System.out.println("Day " + (i+1) + ": " + amount);
            }
            else{
                System.out.println("Weekend");
            }

        }
    }
}
