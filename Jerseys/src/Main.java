import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int jerseys = nextInt();
        int athletes = nextInt();
        char[] sizes = new char[jerseys];
        boolean[] isDone = new boolean[jerseys];
        Arrays.fill(isDone, false);
        int complete = 0;
        for(int i = 0 ; i < jerseys; i++){
            sizes[i] = next().charAt(0);
        }
        for(int i = 0 ; i < athletes; i++){
            char size = next().charAt(0);
            int num = nextInt();
            if(sizes[num-1] == size && !isDone[num-1]){
                isDone[num-1] = true;
                complete++;
            }
            else if(sizes[num-1] == 'L' && !isDone[num-1]){
                isDone[num-1] = true;
                complete++;
            }
            else if(sizes[num-1] == 'M' && (size == 'M' || size == 'S')&& !isDone[num-1]){
                isDone[num-1] = true;
                complete++;
            }
            else if(sizes[num-1] == 'S' && size == 'S' && !isDone[num-1]){
                isDone[num-1] = true;
                complete++;
            }
        }
        out.println(complete);


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
