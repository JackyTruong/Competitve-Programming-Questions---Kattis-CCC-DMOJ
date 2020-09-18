import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        String[] code = new String[n];
        int WA = 0;
        for(int i = 0 ; i < n; i++){
            code[i] = next();
            if(code[i].equals("WA")){
                WA++;
            }
        }
        int change = (int)(WA*0.3);
        int count = 0;
        for(int i = 0 ; i < n; i++){
            if(code[i].equals("WA")){
                if(change > 0){
                    out.println("AC");
                    change--;
                }
                else{
                    out.println("WA");
                }
            }
            else if(code[i].equals("TLE")){
                out.println("WA");
            }
            else if(code[i].equals("IR")){
                if(count < 10){
                    out.println("AC");
                    count++;
                }
                else if(count < 20){
                    out.println("WA");
                    count++;
                }
                else{
                    out.println("IR");
                }
            }
            else{
                out.println("AC");
            }

        }



        out.close();
    }

    private static String next()throws IOException{
        while(st == null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
