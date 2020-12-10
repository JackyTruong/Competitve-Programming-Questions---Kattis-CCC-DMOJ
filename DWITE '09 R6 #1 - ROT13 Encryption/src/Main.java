import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;
    static String input;

    private static void decrypt(){
        String d = "";
        for(int i = 0 ; i < input.length(); i++){
            if(Character.getNumericValue(input.charAt(i)) > 9){
                int temp = input.charAt(i)+13;
                if(temp > 90){
                    temp -= 26;
                }
                d+= (char)temp;
            }
            else{
                d += input.charAt(i);
            }
        }
        System.out.println(d);
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        for(int z = 0 ;z < 5; z++) {
            input = br.readLine();
            decrypt();
        }
    }
}
