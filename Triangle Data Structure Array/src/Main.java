import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static long subTriangles(Integer[][] numbers, int size, int i){
        long secondCounter = 0;
        for(int c = 0; c < i - size + 1; c++){
            for(int b = 0;b < i - size/2; b++){
                long secondLargest = 0;
                int counter = size;
                for(int o = b; o < i; o++){
                    for(int a = 0; a < counter; a++){
                        if(numbers[i-o-1][a+c] != null){
                            if(numbers[i - o - 1][a+c] > secondLargest) {
                                secondLargest = numbers[i-o-1][a+c];
                            }
                        }
                        else{
                            secondLargest = 0;
                        }
                    }
                    counter--;
                }
                secondCounter += secondLargest;

            }
        }


        return secondCounter;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int o = sc.nextInt();
        int b = 0;
        Integer[][] numbers = new Integer[i][i];
        for(int a = 0; a < i;a++){
            b++;
            //System.out.println(a + "b");
            for(int c = 0; c < b; c++){
                numbers[a][c] = sc.nextInt();
            }
        }
        System.out.println(subTriangles(numbers, o, i));
        //System.out.println(Arrays.deepToString(numbers));

    }
}
