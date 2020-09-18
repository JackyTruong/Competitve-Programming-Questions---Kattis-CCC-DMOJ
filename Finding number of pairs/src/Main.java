import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        int m = nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0 ; i <= m; i++){
            nums.add(0);
        }
        long count = 0;
        for(int i = 0 ; i < n; i++){
            int temp = nextInt();
            nums.set(temp,nums.get(temp)+1);
        }
        for(int i = 0 ; i <= m/2; i++){
            int temp = nums.get(i)-1;
            for(int o = i+1; o <= m-i; o++){
                temp+=nums.get(o);
            }
            temp*=nums.get(i);
            count+=temp;
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
