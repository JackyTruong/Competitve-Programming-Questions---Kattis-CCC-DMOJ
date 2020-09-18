import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean should = false;
        int first = sc.nextInt(), second = sc.nextInt(), third = sc.nextInt(), fourth = sc.nextInt();
        if((first == 8 || first == 9) && (second == third) && (fourth == 8 || fourth == 9)){
            should = true;
        }
        if(should){
            System.out.println("ignore");
        }
        else{
            System.out.println("answer");
        }
    }
}
