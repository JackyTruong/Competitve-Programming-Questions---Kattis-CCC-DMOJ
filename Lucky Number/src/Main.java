import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int findSingle(String s){
        int count = 0;
        for(int i = 0 ; i < s.length(); i++){
            count += Character.getNumericValue(s.charAt(i));
        }
        if(count >= 10){
            count = findSingle(Integer.toString(count));
        }
        return count;
    }

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < num; i++){
            String temp = br.readLine();
            System.out.println(findSingle(temp));
        }
    }
}
