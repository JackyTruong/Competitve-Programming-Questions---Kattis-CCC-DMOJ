import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numFriends = sc.nextInt();
        int[] friends = new int[numFriends+1];
        for(int i = 1; i < numFriends+1; i++){
            friends[i] = i;
        }
        int numDelete = sc.nextInt();
        for(int i = 0 ; i < numDelete; i++){
            int baseI = sc.nextInt();
            int temp = 1;
            int size = numFriends;
            while(baseI*temp < friends.length){
                friends[baseI*temp] = -1;
                size--;
                temp++;
            }
            int[] tempA = new int[size+1];
            int arraySpot = 0;
            for(int o = 0 ; o < friends.length; o++){
                if(friends[o] != -1){
                    tempA[arraySpot] = friends[o];
                    arraySpot++;
                }
            }
            friends = tempA;

        }
        for(int i = 1 ; i < friends.length; i++){
            if(friends[i] != 0){
                System.out.println(friends[i]);
            }

        }
    }
}
