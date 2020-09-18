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
        boolean[] motelSpots = new boolean[7001];
        long[] paths = new long[7001];
        motelSpots[0] = true;
        motelSpots[990] = true;
        motelSpots[1010] = true;
        motelSpots[1970] = true;
        motelSpots[2030] = true;
        motelSpots[2940] = true;
        motelSpots[3060] = true;
        motelSpots[3930] = true;
        motelSpots[4060] = true;
        motelSpots[4970] = true;
        motelSpots[5030] = true;
        motelSpots[5990] = true;
        motelSpots[6010] = true;
        motelSpots[7000] = true;
        long A = nextLong();long B = nextLong();long C = nextLong();
        for(long i = 0; i < C; i++){
            motelSpots[(int)nextLong()] = true;
        }
        paths[0] = 1;
        for(int i = 1; i < 7001; i++){

            if(motelSpots[i]){

                paths[i] = 0;
                long tempMin = i-A;
                //System.out.println(tempMin + "this min");
                long tempMax = i-B;
                if(tempMax < 0){
                    tempMax = 0;
                }
                //System.out.println(tempMax + " thisMax");
                for(long o = tempMax; o <= tempMin; o++){
                    if(motelSpots[(int)o]){
                        //System.out.println(paths[o] + " " + o + " " + i);
                        paths[i] += paths[(int)o];
                    }
                }
            }
        }
        out.println(paths[7000]);
        out.close();
    }

    private static String next()throws IOException {
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static long nextLong()throws IOException{
        return Long.parseLong(next());
    }
}
