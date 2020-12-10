import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int z = 0 ;z < 5; z++){
            int row = nextInt(), col = nextInt();
            char[][] board = new char[row][col];
            for(int i  = 0; i < row; i++){
                board[i] = next().toCharArray();
            }
            String word = next();
            char[][] output = new char[row][col];
            int letterAt = 0;
            for(int i = 0 ; i < row; i++){
                for(int o = 0 ; o < col; o++){
                    if(letterAt < word.length() && board[i][o] == word.charAt(letterAt)){
                        letterAt++;
                        output[i][o] = '.';
                    }
                    else{
                        output[i][o] = '#';
                    }
                }
            }
            if(letterAt == word.length()){
                for(int i  =0 ;  i < row; i++){
                    for(int o = 0 ; o < col; o++){
                        out.print(output[i][o]);
                    }
                    out.println();
                }
            }
            else{
                for(int i = 0 ; i < row; i++){
                    for(int o = 0 ; o < col; o++){
                        out.print("x");
                    }
                    out.println();
                }
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

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
