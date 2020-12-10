import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String verb = br.readLine();
        String obj = br.readLine();
        if(obj.charAt(obj.length()-1) == 's'){
            System.out.println(verb+"-tu les " + obj + " ?");
        }
        else if(obj.charAt(obj.length()-1) == 'e'){
            System.out.println(verb+"-tu la " + obj + " ?");
        }
        else{
            System.out.println(verb+"-tu le " + obj + " ?");
        }
    }
}
