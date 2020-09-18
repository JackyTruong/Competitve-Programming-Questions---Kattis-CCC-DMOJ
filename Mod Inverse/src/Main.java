import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int m = sc.nextInt();
        boolean happened = false;
        for(int i = 1 ; i < m;i++){
            if((x*i)%m == 1){
                System.out.println(i);
                happened = true;
            }
        }
        if(!happened){
            System.out.println("No such integer exists.");
        }
    }
}
