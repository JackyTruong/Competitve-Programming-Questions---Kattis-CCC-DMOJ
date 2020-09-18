import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] X = new int[n];
        int XW = 0;
        int FW = 0;
        for(int i = 0 ; i < n ;i++){
            X[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n; i++){
            int temp = sc.nextInt();
            if(temp > X[i]){
                FW++;
            }
            else if(temp < X[i]){
                XW++;
            }
        }
        System.out.println(XW + " " + FW);
        if(XW > FW){
            System.out.println("Xyene");
        }
        else if(FW>XW){
            System.out.println("FatalEagle");
        }
        else{
            System.out.println("Tie");
        }
    }
}
