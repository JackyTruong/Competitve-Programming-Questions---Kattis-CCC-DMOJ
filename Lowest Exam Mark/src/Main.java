import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int Q = sc.nextInt();
        float W = sc.nextInt();
        float mark =P*((100-W)/100);
        //System.out.println(mark);
        if(Math.round(mark+W) >= Q){
            System.out.println((int)Math.ceil(Math.abs((mark-Q+W)/W))*100);
        }
        else{
            System.out.println("DROP THE COURSE");
        }
    }
}
