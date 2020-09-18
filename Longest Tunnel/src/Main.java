import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long highest = 0;
        for(int i = 0 ; i < n; i++){
            long first = sc.nextLong();
            long second = sc.nextLong();
            long temp = Math.abs(first-second);
            if(temp > highest){
                highest = temp;
            }
        }
        System.out.println(highest);
    }
}
