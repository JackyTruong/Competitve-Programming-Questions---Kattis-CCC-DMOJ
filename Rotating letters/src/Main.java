import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        boolean word = true;
        for(int i = 0 ; i < temp.length();i++){
            if(temp.charAt(i) != 'I' && temp.charAt(i) != 'O' && temp.charAt(i) != 'S' && temp.charAt(i) != 'H' && temp.charAt(i) != 'Z' && temp.charAt(i) != 'X' && temp.charAt(i) != 'N'){
                word = false;
            }
        }
        if(word){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
