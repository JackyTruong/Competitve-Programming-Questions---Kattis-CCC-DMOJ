import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static int highestCombination(Integer[] numbers, int k) {
        int i = 0;

        int p = numbers.length%k;
        //System.out.println(p+ "this is p");

        for(int o = 0 ; o < numbers.length;o++){
           // System.out.println((numbers.length - (o + p)) + "this is the complicated one");
            //System.out.println(o % k);
            int d = 0;


            if((numbers.length - (o + p))%k == 0 && o % k == 0){
                int l  = (numbers.length -  (o+p))/k;
                int h = o/k;
                int b = 0;
                int u = 0;
                //The highest number out of the remainder
                for(int s = 0; s < p; s++){
                    if(numbers[o + s] > u){
                        u = numbers[o + s];
                    }
                }
                d += u;
               // System.out.println(o);
                //looking for the highest to  the  right of the remainder
                for(int c = 0; c < l; c++){
                    b = 0;
                    for(int e = 0; e < k;e++){
                        //System.out.println("this is k" + c * k);
                        //System.out.println(numbers[o + c*k + p + e] + "this is the o+[");
                        if(b < numbers[o + p + e + c*k]){
                            b = numbers[o + p + e + c*k];

                        }

                       // System.out.println("the b in the right side" + b);
                    }
                    d += b;
                }
                //looking  for the highest to the left  of the remainder
                if(o != 0){
                    for(int r = 0; r < h; r++){
                        b = 0;
                        for(int  v = 0; v < k; v++){

                            if( b < numbers[v]){
                                b = numbers[v];
                                //System.out.println(numbers[v]);

                            }
                           // System.out.println("the b in the left side" + b);

                        }
                        //System.out.println("one time");
                        d += b;
                    }
                }
              // System.out.println("this is u" + u);
              //  System.out.println("this is i before" + i);
              //  System.out.println(b + "this is b");
               // System.out.println(d + "this is d");
            }
            if(d > i){
                i = d;
            }
        }
        return i;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("s4.1-03.IN");
        Scanner sc = new Scanner(System.in);
       int n, k;
       n = sc.nextInt();
       k = sc.nextInt();
       Integer[] numbers = new Integer[n];
       for(int o = 0; o < n;o++){
            numbers[o] = sc.nextInt();
       }
       System.out.println(highestCombination(numbers, k));
    }
}
