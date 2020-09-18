import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static String msg;
    static int[] inc;

    private static void encrypt(){
        String end = "";
        int num = 0;
        for(int i = 0 ; i < msg.length();i++){
            if(num >= inc.length){
                num = 0;
            }
                int beforeNum = (int)msg.charAt(i);
                if(beforeNum <= 90 && beforeNum >=65){
                    if(beforeNum + inc[num] <= 90){
                        end += (char)(beforeNum + inc[num]);
                    }
                    else{
                        end += (char)(beforeNum + inc[num] - 26);
                    }
                    num++;
            }

        }
        out.println(end);
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        String keyword = next();
        inc = new int[keyword.length()];
        for(int i = 0 ; i < keyword.length();i++){
            inc[i] = (int)keyword.charAt(i)-65;
            //out.println(inc[i]);
        }
        msg = br.readLine();
        //out.println(msg);
        encrypt();


        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

}
