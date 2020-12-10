import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int z = 0; z < 5; z++){
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            int age = 2010-year;
            if(month < 10){
                age++;
            }
            else if(month == 10){
                if(day <= 27){
                    age++;
                }
                else{
                    age--;
                }
            }
            else{
                age--;
            }
            if(age >= 13){
                System.out.println("old enough");
            }
            else{
                System.out.println("too young");
            }
        }
    }
}
