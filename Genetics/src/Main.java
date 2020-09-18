
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int n, m, k;
    static String[] genes;



    private static boolean compareGene(String first, String second){
        int diff = 0;
        for(int i = 0; i < m && diff <= k; i++){
            if(first.charAt(i) != second.charAt(i)){
                diff++;
            }
        }
        return diff==k;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt(); m = nextInt(); k = nextInt();
        genes = new String[n];
        boolean[] done = new boolean[n];
        for(int i = 0 ; i < n; i++){
            genes[i] = next();
        }
        int upTo = 0;
        boolean found = false;
        while(!found){
            boolean broke = false;
            if(done[upTo]){
                upTo++;
            }
            for(int i = 0 ; i < n; i++){
                if(i != upTo){
                    if(!compareGene(genes[upTo], genes[i])){
                        done[upTo] = true;
                        done[i] = true;
                        broke = true;
                    }
                }
            }
            if(!broke){
                found = true;
            }
        }
        for(int i = 0 ; i < n; i++){
            if(!done[i]){
                out.println(i+1);
            }
        }





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
