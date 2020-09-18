import java.io.*;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static String base, entire;
    static int spot;

    private static void KMP(){
        int baseL = base.length();
        int eL = entire.length();
        int lps[] = new int[baseL];
        int o = 0;
        computeLPSArr(baseL, lps);
        int i = 0;
        boolean found = false;
        while(i < eL && !found){
            if(base.charAt(o) == entire.charAt(i)){
                o++;
                i++;
            }
            if(o == baseL){
                found = true;
                spot = i-o;
                o = lps[o-1];
            }
            else if(i < eL && base.charAt(o) != entire.charAt(i)){
                if(o != 0){
                    o = lps[o-1];
                }
                else{
                    i++;
                }
            }
        }
    }

    private static void computeLPSArr(int baseL, int lps[]){
        int l = 0;
        int i = 1;
        lps[0]= 0;
        while(i < baseL){
            if(base.charAt(i) == base.charAt(l)){
                l++;
                lps[i] = l;
                i++;
            }
            else{
                if(l != 0){
                    l = lps[l-1];
                }
                else{
                    lps[i] = l;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        entire = br.readLine();
        base = br.readLine();
        spot = -1;
        KMP();
        out.println(spot);


        out.close();
    }
}
