import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] temp = new int[3];
        for(int i = 0 ; i < 3; i++){
            temp[i] = sc.nextInt();
        }
        Arrays.sort(temp);
        sc.nextLine();
        String order = sc.nextLine();
        for(int i = 0 ; i < 3; i++){
            if(order.charAt(i) == 'A'){
                System.out.print(temp[0] + " ");
            }
            else if(order.charAt(i) == 'B'){
                System.out.print(temp[1] + " ");
            }
            else{
                System.out.print(temp[2] + " ");
            }
        }
    }
}
