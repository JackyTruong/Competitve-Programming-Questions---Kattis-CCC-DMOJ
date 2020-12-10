import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int r, c, people, extraMoney;
    static int[] heights;



    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        r = nextInt(); c = nextInt(); people = nextInt();
        extraMoney = 0;
        heights = new int[people];
        for(int i = 0 ; i < people; i++){
            heights[i] = nextInt();
        }
        Arrays.sort(heights);
        int num = people/r;
        if(num*r < people){
            num++;
        }
        int begin = 0;
        //System.out.println(num);
        for(int i = 0 ; i < num; i++){
            int spot = people-i-1;
            //System.out.println(spot);
            int amount = Math.min(r-1, people-i-begin-1);
            for(int o = 0; o < amount; o++, begin++){
                //System.out.println("here " + o + " " + begin + " " + amount);
                //System.out.println(Math.abs(heights[spot] - heights[begin])+1+o);
                extraMoney += Math.abs(heights[spot] - heights[begin])+o+1;
            }

        }
        out.println(extraMoney);


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
