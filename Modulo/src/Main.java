import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> held = new ArrayList<>();
        for(int i = 0 ; i < 10 ;i ++){
            int temp = sc.nextInt();
            if(!held.contains(temp%42)){
                held.add(temp%42);
            }
        }
        System.out.println(held.size());
    }
}
