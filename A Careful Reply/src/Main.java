import java.io.*;

public class Main {

    static BufferedReader br;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine().trim());
        for(int z = 0; z < t; z++){
            String text = br.readLine();
            int count = 0;
            for(int i = 0 ; i < text.length()-1; i++){
                if(text.charAt(i) == '<' && text.charAt(i+1) == '3'){
                    count++;
                }
            }
            for(int i = 0 ; i <= count; i++){
                out.print("<3 ");
            }
            out.println();
        }



        out.close();
    }
}
