import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        int happy = 0;
        int sad = 0;
        for(int i = 0 ; i < temp.length(); i++){
            if(temp.charAt(i) == ':'){
                if(i+2 < temp.length() && temp.charAt(i+1) == '-' && temp.charAt(i+2) == ')'){
                    happy++;
                }
                else if(i+2 < temp.length() && temp.charAt(i+1) == '-' && temp.charAt(i+2) == '('){
                    sad++;
                }
            }
        }
        if(happy > sad){
            System.out.println("happy");
        }
        else if(happy < sad){
            System.out.println("sad");
        }
        else if(happy == sad && sad != 0 && happy != 0){
            System.out.println("unsure");
        }
        else{
            System.out.println("none");
        }

    }
}
