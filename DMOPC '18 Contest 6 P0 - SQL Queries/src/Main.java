import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        int countZ = 0;
        for(int i = 0 ; i < 3; i++){
            arr[i] = sc.nextInt();
            if(arr[i] == 0){
                countZ++;
            }
        }
        if(countZ >= 2){
            System.out.println("YES");
        }
        else if(countZ == 1){
            for(int i = 0 ; i < 3; i++){
                if(arr[i] != 0){
                    if(arr[arr[i]-1]-1 == i){
                        System.out.println("NO");
                        break;
                    }
                    else{
                        System.out.println("YES");
                        break;
                    }
                }
            }
        }
        else{
            System.out.println("NO");
        }
    }
}
