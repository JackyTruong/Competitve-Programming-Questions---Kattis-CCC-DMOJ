import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    private static int valueOf(char A){
        if(A == 'I'){
            return 1;
        }
        else if(A == 'M'){
            return 1000;
        }
        else if(A == 'V'){
            return 5;
        }
        else if(A == 'X'){
            return 10;
        }
        else if(A =='L'){
            return 50;
        }
        else if(A == 'C'){
            return 100;
        }
        else if(A == 'D'){
            return 500;
        }
        return 0;
    }

    private static boolean largerAorB(char A, char B){
        int Aval = valueOf(A);
        int Bval = valueOf(B);
        if(Aval >= Bval){
            return true;
        }
        return false;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        int num = 0;
        for(int i = 0; i < temp.length(); i+=2){
            boolean shouldSub = false;
            if(i < temp.length()-2){

                if(!largerAorB(temp.charAt(i+1), temp.charAt(i+3))) {
                    shouldSub = true;
                }
            }
            if(!shouldSub){
                if(temp.charAt(i+1) == 'M'){
                    num += (temp.charAt(i)-48)*1000;
                }
                else if(temp.charAt(i+1) == 'D'){
                    num += (temp.charAt(i)-48)*500;
                }
                else if(temp.charAt(i+1) == 'C'){
                    num += (temp.charAt(i)-48)*100;
                }
                else if(temp.charAt(i+1) == 'L'){
                    num += (temp.charAt(i)-48)*50;
                }
                else if(temp.charAt(i+1) == 'X'){
                    num += (temp.charAt(i)-48)*10;
                }
                else if(temp.charAt(i+1) == 'V'){
                    num += (temp.charAt(i)-48)*5;
                }
                else if(temp.charAt(i+1) == 'I'){
                    num += (temp.charAt(i)-48);
                }
            }
            else{
                if(temp.charAt(i+1) == 'M'){
                    num -= (temp.charAt(i)-48)*1000;
                }
                else if(temp.charAt(i+1) == 'D'){
                    num -= (temp.charAt(i)-48)*500;
                }
                else if(temp.charAt(i+1) == 'C'){
                    num -= (temp.charAt(i)-48)*100;
                }
                else if(temp.charAt(i+1) == 'L'){
                    num -= (temp.charAt(i)-48)*50;
                }
                else if(temp.charAt(i+1) == 'X'){
                    num -= (temp.charAt(i)-48)*10;
                }
                else if(temp.charAt(i+1) == 'V'){
                    num -= (temp.charAt(i)-48)*5;
                }
                else if(temp.charAt(i+1) == 'I'){
                    num -= (temp.charAt(i)-48);
                }
            }

        }
        System.out.println(num);
    }
}
