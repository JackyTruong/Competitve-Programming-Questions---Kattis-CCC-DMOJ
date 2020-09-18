import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt();
        for(int i = 0 ; i <= y-x; i++){
            if(i % 4 == 0 && i % 3 == 0 && i % 5 == 0){
                System.out.println("All positions change in year " + (i+x));
            }
        }
    }
}
