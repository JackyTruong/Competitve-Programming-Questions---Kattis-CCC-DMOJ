
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;


    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> num = new ArrayList<>();
        int total = 0;
        int wrong = 0;
        for(int i = 0; i < n; i++){
            String temp = next();
            if(names.contains(temp)){
                int spot = names.indexOf(temp);
                if(num.get(spot) > total-num.get(spot)){
                    wrong++;
                }
                num.set(spot, num.get(spot)+1);
            }
            else{
                names.add(temp);
                num.add(1);
            }
            total++;
        }

        out.println(wrong);

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
