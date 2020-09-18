import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    private static ArrayList<Integer> divisors(int n){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n%i == 0){
                temp.add(i);
            }
        }
        return temp;
    }

    private static boolean isNasty(int n){
        ArrayList<Integer> temp = divisors(n);
        for(int i = 0 ; i < temp.size(); i++){
            for(int o = 0 ; o < temp.size(); o++){
                if(i != o){
                    int firstA = temp.get(i) + (n/temp.get(i));
                    int firstS = (n/temp.get(i)) - temp.get(i);
                    int secondA = temp.get(o) + (n/temp.get(o));
                    int secondS = (n/temp.get(o)) - temp.get(o);
                    //System.out.println(firstA + " "  + firstS + " " + secondA + " " + secondS);
                    if(firstA == secondA || secondS == firstS || firstA == secondS || firstS == secondA){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int num = nextInt();
        for(int z = 0 ; z < num; z++){
            int temp = nextInt();
            if(isNasty(temp)){
                out.println(temp + " is nasty");
            }
            else{
                out.println(temp + " is not nasty");
            }
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
