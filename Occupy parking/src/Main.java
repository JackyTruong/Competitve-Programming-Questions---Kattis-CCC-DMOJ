import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int num = nextInt();
        String begin = next();
        String end = next();
        int count = 0;
        for(int i = 0 ; i < num; i++){
            if(begin.charAt(i) == end.charAt(i) && begin.charAt(i) == 'C'){
                count++;
            }
        }
        System.out.println(count);

    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
