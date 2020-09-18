import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < num; i++){
            int temp = sc.nextInt();
            if(temp == 0){
                list.remove(list.size()-1);
            }
            else{
                list.add(temp);
            }
        }
        int count = 0;
        for(int i = 0 ; i < list.size(); i++){
            count+= list.get(i);
        }
        System.out.println(count);
    }
}
