import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = 0, B = 0;
        for(int i = 3 ; i > 0; i--){
            A += sc.nextInt()*i;
        }
        for(int i = 3 ; i > 0; i--){
            B += sc.nextInt()*i;
        }
        if(A > B){
            System.out.println("A");
        }
        else if(A < B){
            System.out.println("B");
        }
        else{
            System.out.println("T");
        }
    }
}
