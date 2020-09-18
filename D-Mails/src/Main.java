import java.io.*;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static String msg;
    static boolean O, M, D, K;

    private static void testMsg(){
        String Okabe = "elpsycongroo";
        String Mayuri = "tuturu";
        String Daru = "superhacker";
        String Kurisu = "myfork";
        int o = 0;
        int m = 0;
        int d = 0;
        int k = 0;
        for(int i = 0 ; i < msg.length(); i++){
            if(o < Okabe.length() && msg.charAt(i) == Okabe.charAt(o)){
                o++;
            }
            if(m < Mayuri.length() && msg.charAt(i) == Mayuri.charAt(m)){
                m++;
            }
            if(d < Daru.length() && msg.charAt(i) == Daru.charAt(d)){
                d++;
            }
            if(k < Kurisu.length() && msg.charAt(i) == Kurisu.charAt(k)){
                k++;
            }
        }
        //System.out.println(o + " " + m + " " + d + " " + k);
        if(o == Okabe.length()){
            O = true;
        }
        if(m == Mayuri.length()){
            M = true;
        }
        if(d == Daru.length()){
            D = true;
        }
        if(k == Kurisu.length()){
            K = true;
        }

    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n; i++){
            msg = br.readLine();
            D = false;M = false;O = false; K = false;
            testMsg();
            //System.out.println(D + " " + M + " " + O + " " + K);
            String output = "";
            if(O){
                output += "Okabe";
            }
            if(M){
                if(output.isEmpty()){
                    output += "Mayuri";
                }
                else{
                    output += " or Mayuri";
                }
            }
            if(D){
                if(output.isEmpty()){
                    output += "Daru";
                }
                else{
                    output += " or Daru";
                }
            }
            if(K){
                if(output.isEmpty()){
                    output += "Kurisu";
                }
                else{
                    output += " or Kurisu";
                }
            }
            if(output.isEmpty()){
                output+= "SERN spy!";
            }
            out.println(output);
        }

        out.close();
    }

}
