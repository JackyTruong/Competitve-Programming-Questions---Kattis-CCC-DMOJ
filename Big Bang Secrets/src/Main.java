import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int i = nextInt();
        String text = next();
        String output = "";
        for(int o = 0 ; o < text.length(); o++){
            int temp = text.charAt(o);
            int num = 3*(o+1) + i;
            temp-=num;
            while(temp < 65){
                temp+=26;
            }
            output+=(char)temp;
        }
        out.println(output);

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
