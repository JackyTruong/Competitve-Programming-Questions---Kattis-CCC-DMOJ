import java.util.Scanner;

public class Main {

    private static void printOut(int first, int other){
        boolean lowered = false;
        for(int i = other ; i > 1 && !lowered; i--){
            if(first % i == 0 && other % i == 0){
                first/= i;
                other /=i;
                lowered = true;
            }
        }
        System.out.println(first + "/" + other);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int first = sc.nextInt();
        for(int i = 0 ; i < num-1; i++){
            printOut(first, sc.nextInt());
        }
    }
}
