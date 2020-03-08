import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        int i;
        Scanner sc = new Scanner(System.in);
        i = sc.nextInt();
        Double[] numbers = new Double[i];
        for(int o = 0; o < i;o++){
            numbers[o] = sc.nextDouble();
        }
        Arrays.sort(numbers);
        Double least = (numbers[1] - numbers[0])/2 + (numbers[2] - numbers[1])/2;
        for(int l = 2 ; l < i - 1; l++){
            if((numbers[l] - numbers[l-1])/2 + (numbers[l+1] - numbers[l])/2 < least){
                least = (numbers[l] - numbers[l-1])/2 + (numbers[l+1] - numbers[l])/2;
            }
        }
        String.format("%.1f", least);
        System.out.println(least);
        //System.out.println(Arrays.toString(numbers));
    }
}
