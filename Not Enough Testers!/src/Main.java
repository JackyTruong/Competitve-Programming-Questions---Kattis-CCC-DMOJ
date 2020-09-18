
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int k, a, b, num;
    static int[] factors;
    static ArrayList<ArrayList<Integer>> f;

    private static void findFactors(){
        for(int i = 1 ; i <= 100000; i++){
            int temp = i;
            while(temp <= 100000){
                factors[temp]++;
                temp += i;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = nextInt();
        factors = new int[100001];
        findFactors();
        f = new ArrayList<>();
        for(int i = 0 ; i < 100001; i++){
            f.add(new ArrayList<>());
        }
        for(int i = 1; i <= 100000; i++){
            f.get(factors[i]).add(i);
        }
        for(int z=  0 ; z < t; z++){
            k = nextInt();a=nextInt();b=nextInt();
            num = 0;
            for(int i = 0 ; i < f.get(k).size();i++){
                if(f.get(k).get(i) <= b && f.get(k).get(i) >= a){
                    num++;
                }
            }
            out.println(num);
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
