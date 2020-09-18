import java.util.Scanner;

public class Main {

    public static long gcd(long a, long b)
    {
        if (a == 0)
            return b;

        return gcd(b%a, a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt(), B = sc.nextInt();
        long X = sc.nextLong();
        long together = 1;
        long up = (A*B)/gcd(A,B);
        together += (X-1)/up;
        System.out.println(together);
    }
}
