import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for(int z = 0 ; z < num; z++){
            String temp = br.readLine();
            StringTokenizer st = new StringTokenizer(temp, " ");
            while(st.hasMoreTokens()){
                String word = st.nextToken();
                if(word.length() == 4){
                    System.out.print("**** ");
                }
                else{
                    System.out.print(word + " ");
                }
            }
            System.out.println("");
        }
    }
}
