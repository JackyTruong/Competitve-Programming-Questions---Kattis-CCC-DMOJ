import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        int start = sc.nextInt();
        int increase = sc.nextInt();
        int count = 0;
        int totalInfected = start;
        while(totalInfected <= max){
            start*=increase;
            totalInfected += start;
            count++;
        }
        System.out.println(count);
    }
}
