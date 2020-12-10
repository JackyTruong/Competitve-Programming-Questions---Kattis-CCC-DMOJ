import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    private static boolean isConst(char temp){
        return !(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u');
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int z = 0 ; z < 5; z++){
            String first = next();
            String second = next();
            boolean same = true;
            if(first.length() == second.length()){
                int firstC = 0;
                int firstV = 0;
                int secondC = 0;
                int secondV = 0;
                for(int i = 0 ; i < first.length() && same; i++){
                    if(isConst(first.charAt(i)) != isConst(second.charAt(i))){
                        same = false;
                    }
                }
            }
            else{
                same = false;
            }
            if(!same){
                out.println("different");
            }
            else{
                out.println("same");
            }

        }

        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st =new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

}
