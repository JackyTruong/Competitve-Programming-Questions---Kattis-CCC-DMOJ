import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int spotX, spotY;
    static int dist;

    private static void howFar(char letter, char[][] arrange){
        for(int i = 0 ; i < 5; i++){
            for(int o = 0 ; o < 6; o++){
                if(arrange[i][o] == letter){
                    dist += Math.abs(i - spotY);
                    dist += Math.abs(o-spotX);
                    spotX = o;
                    spotY = i;
                    return;
                }
                else if(letter == ' ' && arrange[i][o] == '1'){
                    dist += Math.abs(i - spotY);
                    dist += Math.abs(o-spotX);
                    spotX = o;
                    spotY = i;
                    return;
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        spotX = 0; spotY = 0;dist = 0;
        char[][] arrange = {{'A', 'B', 'C', 'D', 'E', 'F'}, {'G', 'H', 'I', 'J', 'K', 'L'},{'M', 'N', 'O','P','Q','R'},{'S','T','U','V','W','X'},
                {'Y','Z','1','-','.','2'}};
        String text = br.readLine();
        for(int i = 0 ; i < text.length();i++){
            howFar(text.charAt(i), arrange);
        }
        howFar('2', arrange);
        out.println(dist);
        out.close();
    }
}
