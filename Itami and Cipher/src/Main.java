import java.io.*;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static String s, t, decrypted;

    private static void moveCipher(int i){
        decrypted = "";
        for(int a = 0 ; a < s.length(); a++){
            int temp = s.charAt(a)-i;
            if(temp < 97){
                temp+=26;
            }
            decrypted+=(char)temp;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        s = br.readLine();t = br.readLine();
        boolean found = false;
        int num = 0;
        for(int i = 0; i < 26 && !found; i++){
            moveCipher(i);
            if(decrypted.contains(t)){
                found = true;
                num = i;
            }
        }
        out.println(num);
        out.println(decrypted);

        out.close();
    }
}
