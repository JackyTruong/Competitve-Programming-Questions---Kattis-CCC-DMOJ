import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), w = sc.nextInt(), h = sc.nextInt();
        for(int i = 0 ; i < num; i++){
            int temp = sc.nextInt();
            if(temp*temp <= w*w + h*h){
                System.out.println("DA");
            }
            else{
                System.out.println("NE");
            }
        }
    }
}
