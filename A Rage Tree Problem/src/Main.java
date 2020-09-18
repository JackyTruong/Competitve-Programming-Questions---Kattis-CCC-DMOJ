
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int smallest = Integer.MAX_VALUE;
        int largest = 0;
        for(int i = 0 ; i < 4; i++){
            int temp = sc.nextInt();
            if(temp > largest){
                largest = temp;
            }
            if(temp < smallest){
                smallest = temp;
            }
        }
        System.out.println(smallest);
        System.out.println(largest);
    }
}
