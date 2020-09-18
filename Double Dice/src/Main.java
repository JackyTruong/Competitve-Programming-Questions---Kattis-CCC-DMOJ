import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int A = 100;
        int D = 100;
        for(int i = 0 ; i < num ;i++){
            int Aroll = sc.nextInt();
            int Droll = sc.nextInt();
            if(Aroll > Droll){
                D -= Aroll;
            }
            else if(Droll > Aroll){
                A -= Droll;
            }
        }
        System.out.println(A);
        System.out.println(D);
    }
}
