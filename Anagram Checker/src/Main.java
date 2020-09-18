import java.io.*;

public class Main {

    static BufferedReader br;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        String first = br.readLine();
        String second = br.readLine();
        int[] firstCount = new int[27];
        int[] secondCount = new int[27];
        for(int i = 0 ; i < first.length();i++){
            if(first.charAt(i) != ' '){
                firstCount[first.charAt(i)-65]++;
            }
        }
        for(int i = 0; i < second.length();i++){
            if(second.charAt(i) != ' '){
                secondCount[second.charAt(i)-65]++;
            }
        }
        boolean same = true;
        for(int i = 0 ; i < 27; i++){
            if(firstCount[i] != secondCount[i]){
                same = false;
            }
        }
        if(same){
            out.println("Is an anagram.");
        }
        else{
            out.println("Is not an anagram.");
        }

        out.close();
    }
}
