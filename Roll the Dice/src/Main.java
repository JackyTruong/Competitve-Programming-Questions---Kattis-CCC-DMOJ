import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();int m = nextInt();
        int count = 0;
        ArrayList<Integer> used = new ArrayList<>();
        for(int i = 1 ; i < m+1 && i < 11; i++){
            for(int o = 1 ; o < n+1 && o < 11; o++){
                if(i + o == 10){
                    if(i != o && Math.min(m, n) >= Math.max(i, o) && !used.contains(i) && !used.contains(o)){
                        count+=2;
                    }
                    else if(!used.contains(i) && !used.contains(o)){
                        //System.out.println(i + " " + o);
                        count++;
                    }
                    used.add(i);
                    used.add(o);
                }
            }
        }
        if(count == 1){
            out.println("There is 1 way to get the sum 10.");
        }
        else{
            out.println("There are " + count + " ways to get the sum 10.");
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
