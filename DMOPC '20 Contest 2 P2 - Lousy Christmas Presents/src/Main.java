import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static Pair[] arr;
    static int n, r;

    static class Pair{
        int shortest, longest;
        public Pair(int shortest,int longest){
            this.shortest = shortest;
            this.longest = longest;
        }
    }

    private static int longest(int start, int end){
        int num = arr[start].shortest;
        int num1 = arr[end].longest+1;
        if(num1 - num > 0){
            //System.out.println(num1 + " " + num);
            return num1 - num;
        }
        return 0;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt();
        r = nextInt();
        arr = new Pair[1000001];
        for(int i = 0 ; i < 1000001; i++){
            arr[i] = new Pair(Integer.MAX_VALUE, 0);
        }
        for(int i = 0 ; i < n; i++){
            int temp = nextInt();
            if(arr[temp].shortest > i){
                arr[temp].shortest = i;
            }
            if(arr[temp].longest < i){
                arr[temp].longest = i;
            }
        }
        int longest = 0;
        for(int i = 0 ; i < r; i++){
            int start = nextInt();
            int end = nextInt();
            longest = Math.max(longest, longest(start, end));
        }
        out.println(longest);



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
