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
        int gates = nextInt();
        int[] doneGates = new int[gates+1];
        int planes = nextInt();
        int count = 0;
        boolean foundGate = true;
        int i = 0;
        while(i < planes && foundGate){
            int newPlane = nextInt();
            while(newPlane > 0 && doneGates[newPlane] > 0){
                int temp = doneGates[newPlane];
                doneGates[newPlane]++;
                newPlane-=temp;
            }
            if(newPlane <= 0){
                foundGate = false;
            }
            else{
                doneGates[newPlane]++;
                count++;
            }
            i++;
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
