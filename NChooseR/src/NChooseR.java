/**
 * Finds the factorial for the inputted number.
 *
 * date         20201022
 * @filename	NChooseR.java
 * @author      jtruong
 * @version     1.0
 * @see         Assignment 3.2.2
 */

import java.util.Scanner;

public class NChooseR {

    private static int nChooseR(int n){
        if(n == 1){
            return 1;
        }
        return n*nChooseR(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean end = false;
        do{
            try{
                System.out.println("Input the number which you want to factorial.");
                String temp = sc.nextLine();
                int n = Integer.parseInt(temp);
                if(n >= 1){
                    System.out.println(nChooseR(n));
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
