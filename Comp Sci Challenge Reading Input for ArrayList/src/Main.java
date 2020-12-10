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
        System.out.println("Input text to put into an ArrayList and end the program with a 0.");
        ArrayList<String> input = new ArrayList<>();
        String temp = next();
        while(!temp.equals("0")){
            input.add(temp);
            temp = next();
        }
        out.println();
        for(int i = 0 ;i < input.size(); i++){
            out.println(input.get(i));
        }



        out.close();
    }


    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

}
