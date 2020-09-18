import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int rows = nextInt(); int cols = nextInt();
        char[][] base = new char[rows][cols];
        for(int i = 0 ; i < rows; i++){
            base[i] = next().toCharArray();
        }
        char[][] end = new char[rows*2][cols*2];
        for(int i = 0 ; i < rows; i++){
            for(int o = 0 ; o < cols; o++){
                end[i][o] = base[i][o];
            }
        }
        for(int i = 0 ; i < rows; i++){
            for(int o = 0 ; o < cols; o++){
                end[i][cols*2-1-o] = base[i][o];
            }
        }
        for(int i = 0 ; i < rows; i++){
            for(int o = 0 ; o < cols; o++){
                end[rows*2-1-i][o] = base[i][o];
            }
        }
        for(int i = 0 ; i < rows; i++){
            for(int o = 0 ; o < cols; o++){
                end[rows*2-1-i][cols*2-1-o] = base[i][o];
            }
        }
        int changeR = nextInt(), changeC = nextInt();
        if(end[changeR-1][changeC-1] == '.'){
            end[changeR-1][changeC-1] = '#';
        }
        else{
            end[changeR-1][changeC-1] = '.';
        }
        for(int i = 0 ; i < rows*2; i++){
            for(int o = 0 ; o < cols*2 ; o++){
                System.out.print(end[i][o]);
            }
            System.out.println();
        }

        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
