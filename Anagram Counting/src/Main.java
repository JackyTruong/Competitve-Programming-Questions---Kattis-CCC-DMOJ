import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    static BigInteger findFactorial(int i){
        BigInteger num = BigInteger.valueOf(1);
        for(long o = 1; o <= i; o++){
            num = num.multiply(BigInteger.valueOf(o));
        }
        return num;
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       while(sc.hasNextLine()){
       String word = sc.nextLine();
       int length = word.length();
       char[] charword = word.toCharArray();
       Integer[] alpha = new Integer[54];
       for(int i = 0; i < 54; i++){
           alpha[i] = 0;
       }
       for(int i = 0;i < charword.length;i++){
           if (Character.isUpperCase(charword[i])) {
               alpha[Character.getNumericValue(charword[i]) + 16]++;
           }
           else {
               alpha[Character.getNumericValue(charword[i]) - 9]++;
           }
       }
       BigInteger divide = BigInteger.valueOf(1);
       for(int var = 0; var < alpha.length;var++){
            if(alpha[var] > 1){
                divide = divide.multiply(BigInteger.valueOf(2));
            }
       }
       BigInteger answer;
           answer = findFactorial(length).divide(divide);
       System.out.println(answer);
    }
    }


}
