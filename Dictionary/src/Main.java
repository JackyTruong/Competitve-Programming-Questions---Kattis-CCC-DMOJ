import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static BufferedReader br;

    static class Word implements Comparable<Word>{
        String word;
        public Word(String word){
            this.word = word;
        }
        public int compareTo(Word other){
            int len = Math.min(other.word.length(), this.word.length());
            for(int i = 0 ; i < len; i++){
                if(other.word.charAt(i) < this.word.charAt(i)){
                    return 1;
                }
                else if(this.word.charAt(i) < other.word.charAt(i)){
                    return -1;
                }
            }
            return 1;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Word>> temp = new ArrayList<>();
        for(int i = 0 ; i < 26; i++){
            temp.add(new ArrayList<>());
        }
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n; i++){
            String hold = br.readLine();
            temp.get(hold.charAt(0)-97).add(new Word(hold));
        }
        for(int i = 0 ; i < 26; i++){
            Collections.sort(temp.get(i));
        }
        for(int i = 0 ; i < temp.size(); i++){
            for(int o = 0 ; o < temp.get(i).size();o++){
                if(o < temp.get(i).size()-1){
                    System.out.print(temp.get(i).get(o).word + ", ");
                }
                else{
                    System.out.println(temp.get(i).get(o).word);
                }
            }
        }
    }
}
