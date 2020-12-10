import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        char apos = 34;
        String del = apos + ":',.)!;?( ";
        for(int z = 0 ; z < 5; z++){
            int count = 0;
            st = new StringTokenizer(br.readLine(), del);
            while(st.hasMoreTokens()){
                String temp = st.nextToken();
                if(temp.length() > 3){
                    //System.out.println(temp);
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
