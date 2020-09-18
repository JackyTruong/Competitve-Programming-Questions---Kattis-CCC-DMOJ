
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static String[][] ss;
    static int[][] num;

    private static int findNum(String s){
        int value;
        if(s.charAt(0) >= 'A' && s.charAt(0) <= 'J'){
            value = num[s.charAt(0)-'A'][s.charAt(1)-'1'];
        }
        else{
            value = Integer.parseInt(s);
        }
        return value;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        ss = new String[10][9];
        num = new int[10][9];
        for(int i = 0; i < 10; i++){
            for(int o = 0; o < 9; o++){
                ss[i][o] = next();
            }
            Arrays.fill(num[i],-1);
        }
        boolean doIt = true;
        while(doIt){
            doIt = false;
            for(int i = 0 ; i < 10; i++){
                for(int o = 0 ; o < 9; o++){
                    StringTokenizer temp = new StringTokenizer(ss[i][o],  "+");
                    int spotValue = 0;
                    int tempNum = 0;
                    while(temp.hasMoreTokens() && tempNum != -1){
                        tempNum = findNum(temp.nextToken());
                        if(tempNum == -1){
                            spotValue = -1;
                        }
                        else{
                            spotValue+=tempNum;
                        }
                    }
                    if(num[i][o] != spotValue){
                        num[i][o] = spotValue;
                        doIt = true;
                    }
                }
            }
        }
        for(int i = 0 ; i < 10; i++){
            for(int o = 0 ; o < 9; o++){
                if(num[i][o] == -1){
                    out.print("* ");
                }
                else{
                    out.print(num[i][o] + " ");
                }
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

}
