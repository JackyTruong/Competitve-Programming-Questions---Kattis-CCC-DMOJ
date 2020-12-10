import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++){
            String input = br.readLine();
            int largest = 0;
            for(int o = 0 ; o < input.length(); o++){
                if(Character.getNumericValue(input.charAt(o)) > largest){
                    largest = Character.getNumericValue(input.charAt(o));
                }
            }
            System.out.println(largest);
        }

    }
}
