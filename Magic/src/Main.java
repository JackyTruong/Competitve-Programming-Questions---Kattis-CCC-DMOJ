import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int track, push, Sa, Sb, Pa, Pb;

    private static void adjustPush(){
        if(Math.abs(Pa - Pb) < push){
            if(Pa < Pb){
                Pb += (push-Math.abs(Pa-Pb));
            }
            else{
                Pb -= (push-Math.abs(Pa-Pb));
            }
        }
    }

    private static boolean checkPrimeDist(){
        int tempP = Math.min(Pa , track-Pa);
        int tempB = Math.min(Pb, track-Pb);
        return BigInteger.valueOf(tempP + tempB).isProbablePrime(1);
    }


    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        track = nextInt(); push = nextInt(); Sa = nextInt(); Sb = nextInt(); Pa = nextInt(); Pb = nextInt();
        adjustPush();
        boolean done = false;
        while(Pa <= track && Pb <= track && !done){
            Pa += Sa;
            Pb += Sb;
            adjustPush();
            if(checkPrimeDist()){
                out.println("Alice");
                done = true;
            }
        }
        if(!done){
            out.println("Bob");
        }



        out.close();
    }

    private static String next()throws IOException{
        while(st == null ||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
