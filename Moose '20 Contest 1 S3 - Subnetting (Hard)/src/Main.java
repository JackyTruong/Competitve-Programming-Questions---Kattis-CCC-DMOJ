import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static Pair[] pairs;

    static class Pair{
        int aF, bF, cF, dF;
        int aS, bS, cS, dS;

        public Pair(int aF, int bF,int cF,int dF, int aS, int bS, int cS, int dS){
            this.aF = aF;
            this.bF = bF;
            this.cF = cF;
            this.dF = dF;
            this.aS = aS;
            this.bS = bS;
            this.cS = cS;
            this.dS = dS;
        }
    }

    private static int checkThree(int mid, int l, int r){
        if(mid > l && mid < r){
            return 1;
        }
        else if(mid == l || mid == r){
            return 0;
        }
        return -1;
    }

    private static boolean isBlocked(int aF, int bF,int cF,int dF){
        for(int i = 0 ; i < pairs.length; i++){
            int first = checkThree(aF, pairs[i].aF, pairs[i].aS);
            if(first == 1){
                return true;
            }
            else if(first == 0){
                int second = checkThree(bF, pairs[i].bF, pairs[i].bS);
                if(second == 1){
                    return true;
                }
                else if(second == 0){
                    int third = checkThree(cF, pairs[i].cF, pairs[i].cS);
                    if(third == 1){
                        return true;
                    }
                    else if(third == 0){
                        int fourth = checkThree(dF, pairs[i].dF, pairs[i].dS);
                        if(fourth == 1){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt(), m = nextInt();
        pairs = new Pair[n];
        for(int i = 0 ; i < n; i++){
            String input = next();
            st = new StringTokenizer(input, ".-");
            pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int blocked = 0;
        for(int i = 0 ; i < m; i++){
            String input = next();
            st = new StringTokenizer(input, ".");
            if(isBlocked(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))){
                blocked++;
            }
        }
        out.println(blocked);
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

    private static long nextLong()throws IOException{
        return Long.parseLong(next());
    }

    private static double nextDouble()throws IOException{
        return Double.parseDouble(next());
    }

}
