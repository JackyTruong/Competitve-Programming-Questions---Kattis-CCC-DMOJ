import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), tX = sc.nextInt(), tY = sc.nextInt(), aX = sc.nextInt(), aY = sc.nextInt(), aC = sc.nextInt(), bX = sc.nextInt(), bY = sc.nextInt(), bC = sc.nextInt(), cX = sc.nextInt(), cY = sc.nextInt(), cC = sc.nextInt();
        if(aC < bC && aC < cC){
            double dist = Math.sqrt(Math.pow(aX-tX, 2) + Math.pow(aY-tY, 2));

            if(dist < r){
                System.out.println("What a beauty!");
            }
            else{
                System.out.println("Time to move my telescope!");
            }
        }
        else if(bC < aC && bC < cC){
            double dist = Math.sqrt(Math.pow(bX-tX, 2) + Math.pow(bY-tY, 2));
            if(dist < r){
                System.out.println("What a beauty!");
            }
            else{
                System.out.println("Time to move my telescope!");
            }
        }
        else{
            double dist = Math.sqrt(Math.pow(cX-tX, 2) + Math.pow(cY-tY, 2));
            //System.out.println(dist);
            if(dist < r){
                System.out.println("What a beauty!");
            }
            else{
                System.out.println("Time to move my telescope!");
            }
        }

    }
}
