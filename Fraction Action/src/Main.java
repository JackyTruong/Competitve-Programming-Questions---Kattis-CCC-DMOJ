import java.util.Scanner;

public class Main {

    private static int simplify(int fraction, int d){
        for(int i = fraction ; i > 1;i--){
            if(fraction%i == 0 && d % i == 0){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), d = sc.nextInt();
        int whole = n/d;
        int fraction = n%d;
        if(fraction != 0 && whole != 0){
            int temp = simplify(fraction, d);
            if(temp == -1){
                System.out.println(whole + " " + fraction + "/" + d);
            }
            else{
                System.out.println(whole + " " + fraction/temp + "/" + d/temp);
            }

        }
        else if(fraction != 0){
            int temp = simplify(fraction, d);
            if(temp == -1){
                System.out.println(fraction + "/" + d);
            }
            else{
                System.out.println(fraction/temp + "/" + d/temp);
            }
        }
        else{
            System.out.println(whole);
        }
    }
}
