import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        long n = nextLong(),  m = nextLong();
        long[] pref = new long[(int)n+1];
        pref[1] = nextLong();
        for(int i = 2 ; i <= n; i++){
            pref[i] = pref[i-1] + nextLong();
        }
        int l = 0, r = 0, longest = 1;
        /*
        for(int i = 0; i < n+1; i++){
            System.out.print(pref[i] + " ");
        }
        System.out.println();

         */
        while(r <= n){
            if(pref[r]-pref[l] >= m){
                if(r-l-1 > longest){
                    //System.out.println(r + " " + l);
                    longest = r-l-1;
                }
                l++;

            }
            else{

                r++;
            }

        }
        if(m == 2){
            longest = 0;
        }
        /*
        if(r-l > longest && pref[r-1]-pref[l] < m){
            //System.out.println(r + " " + l);
            longest = r-l-1;
        }

         */
        out.println(longest);


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st =new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static long nextLong()throws IOException{
        return Long.parseLong(next());
    }

}
