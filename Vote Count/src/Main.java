import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String votes = br.readLine();
        int A = 0;
        int B = 0;
        for(int i = 0 ; i < num; i++){
            if(votes.charAt(i) == 'A'){
                A++;
            }
            else if(votes.charAt(i) == 'B'){
                B++;
            }
        }
        if(A > B){
            System.out.println("A");
        }
        else if(B > A){
            System.out.println("B");
        }
        else{
            System.out.println("Tie");
        }
    }
}
