import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int sword = 0;
        int count = 0;
        while(N > 0){
            N--;
            sword++;
            count++;
            if(sword == K){
                N++;
                sword=0;
            }
        }
        System.out.println(count);
    }
}
