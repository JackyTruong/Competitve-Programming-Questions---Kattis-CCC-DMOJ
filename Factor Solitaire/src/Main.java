import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int num = nextInt();
        int count = 0;
        while(num > 1){
            int factor = 2;
            for(;factor <= Math.sqrt(num) && num % factor != 0;factor++);
            if(factor<num && num%factor == 0){
                int temp = num/factor;
                num -= temp;
                count += num/temp;
            }
            else{
                num--;
                count += num;
            }
        }
        out.println(count);

        out.close();
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
