import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static ArrayList<WordCount> words;

    static class WordCount implements Comparable<WordCount>{
        String word;
        int count;
        public WordCount(String word){
            this.word = word;
            count = 1;
        }
        public void addOne(){
            count++;
        }
        public int compareTo(WordCount other){
            return this.count-other.count;
        }
    }

    private static void addToWord(String word){
        for(int i = 0 ;i < words.size(); i++){
            if(words.get(i).word.equals(word)){
                words.get(i).addOne();
                return;
            }
        }
        words.add(new WordCount(word));
    }

    //TODO TRY BRUTE FORCING FIRST THEN TRY BINARY SEARCH ON WORDS

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = nextInt();
        for(int z = 0 ;z < t; z++){
            int n = nextInt();
            int k = nextInt();
            words = new ArrayList<>();
            for(int i = 0 ; i  < n; i++){
                addToWord(next());
            }
            ArrayList<Integer> counts = new ArrayList<>();
            for(int i = 0 ; i < words.size(); i++){
                if(!counts.contains(words.get(i).count)){
                    counts.add(words.get(i).count);
                }
            }
            Collections.sort(counts);
            if(k == 1){
                out.println("1st most commonm word(s):");
            }
            else if(k == 2){
                out.println("2nd most common word(s):");
            }
            else if(k == 3){
                out.println("3rd most common word(s):");
            }
            else{
                out.println(k + "th most common word(s):");
            }
            for(int i = 0 ; i < words.size(); i++){
                if(counts.size()-k >= 0 && words.get(i).count == counts.get(counts.size()-k)){
                    out.println(words.get(i).word);
                }
            }
            out.println();

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
