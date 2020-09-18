import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        int count = 0;
        int s = (int)Math.pow(first, 1/6);
        int pow = s*s*s*s*s*s;
        while(pow < first){
            s++;
            pow = s*s*s*s*s*s;
        }
        while(pow <= second){
            s++;
            pow = s*s*s*s*s*s;
            count++;
        }
        System.out.println(count);
    }
}
