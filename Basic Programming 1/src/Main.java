import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br;
    private static PrintWriter out;
    private static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt(), t = nextInt();
        int sum = 0;
        int evenSum = 0;
        Integer[] A = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            A[i] = nextInt();
            sum += A[i];
            if(A[i] % 2 == 0){
                evenSum += A[i];
            }
        }
        if(t == 1){
            out.println(7);
        }
        if(t == 2){
            if(A[0] > A[1]){
                out.println("Bigger");
            }
            else if(A[0].equals(A[1])){
                out.println("Equal");
            }
            else{
                out.println("Smaller");
            }
        }
        if(t == 3){
            Integer[] temp = Arrays.copyOf(A, 3);
            Arrays.sort(temp);
            out.println(temp[1]);
        }
        if(t == 4){
            out.println(sum);
        }
        if(t == 5){
            out.println(evenSum);
        }
        if(t == 6){
            char[] word = new char[n];
            for(int i = 0 ; i < n; i++){
                word[i] = (char)(A[i]%26 + 97);
            }
            out.println(String.valueOf(word));
        }
        if(t == 7){
            boolean broke = false;
            int i = 0;
            for(int o = 0; o < n-1;o++){
                i = A[i];
                if(i == n-1){
                    out.println("Done");
                    broke = true;
                    break;
                }
                else if(i > n-1){
                    out.println("Out");
                    broke = true;
                    break;
                }
            }
            if(!broke){
                out.println("Cyclic");
            }
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
