import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int z = 0 ;z < 5; z++){
            int n = sc.nextInt();
            int[] count = new int[101];
            for(int q = 0 ; q < n; q++){
                count[sc.nextInt()]++;
            }
            int highest = 0;
            for(int i = 0 ; i <= 100; i++){
                if(count[i] > count[highest]){
                    highest = i;
                }
            }
            boolean unknown = false;
            for(int i = 0; i <= 100; i++){
                if(i != highest && count[i] == count[highest]){
                        unknown = true;
                }
            }
            if(count[highest] > n/2){
                System.out.println("verified");
            }
            else if(!unknown){
                System.out.println("unverified");
            }
            else{
                System.out.println("unknown");
            }
        }
    }
}
