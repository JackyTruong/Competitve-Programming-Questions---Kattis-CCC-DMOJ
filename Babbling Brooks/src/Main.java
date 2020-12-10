import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> streams = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0 ; i < n;i++){
            streams.add(sc.nextInt());
        }
        int temp = sc.nextInt();
        while(temp != 77){
            if(temp == 99){
                int firstStream = sc.nextInt();
                int split = sc.nextInt();
                int left = (int)(streams.get(firstStream-1)*(split/100.0f));
                int right = streams.get(firstStream-1)-left;
                //System.out.println(left + " " + right);
                streams.set(firstStream-1, left);
                streams.add(firstStream, right);
            }
            if(temp == 88){
                int firstStream = sc.nextInt();
                int combination = streams.get(firstStream-1);
                combination += streams.get(firstStream);
                streams.remove(firstStream);
                streams.remove(firstStream-1);
                streams.add(firstStream-1, combination);
            }
            temp = sc.nextInt();
        }

        for(int i = 0; i < streams.size();i++){
            System.out.print(streams.get(i));
            if(i < streams.size()-1){
                System.out.print(" ");
            }
        }
    }
}
