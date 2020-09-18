import java.io.*;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static int[] count;

    private static void addToLetter(char letter){
        int temp = ((int)letter)-97;
        if(temp < 26 && temp >= 0){
            count[temp]++;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int i = 0 ; i < 2; i++){
            count = new int[26];
            String temp = br.readLine().toLowerCase();
            for(int o = 0 ; o < temp.length(); o++){
                addToLetter(temp.charAt(o));
            }
            String output = "";
            for(int o = 0 ; o < 26; o++){
                if(count[o] > 0){
                    char let = (char)(o+65);
                    output+=let+ "-" + count[o] + ":";
                }
            }
            output = output.substring(0, output.length()-1);
            out.println(output);
        }


        out.close();
    }
}
