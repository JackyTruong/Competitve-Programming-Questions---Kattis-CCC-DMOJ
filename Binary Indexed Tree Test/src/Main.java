
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int[] tree, arr;
    static int n;

    private static long getSum(int i){
        long s = 0;
        i++;
        while(i > 0){
            s+= tree[i];
            i -= i & (-i);
        }
        //System.out.println(s + " " + l + " " + i);
        return s;
    }

    private static void updateTree(int i, int change){
        i++;
        while(i <= n){
            tree[i] += change;
            i += i & (-i);
        }
    }
    private static void update(int i, int val){
        int diff = val - arr[i];
        arr[i] = val;
        updateTree(i, diff);
    }

    private static long sumR(int i, int o){
        return getSum(o) - getSum( i-1);
    }


    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int size = nextInt();int act = nextInt();
        n = size;
        tree = new int[size+1];
        arr = new int[size];
        for(int i = 0; i < size;i++){
            arr[i] = nextInt();
            updateTree(i, arr[i]);
        }

        for(int i = 0 ; i < act;i++){
            char temp = next().charAt(0);
            if(temp == 'C'){
                int spot = nextInt()-1;
                int other = nextInt();
                update(spot, other);
            }
            else if(temp == 'S'){
                int start = nextInt()-1;
                int end = nextInt()-1;
                long total = sumR(start, end);
                out.println(total);
            }
            else if(temp == 'Q'){
                int num = nextInt();
                int count = 0;
                for(int a = 0 ; a < size; a++){
                    if(arr[a] <= num){
                        count++;
                    }
                }
                out.println(count);
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
