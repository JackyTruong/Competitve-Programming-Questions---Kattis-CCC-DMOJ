import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String first = st.nextToken();
        int num = Integer.parseInt(first);
        String secondPart = st.nextToken();
        if(secondPart.length() == 7){
            if(first.length() == 3){
                if(num == 416){
                    System.out.println("valuable");
                }
                else if(num == 437 || num == 647){
                    System.out.println("valueless");
                }
                else{
                    System.out.println("invalid");
                }
            }
            else{
                System.out.println("invalid");
            }
        }
        else{
            System.out.println("invalid");
        }
    }
}
