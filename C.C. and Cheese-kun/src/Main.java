import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int cheese = sc.nextInt();
        if(w == 3 && cheese >= 95){
            System.out.println("C.C. is absolutely satisfied with her pizza.");
        }
        else if(w == 1 && cheese <= 50){
            System.out.println("C.C. is fairly satisfied with her pizza.");
        }
        else{
            System.out.println("C.C. is very satisfied with her pizza.");
        }
    }
}
