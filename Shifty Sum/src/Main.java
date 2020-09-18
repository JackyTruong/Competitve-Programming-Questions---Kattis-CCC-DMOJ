import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int shift = sc.nextInt();
        int count = base;
        for(int i = 1 ; i <= shift; i++){
            count+= base*(Math.pow(10, i));
        }
        System.out.println(count);
    }
}
