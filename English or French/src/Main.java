
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int num = nextInt();
        int countT = 0;
        int countS = 0;
        for(int i = 0; i < num; i++){
            String temp = br.readLine();
            for(int o = 0 ; o < temp.length(); o++){
                if(temp.charAt(o) == 's' || temp.charAt(o) == 'S'){
                    countS++;
                }
                else if(temp.charAt(o) == 't' || temp.charAt(o) == 'T'){
                    countT++;
                }
            }
        }
        if(countT > countS){
            System.out.println("English");
        }
        else{
            System.out.println("French");
        }

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
