import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    static class Word implements Comparable<Word>{
        String word;
        public Word(String word){
            this.word= word;
        }
        public int compareTo(Word other){
            int min = Math.min(other.word.length(), this.word.length());
            for(int i = 0 ; i < min; i++){
                if(other.word.charAt(i) != this.word.charAt(i)){
                    return this.word.charAt(i)-other.word.charAt(i);
                }
            }
            return this.word.length()-other.word.length();
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(next());
        Word[] arr = new Word[n];
        for(int  i = 0 ; i < n; i++){
            arr[i] = new Word(next());
        }
        Arrays.sort(arr);
        for(int i = 0 ; i < n; i++){
            out.println(arr[i].word);
        }


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

}
