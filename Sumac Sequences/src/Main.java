import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        int count = 2;
        while(first >= 0 && second >= 0){
            int diff = first-second;
            first = second;
            second = diff;
            //System.out.println(first + " " + second);
            count++;
        }
        System.out.println(count-1);
    }
}
