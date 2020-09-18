import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static class Word implements Comparable<Word>{
        String word;
        public Word(String word){
            this.word = word;
        }

        public int compareTo(Word other){
            for(int i = 0 ; i < other.word.length(); i++){
                if(other.word.charAt(i) != this.word.charAt(i)){
                    return this.word.charAt(i)-other.word.charAt(i);
                }
            }
            return 0;
        }

    }

    static BufferedReader br;
    static PrintWriter out;
    static ArrayList<Word> all;
    static String temp;

    private static void anagrams(String soFar, boolean[] used){
        if(soFar.length() < temp.length()){
            for(int o = 0 ; o < temp.length();o++){
                if(!used[o]){
                    used[o] = true;
                    String other = soFar;
                    other += temp.charAt(o);
                    anagrams(other, used);
                    used[o] = false;
                }
            }
        }
        else{
            all.add(new Word(soFar));
        }

    }

    public static void main(String[] args)throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        temp = br.readLine().trim();
        all = new ArrayList<>();
        anagrams("", new boolean[temp.length()]);
        Collections.sort(all);
        for(int i= 0 ; i < all.size(); i++){
            out.println(all.get(i).word);
        }
        out.close();
    }
}
