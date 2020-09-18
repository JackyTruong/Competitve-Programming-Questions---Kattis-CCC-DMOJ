import java.io.*;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static long temp;

    private static void pow2(){
        temp = temp&(temp-1);
        if(temp == 0){
            out.println("T");
        }
        else{
            out.println("F");
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n =  Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n; i++){
            temp = Long.parseLong(br.readLine());
            pow2();
        }


        out.close();
    }
}
