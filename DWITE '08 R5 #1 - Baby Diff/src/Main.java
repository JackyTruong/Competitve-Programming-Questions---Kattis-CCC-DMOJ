import java.io.*;

public class Main {

    static BufferedReader br;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int z=  0 ;z <5; z++){
            String first = br.readLine();
            String second = br.readLine();
            int shorter = Math.min(first.length(), second.length());
            int count = 0;
            for(int i = 0 ; i < shorter; i++){
                if(first.charAt(i) == second.charAt(i)){
                    count++;
                }
                else{
                    break;
                }
            }
            out.println(count);
        }


        out.close();
    }
}
