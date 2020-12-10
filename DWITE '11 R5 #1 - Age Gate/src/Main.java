import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int z = 0 ; z < 5; z++){
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            if(year+13 <= 2010){
                if(month <= 10){
                    if(day <=27 || month < 10){
                        System.out.println("old enough");
                    }
                    else{
                        System.out.println("too young");
                    }
                }
                else{
                    System.out.println("too young");
                }
            }
            else{
                System.out.println("too young");
            }
        }
    }
}
