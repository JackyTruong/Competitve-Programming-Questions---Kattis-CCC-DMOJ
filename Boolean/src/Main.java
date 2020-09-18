import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int nots = 0;
        String temp = next();
        while(!temp.equals("True") && !temp.equals("False")){
            //System.out.println(temp);
            nots++;
            temp = next();
        }
        if(temp.equals("True")){
            if(nots%2 == 0){
                out.println("True");
            }
            else{
                out.println("False");
            }
        }
        else{
            if(nots%2 == 0){
                out.println("False");
            }
            else{
                out.println("True");
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
}
