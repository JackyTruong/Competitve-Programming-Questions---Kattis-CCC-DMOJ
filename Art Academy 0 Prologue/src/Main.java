import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;

    private static void checkChar(char i){
        if(i == 'a' || i == 'A'){
            System.out.print("Hi! ");
        }
        else if(i == 'e' || i == 'E'){
            System.out.print("Bye! ");
        }
        else if(i == 'i' || i == 'I'){
            System.out.print("How are you? ");
        }
        else if(i == 'u' || i == 'U'){
            System.out.print("Help! ");
        }
        else if(i == 'o' || i == 'O'){
            System.out.print("Follow me! ");
        }
        else if(Character.isDigit(i)){
            System.out.print("Yes! ");
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int z = 0 ; z < n; z++){
            String name = br.readLine();
            for(int i = 0 ; i < name.length(); i++){
                checkChar(name.charAt(i));
            }
            System.out.println();
        }
    }
}
