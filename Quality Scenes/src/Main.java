import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
        if(b > c && a < d){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
