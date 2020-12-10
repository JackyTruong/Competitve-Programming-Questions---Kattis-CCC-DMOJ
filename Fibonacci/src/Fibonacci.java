/**
 * Outputs the chosen index in the fibonacci sequence.
 *
 * date         20201021
 * @filename	Fibonacci.java
 * @author      jtruong
 * @version     1.0
 * @see         Assignment 3.2.1
 */

import java.util.Scanner;

public class Fibonacci {

    private static int fib(int n){
        if(n <= 1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean end = false;
        do{
            try{
                System.out.println("Input the index you would like in the fibonacci sequence.");
                String temp = sc.nextLine();
                int n = Integer.parseInt(temp);
                if(n >= 1){
                    System.out.println(fib(n));
                    end = true;
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
