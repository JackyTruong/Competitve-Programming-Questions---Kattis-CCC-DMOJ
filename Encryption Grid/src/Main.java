import java.io.*;

public class Main {

    static BufferedReader br;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        while(n != 0){
            String code = br.readLine();
            String output = "";
            int row = code.length()/n;
            int col = n;
            char[][] arr = new char[row][col];
            int rS = 0;
            int cS = 0;
            boolean forward = true;
            for(int i = 0; i < code.length(); i++){
                arr[rS][cS] = code.charAt(i);
                if(forward){
                    cS++;
                }
                else{
                    cS--;
                }
                if(cS == col){
                    forward = false;
                    rS++;
                    cS--;
                }
                else if(cS == -1){
                    forward = true;
                    rS++;
                    cS++;
                }
            }
            for(int i = 0; i < col; i++){
                for(int o = 0 ; o < row; o++){
                    output+= arr[o][i];
                }
            }
            out.println(output);
            n = Integer.parseInt(br.readLine());
        }


        out.close();
    }
}
