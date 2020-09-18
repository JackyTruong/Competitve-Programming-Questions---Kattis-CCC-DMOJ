import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startX = sc.nextInt(), startY = sc.nextInt(), endX = sc.nextInt(), endY = sc.nextInt(), power = sc.nextInt();
        int dist = (Math.abs(startX-endX))+(Math.abs(startY-endY));
        if(power >= dist){
            power-= dist;
            if(power % 2 == 0){
                System.out.println("Y");
            }
            else{
                System.out.println("N");
            }
        }
        else{
            System.out.println("N");
        }
    }
}
