import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static ArrayList<Word> words;
    static char[][] cross;
    static int r, c;

    static class Word implements Comparable<Word>{
        String word;
        public Word(String word){
            this.word = word;
        }

        public int compareTo(Word other){
            int shortest = Math.min(other.word.length(), this.word.length());
            for(int i = 0 ; i < shortest; i++){
                int temp = (int)this.word.charAt(i) - (int)other.word.charAt(i);
                if(temp != 0){
                    return (int)this.word.charAt(i) - (int)other.word.charAt(i);
                }
            }
            return this.word.length() - other.word.length();
        }
    }

    private static void findTop(){
        for(int i = 0 ; i < c; i++){
            String word = "";
            for(int o = 0 ; o < r; o++){
                //System.out.println(cross[o][i]);
                if(cross[o][i] != '#'){
                    word += cross[o][i];
                }
                else{
                    if(word.length() > 1){
                        words.add(new Word(word));
                    }
                    word = "";
                }
            }
            if(word.length() > 1){
                words.add(new Word(word));
            }
        }
    }

    private static void findSide(){
        for(int i = 0 ; i < r; i++){
            String word = "";
            for(int o = 0; o < c; o++){
                if(cross[i][o] != '#'){
                    word+=cross[i][o];
                }
                else{
                    if(word.length() > 1){
                        words.add(new Word(word));
                    }
                    word = "";
                }
            }
            if(word.length() > 1){
                words.add(new Word(word));
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        r = nextInt();c = nextInt();
        cross = new char[r][c];
        words = new ArrayList<>();
        for(int i = 0 ; i < r; i++){
            cross[i] = next().toCharArray();
        }
        findTop();
        findSide();
        Collections.sort(words);
        /*
        for(int i = 0 ; i < words.size();i++){
            System.out.println(words.get(i).word);
        }
         */
        out.println(words.get(0).word);
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
