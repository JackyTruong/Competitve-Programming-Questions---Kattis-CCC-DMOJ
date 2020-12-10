import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int first = nextInt(), second = nextInt(), third  =nextInt(), fourth = nextInt();
        if(first == second+third+fourth || second == first+third+fourth || third == first+second+fourth || fourth == first+second+third){
            System.out.println("Yes");
        }
        else if(first+second == third+fourth || first + third == second + fourth || first + fourth == second + third){
            System.out.println("Yes");
        }
        else if(second + third == first + fourth || second + fourth == first + third){
            System.out.println("Yes");
        }
        else if(third + fourth == first + second) {
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
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
