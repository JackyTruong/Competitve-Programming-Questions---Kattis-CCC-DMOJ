import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String essay = br.readLine();
        int upper = 0;
        int lower = 0;
        for(int i = 0 ; i < essay.length(); i++){
            if(essay.charAt(i) >= 65 && essay.charAt(i) <= 90){
                upper++;
            }
            else if(essay.charAt(i) >= 97 && essay.charAt(i) <= 122){
                lower++;
            }
        }
        if(upper > lower){
            essay = essay.toUpperCase();
        }
        else if(lower > upper){
            essay = essay.toLowerCase();
        }
        System.out.println(essay);
    }
}
