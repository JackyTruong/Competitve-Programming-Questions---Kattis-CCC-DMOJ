import java.io.*;

public class Main {

    static BufferedReader br;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int z = 0 ; z < 5; z++){
            for(int i = 0 ; i < 7; i++){
                String line = br.readLine();
                int count = 0;
                for(int a = 0 ; a < line.length(); a++){
                    if(line.charAt(a) == '#'){
                        count++;
                    }
                }
                out.print(count);
            }
            out.println();
            if(z != 4){
                br.readLine();
            }
        }


        out.close();
    }
}
