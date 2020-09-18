import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int A, B, paths;
    static ArrayList<Integer> motels;

    private static void numPaths(int spot){
        //System.out.println("this is spot "  + spot);
        if(spot == 7000){
            paths++;
        }
        int tempMin = spot+A;
        int tempMax = spot+B;
        //System.out.println(tempMin + " " + tempMax);
        for(int i = 0 ; i < motels.size();i++){
            if(motels.get(i) >= tempMin && motels.get(i) <= tempMax){
                numPaths(motels.get(i));
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        A = nextInt();B = nextInt();
        motels = new ArrayList<>();
        motels.add(990);
        motels.add(1010);
        motels.add(1970);
        motels.add(2030);
        motels.add(2940);
        motels.add(3060);
        motels.add(3930);
        motels.add(4060);
        motels.add(4970);
        motels.add(5030);
        motels.add(5990);
        motels.add(6010);
        motels.add(7000);
        int c = nextInt();
        for(int i = 0 ; i < c; i++){
            int temp = nextInt();
            motels.add(temp);
        }
        paths = 0;
        numPaths(0);
        out.println(paths);

        out.close();
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
