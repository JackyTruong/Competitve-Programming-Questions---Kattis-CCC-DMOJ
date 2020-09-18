import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        if(a < b+c && b < a +c && c < a + b){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}
