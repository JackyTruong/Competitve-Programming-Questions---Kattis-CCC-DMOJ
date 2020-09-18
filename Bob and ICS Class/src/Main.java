import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = (int)Math.sqrt(sc.nextInt()), g1 = (int)Math.sqrt(sc.nextInt()), b1 = (int)Math.sqrt(sc.nextInt()), r2 = (int)Math.sqrt(sc.nextInt()), g2 = (int)Math.sqrt(sc.nextInt()), b2 = (int)Math.sqrt(sc.nextInt());
        if(r1 == r2 && g1 == g2 && b1 == b2){
            System.out.println("Dull");
        }
        else{
            System.out.println("Colourful");
        }
    }
}
