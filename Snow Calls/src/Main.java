import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    private static char[] convert(String s){
        char[] holder = new char[10];
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == 'A' || s.charAt(i) == 'B' || s.charAt(i) == 'C'){
                holder[i] = '2';
            }
            else if(s.charAt(i) == 'D' || s.charAt(i) == 'E' || s.charAt(i) == 'F'){
                holder[i] = '3';
            }
            else if(s.charAt(i) == 'G' || s.charAt(i) == 'H' || s.charAt(i) == 'I'){
                holder[i] = '4';
            }
            else if(s.charAt(i) == 'J' || s.charAt(i) == 'K' || s.charAt(i) == 'L'){
                holder[i] = '5';
            }
            else if(s.charAt(i) == 'M' || s.charAt(i) == 'N' || s.charAt(i) == 'O'){
                holder[i] = '6';
            }
            else if(s.charAt(i) == 'P' || s.charAt(i) == 'Q' || s.charAt(i) == 'R' || s.charAt(i) == 'S'){
                holder[i] = '7';
            }
            else if(s.charAt(i) == 'T' || s.charAt(i) == 'U' || s.charAt(i) == 'V'){
                holder[i] = '8';
            }
            else if(s.charAt(i) == 'W' || s.charAt(i) == 'X' || s.charAt(i) == 'Y' || s.charAt(i) == 'Z'){
                holder[i] = '9';
            }
            else{
                holder[i] = s.charAt(i);
            }
        }
        return holder;
    }

    public static void main(String[] args)throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        for(int i = 0 ; i < n; i++){
            String num = next().replaceAll("-", "").substring(0,10);
            char[] temp = convert(num);
            //System.out.println(temp.length);
            for(int o = 0 ; o < 10; o++){
                if(o == 3 || o == 6){
                    out.print("-");
                }
                out.print(temp[o]);
            }
            out.println("");

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
