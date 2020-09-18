import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static String workout(Integer[] lengths){
        int temp = 0;
        String answer = "";
        //out.println(Arrays.toString(lengths));
        for(int i = 0; i < lengths.length; i++){
            if(temp < lengths[i]){
                temp += lengths[i];
                answer = answer.concat("U");
            }
            else if(i+1 <lengths.length &&temp > lengths[i] && (temp + lengths[i]) <= lengths[i+1]){
                temp += lengths[i];
                //out.println(i);
                answer = answer.concat("U");
            }
            else{
                temp -= lengths[i];
                answer = answer.concat("D");
            }
        }
        if(temp != 0){
            answer = "IMPOSSIBLE";
        }
        return answer;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        for(int i = 0 ; i < n; i++){
            int m = nextInt();
            int temp = 0;
            int largest = 0;
            Integer[] lengths = new Integer[m];
            for(int o = 0 ; o < m; o++){
                lengths[o] = nextInt();
                if(lengths[o] > largest){
                    largest = lengths[o];
                }
                temp += lengths[o];
            }
            if(temp % 2 != 0){
                out.println("IMPOSSIBLE");
            }
            else{
                out.println(workout(lengths));
            }
        }

        out.close();
    }

    public static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    public static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }
}
