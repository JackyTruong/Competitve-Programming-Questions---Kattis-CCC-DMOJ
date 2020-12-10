import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static char[] letter;
    static String[] change, letterEnd;
    static int baseLength;
    static char[] base;
    static int r, t;

    public static void howMany(char let){
            String temp = Character.toString(let);
            for(int a = 0; a < t; a++){
                String temp1 = "";
                for(int c = 0; c < temp.length();c++) {
                    for (int b = 0; b < letter.length; b++) {
                        if(letter[b] == temp.charAt(c)){
                            temp1 += change[b];
                        }
                    }
                }
                temp = temp1;
            }
            letterEnd[let-65] = temp;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int i = 0 ; i < 5; i++){
            r = nextInt(); t = nextInt();
            base = next().toCharArray();
            baseLength = base.length;
            letter= new char[r];
            change= new String[r];
            letterEnd = new String[26];
            for(int o = 0; o < r;o++){
                letter[o] = nextChar();
                change[o] = next();
            }
            for(int a = 65; a < 65+26; a++){
                howMany((char)a);
                //System.out.println(letterEnd[a-65]);
            }
            int count = 0;
            for(int a = 0; a < base.length; a++){
                count += letterEnd[base[a]-65].length();
            }
            out.println(count);


        }

        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }
    private static char nextChar()throws IOException{
        return next().charAt(0);
    }
}
