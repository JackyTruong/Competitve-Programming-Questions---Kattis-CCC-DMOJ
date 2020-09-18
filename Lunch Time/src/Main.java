import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br =  new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int o = 0; o < 10; o++){
            int n = nextInt(), m = nextInt(), k = nextInt();
            Integer[] ratings = new Integer[n];
            for(int i = 0; i < n; i++){
                ratings[i] = nextInt();
            }
            for(int i = 0 ;i < k-1; i++){
                Integer[] temp = new Integer[n];
                System.arraycopy(ratings, 0, temp, 0, n);
                Arrays.sort(temp);
                ratings[java.util.Arrays.asList(ratings).indexOf(temp[n-1])]-=m;
            }
            Integer[] temp = new Integer[n];
            System.arraycopy(ratings, 0, temp, 0, n);
            Arrays.sort(temp);
            out.println(java.util.Arrays.asList(ratings).indexOf(temp[n-1])+1);
        }

        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
