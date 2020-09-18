import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int nBoys = nextInt();
        int[] boys = new int[nBoys];
        for(int i = 0 ; i < nBoys; i++){
            boys[i] = nextInt();
        }
        int baseNum = nextInt();
        int endNum = nextInt();
        int gap = 0;
        int spot = 0;
        Arrays.sort(boys);
        /*
        for(int i = 0 ; i < boys.length; i++){
            System.out.println(boys[i]);
        }


         */


        System.out.println();
        for(int i = 0 ; i < nBoys-1; i++){
            int temp = Math.abs(boys[i] - boys[i+1]);
            if(boys[i] + temp >= baseNum && boys[i] <= endNum){
                if(temp/2 > gap){
                    gap = temp/2;
                    spot = i;
                }
            }
        }

        if(boys[nBoys-1] < endNum){
            gap = endNum-boys[nBoys-1];
            spot = nBoys-1;
        }
        //System.out.println(gap + " " + spot);
        while(gap+boys[spot] > endNum || (gap+boys[spot])%2 == 0){
            gap--;
        }
        for(int i = 0 ; i < nBoys-1; i++){
            int temp = Math.abs(boys[i] - boys[i+1]);
            if(boys[i] + temp >= baseNum && boys[i] +temp <= endNum){
                if(temp/2 > gap){
                    gap = temp/2;
                    spot = i;
                }
            }
        }
        while(gap+boys[spot] > endNum || (gap+boys[spot])%2 == 0){
            gap--;
        }
        boolean fromBot = false;
        if(baseNum < boys[0]){
            int temp = Math.abs(baseNum - boys[0]);
            //System.out.println("this gap" + gap + " " + temp);
            if(temp > gap){
                fromBot = true;
            }
        }
        if(fromBot){
            if(baseNum % 2 == 1){
                out.println(baseNum);
            }
            else{
                out.println(baseNum+1);
            }
        }
        else{
            out.println(gap+boys[spot]);
        }

        out.close();
    }

    private static String next()throws IOException{
        while(st == null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
