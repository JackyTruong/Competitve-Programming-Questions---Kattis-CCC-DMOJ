import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = nextInt();
        for(int z = 0 ; z < t; z++){
            int n = nextInt();
            int[] arr = new int[n+1];
            int[] prev = new int[n+1];
            Arrays.fill(prev, -1);
            int first = nextInt();
            arr[first]++;
            boolean diff = false;
            prev[first] = 0;
            int highest = 0;
            for(int i = 0; i < n-2; i++){
                int nextNum = nextInt();
                if(nextNum > highest){
                    highest = nextNum;
                }
                if(prev[nextNum] != i){
                    //System.out.println(prev[nextNum] + " this " + i);
                    arr[nextNum]++;
                    prev[nextNum] = i+1;
                    diff = true;
                }
                else{
                    prev[nextNum] = i+1;
                }
            }
            int finalNum = nextInt();
            if(prev[finalNum] == -1){
                arr[finalNum]++;
            }
            else{
                for(int i = 1; i <= highest; i++){
                    if(i != finalNum){
                        arr[i]++;
                    }

                }
            }
            int lowest = Integer.MAX_VALUE;
            for(int i = 1 ; i <= highest; i++){
                if(lowest > arr[i] && arr[i] != 0){
                    //System.out.println(i + " " + arr[i] + " " + z);
                    lowest = arr[i];
                }
            }
            if(diff){
                out.println(lowest);
            }
            else{
                out.println(0);
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
