import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        long n = nextInt()-1;
        long count = 1;
        long rows = 1;
        while(rows <= n){
            n-=rows;
            rows++;
            count+=rows-1;
            //out.println(rows + " this is rows");
        }


        long num = 0;
        for(int i = 0 ; i < rows; i++){
            //out.println(count);
            num += count;
            count++;

        }
        out.println(num);


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
