import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static String encrypted, key;
    static StringBuilder output;
    static boolean foundHydra;
    static int[] temp;
    static ArrayList<String> possible;

    private static char letter(int num){
        return ((char)(num+65));
    }

    private static void decrypt(){
        output = new StringBuilder();
        temp = new int[26];
        for(int i = 0 ; i < 26; i++){
            temp[key.charAt(i)-65] = i;
        }
        String hydra = "";
        for(int o = 0 ; o < possible.size() && !foundHydra; o++){
            for(int i = 0 ; i < 9; i++){
                hydra += (letter(temp[possible.get(o).charAt(i)-65]));
            }
            if(hydra.equals("HAILHYDRA")){
                foundHydra = true;
            }
        }
        for(int i = 0 ; i < encrypted.length(); i++){
            output.append(letter(temp[encrypted.charAt(i)-65]));
        }

    }

    private static boolean doesNot(String hold){
        int[] arr = {2, 3, 5, 6, 7};
        if(hold.charAt(2) != hold.charAt(3) && hold.charAt(3) != hold.charAt(5) && hold.charAt(5) != hold.charAt(6) && hold
        .charAt(6) != hold.charAt(7) && hold.charAt(7) != hold.charAt(0)){
            return true;
        }
        return false;
    }

    private static boolean hasHydra(){
        for(int i = 0 ; i < encrypted.length()-8; i++){
            String hold = encrypted.substring(i, i+9);
            if(hold.charAt(0) == hold.charAt(4) && hold.charAt(1)== hold.charAt(8) && hold.charAt(0) != hold.charAt(1)){
                if(doesNot(hold)){
                    possible.add(hold);
                }
            }
        }
        return false;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        encrypted = next();
        int n = nextInt();
        foundHydra = false;
        possible = new ArrayList<>();
        hasHydra();
        for(int i = 0 ; i < n && !foundHydra; i++){
            key = next();
            decrypt();
        }
        if(!foundHydra){
            out.println("KeyNotFoundError");
        }
        else{
            out.println(output);
        }

        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
