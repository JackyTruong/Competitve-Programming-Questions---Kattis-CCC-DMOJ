import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int xS = sc.nextInt(), yS = sc.nextInt(), wX1 = sc.nextInt(), wY1 = sc.nextInt(), wX2 = sc.nextInt(), wY2 = sc.nextInt();
        if(xS > wX1 && xS < wX2 && yS > wY1 && yS < wY2){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
