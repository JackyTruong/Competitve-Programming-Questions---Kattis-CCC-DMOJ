import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int m = sc.nextInt();
        int max = sc.nextInt();
        if(c > m){
            System.out.println(max*c);
        }
        else{
            System.out.println(max*m);
        }
    }
}
