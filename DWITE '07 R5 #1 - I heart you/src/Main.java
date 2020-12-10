import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int z = 0 ;z < 5; z++){
            int i = sc.nextInt();
            String first = "";
            String second = "";
            String third = "";
            for(int o = 0 ; o  < i; o++){
                first += " ~.~ ";
                second += "`   `";
                third += " \\./ ";
            }
            System.out.println(first);
            System.out.println(second);
            System.out.println(third);
        }
    }
}
