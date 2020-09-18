import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            int num = sc.nextInt();
            if(!temp.contains(num)){
                temp.add(num);
            }
        }
        System.out.println(temp.size());
    }
}
