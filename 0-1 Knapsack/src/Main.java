import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long weight = 0;
        for(int i = 0 ; i < n; i++){
            int tempC = sc.nextInt();
            int tempV = sc.nextInt();
            if(tempV > 0){
                weight += tempC;
            }
        }
        System.out.println(weight);
    }
}
