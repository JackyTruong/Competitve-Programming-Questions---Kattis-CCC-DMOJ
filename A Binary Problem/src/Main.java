import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int[] dp;
    static int num;
    static String houses;

    private static int before(int i){
        int count = 1;
        for(int o = 2 ; o <= i; o++){
            count += o;
        }
        return count;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        num = nextInt();
        houses = next();
        dp = new int[num];
        Arrays.fill(dp, Integer.MAX_VALUE);
        ArrayList<Integer> spots = new ArrayList<>();
        for(int i = 0 ; i < num; i++){
            //System.out.println(houses.charAt(i));
            if(houses.charAt(i) == '1'){
                spots.add(i);
            }
        }
        int count = 0;
        for(int i = 0 ; i < spots.size()-1;i++){
            int temp = Math.abs(spots.get(i)-spots.get(i+1));
            if(temp > 1){
                if(temp % 2 == 1){
                    count += before(temp/2)*2;
                }
                else{
                    count += before(temp/2)*2-temp/2;
                }
            }
        }
        out.println(count);


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
