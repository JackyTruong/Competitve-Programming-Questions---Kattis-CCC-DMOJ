import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong(), K = sc.nextLong();
        long i = 1;
        long count = 0;
        while(i < K && i < N){
            i*=2;
            count++;
        }
        if((N-i)%K != 0 && N-i >= 0){
            count++;
        }
        long total = (N-i)/K + count;
        System.out.println(total);
    }
}
