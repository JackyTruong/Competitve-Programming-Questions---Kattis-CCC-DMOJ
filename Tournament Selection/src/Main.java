import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;


    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int w = 0;
        int l = 0;
        for(int i = 0 ; i < 6; i++){
            char temp = br.readLine().charAt(0);
            if(temp == 'W'){
                w++;
            }
            else{
                l++;
            }
        }
        if(w > 4){
            System.out.println(1);
        }
        else if(w > 2){
            System.out.println(2);
        }
        else if(w > 0){
            System.out.println(3);
        }
        else{
            System.out.println(-1);
        }
    }
}
