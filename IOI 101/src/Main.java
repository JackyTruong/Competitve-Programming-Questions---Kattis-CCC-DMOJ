import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static BufferedReader br;

    private static void t(String base){
        String temp = "";
        for(int i = 0 ; i < base.length(); i++){
            if(!Character.isDigit(base.charAt(i))){
                temp += base.charAt(i);
            }
            else{
                temp += changeNum(base.charAt(i));
            }
        }
        System.out.println(temp);
    }

    private static char changeNum(char other){
        if(other == '0'){
            return 'O';
        }
        else if(other == '1'){
            return 'l';
        }
        else if(other == '3'){
            return 'E';
        }
        else if(other == '4'){
            return 'A';
        }
        else if(other == '5'){
            return 'S';
        }
        else if(other == '6'){
            return 'G';
        }
        else if(other == '8'){
            return 'B';
        }
        else if(other == '9'){
            return 'g';
        }
        return other;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        String base = br.readLine();
        t(base);
    }
}
