import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int[]arr;
    static int buildings, seenL, seenR, seenT, alreadyR, alreadyL, startL, startR;

    private static void fillRight(){
        //System.out.println(startR + " " + seenR);
        if(buildings-startR+seenT >= seenR){
            int temp = (buildings-startR+seenT-seenR)+1;
            while(buildings-startR-temp > 0){
                arr[startR] = arr[startR-1]-1;
                startR++;

            }
            int o = 1;
            while(startR <= buildings){
                //System.out.println(startR + " here");
                arr[startR] = o;
                startR++;
                o++;
            }
        }
        else{
            while(buildings-startR > 0){
                arr[startR] = arr[startR-1]-1;
                startR++;
            }
        }
    }

    private static void fillLeft(){
        if(startL+seenT >= seenL){
            int temp = (startL+seenT-seenL)+1;
            while(startL-temp > 0){
                arr[startL] = arr[startL-1]-1;
                startL++;

            }
            int o = 1;
            while(startL > 0){
                //System.out.println(startR + " here");
                arr[startL] = o;
                startL--;
                o--;
            }
        }
        else{
            for(int i = startL; i > 0; i--){
                arr[i] = arr[i+1]-1;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = nextInt();
        for(int z = 0 ; z < t; z++){
            buildings = nextInt();
            seenL = nextInt();
            seenR = nextInt();
            seenT = nextInt();
            alreadyL = 1;
            alreadyR = 1;
            arr = new int[buildings+1];
            startL = seenL-seenT;
            for(int i = 0 ; i < seenT; i++){
                arr[seenL-seenT+1+i] = buildings;
            }
            startR = seenL+1;
            //System.out.println(startL + " "  +startR);
            fillRight();
            fillLeft();
            if(seenL == seenR && seenL == buildings && seenL > seenT){
                out.println("Case #" + (z+1) + ": IMPOSSIBLE");
            }
            else{
                out.print("Case #" + (z+1) + ": ");
                for(int i = 1; i <= buildings; i++){
                    out.print(arr[i] + " ");
                }
                out.println();
            }

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
