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
        char[][] output = new char[2004][1004];
        for(int i = 0 ; i < 2004; i++){
            for(int o = 0 ; o < 1004; o++){
                output[i][o] = 'z';
            }
        }
        int highest = 1002;
        int lowest = 1002;
        int spot = 1002;
        char slash = (char)92;
        String input = next();
        for(int i = 0 ; i < n; i++){
            if(input.charAt(i) == '>'){
                output[spot][i] = '_';
            }
            else if(input.charAt(i) == 'v'){
                spot++;
                output[spot][i] = slash;
                highest++;
            }
            else if(input.charAt(i) == '^'){
                output[spot][i] = '/';
                spot--;
                lowest--;
            }
        }
        boolean empty = true;
        while(empty){
            boolean found = false;
            for(int i = 0; i <= n; i++){
                if(output[lowest][i] != 'z'){
                    found = true;
                }
            }
            if(!found){
                lowest++;
            }
            else{
                empty = false;
            }
        }
        empty = true;
        while(empty){
            boolean found = false;
            for(int i = 0; i <= n; i++){
                if(output[highest][i] != 'z'){
                    found = true;
                }
            }
            if(!found){
               highest--;
            }
            else{
                empty = false;
            }
        }

        for(int i = lowest ; i <= highest; i++){
            for(int o = 0 ; o < n; o++){
                if(output[i][o] == 'z'){
                    out.print('.');
                }
                else{
                    out.print(output[i][o]);
                }
            }
            out.println();
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
