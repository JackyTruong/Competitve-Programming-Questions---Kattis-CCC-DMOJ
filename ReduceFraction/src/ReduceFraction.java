/**
 * Finds the GCD of the two inputted numbers.
 *
 * date         20201022
 * @filename	ReduceFraction.java
 * @author      jtruong
 * @version     1.0
 * @see         Assignment 3.2.3
 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class ReduceFraction {

    private static int GCD(int a, int b){
        if(a == 0){
            return b;
        }
        if(b == 0){
            return a;
        }
        if(a == b){
            return a;
        }
        if(a > b){
            return GCD(a%b, b);
        }
        return GCD(a, b%a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean end = false;
        do{
            try{
                System.out.println("Input two numbers that you want the GCD for. (on the same line)");
                String temp = sc.nextLine();
                StringTokenizer st = new StringTokenizer(temp, " ");
                if(st.countTokens() == 2){
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    if(a >= 1 && b >= 1){
                        System.out.println(GCD(a, b));
                        end = true;
                    }
                    else{
                        System.out.println("The input was incorrect.");
                    }
                }
                else{
                    System.out.println("The input was incorrect.");
                }


            }
            catch(NumberFormatException a){
                System.out.println("The input was incorrect.");
            }
        }while(!end);
    }
}