import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int[] val = new int[2];
        int instruct = nextInt();
        while(instruct != 7){
            if(instruct == 1){
                int num = next().charAt(0);
                if(num == 65){
                    val[0] = nextInt();
                }
                else{
                    val[1] = nextInt();
                }
            }
            else if(instruct == 2){
                int num = next().charAt(0);
                if(num == 65){
                    out.println(val[0]);
                }
                else{
                    out.println(val[1]);
                }
            }
            else if(instruct == 3){
                int first = next().charAt(0)-65;
                int second = next().charAt(0)-65;
                val[first] = val[first]+val[second];
            }
            else if(instruct == 4){
                int first = next().charAt(0)-65;
                int second = next().charAt(0)-65;
                val[first] = val[first]*val[second];
            }
            else if(instruct == 5){
                int first = next().charAt(0)-65;
                int second = next().charAt(0)-65;
                val[first] = val[first]-val[second];
            }
            else if(instruct == 6){
                int first = next().charAt(0)-65;
                int second = next().charAt(0)-65;
                val[first] = val[first]/val[second];
            }

            instruct = nextInt();
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
