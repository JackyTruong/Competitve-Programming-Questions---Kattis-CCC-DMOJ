import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int z = 0 ;z  <n ;z++){
            int countC = 0;
            int countM = 0;
            String test = br.readLine();
            for(int i = 0 ; i < test.length(); i++){
                if(test.charAt(i) == 'C'){
                    countC++;
                }
                if(test.charAt(i) == 'M'){
                    countM++;
                }
            }
            if(countC > 0 && countM > 0){
                System.out.println("NEGATIVE MARKS");
            }
            else if(countC > 0){
                System.out.println("FAIL");
            }
            else if(countM > 0){
                System.out.println("FAIL");
            }
            else{
                System.out.println("PASS");
            }
        }

    }
}
