import java.io.File;
import java.util.Scanner;

public class Main {

    public static boolean isPrime(int number){
        if(number == 0 || number == 1){
            return false;
        }
        for(int z = 2; z <= number/2; z++){
            if(number % z == 0){
                return false;
            }
        }
        return true;
    }

    public static void checker(int number){
        for(int a = 2; a <= number/2; a++){
            if(isPrime(a)){
                if(isPrime(number - a)){
                    System.out.println(a + " " + (number-a));
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int i;
        File file = new File("s2.1-03.IN");
        Scanner scanner;
        scanner = new Scanner(file);
        i = scanner.nextInt();
        for(int o = 0; o < i;o++){
            int p = scanner.nextInt();
            checker(p*2);
        }

    }
}

