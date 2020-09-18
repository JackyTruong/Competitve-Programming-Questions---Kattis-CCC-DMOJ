import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1 = sc.nextInt(),y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt(), xS = sc.nextInt(), yS = sc.nextInt(), d = sc.nextInt();
        double diff = Math.pow((Math.pow(x1-xS,2) + Math.pow(y1-yS,2)),0.5);
        double diff2 = Math.pow((Math.pow(x2-xS,2) + Math.pow(y2-yS,2)), 0.5);
        if(diff <= d || diff2 <= d){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
