import java.io.*;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static String[] framed;

    private static void addFirst(char letter){
        framed[0] += "..#..";
        framed[1] += ".#.#.";
        framed[2] += "#." + letter + ".#";
        framed[3] += ".#.#.";
        framed[4] += "..#..";
    }

    private static void addSecond(char letter){
        framed[0] += ".#.";
        framed[1] += "#.#";
        framed[2] += "." + letter + ".";
        framed[3] += "#.#";
        framed[4] += ".#.";
    }
    private static void addThird(char letter){
        framed[0] += "..*..";
        framed[1] += ".*.*.";
        framed[2] += "*." + letter + ".*";
        framed[3] += ".*.*.";
        framed[4] += "..*..";

    }

    private static void addAfter(char letter){
        framed[0] += ".#..";
        framed[1] += "#.#.";
        framed[2] += "." + letter + ".#";
        framed[3] += "#.#.";
        framed[4] += ".#..";
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        framed = new String[5];
        for(int i = 0 ; i < 5; i++){
            framed[i] = "";
        }
        String word = br.readLine();
        int count = 1;
        for(int i = 0 ; i < word.length(); i++){
            if(count == 1 && i == 0){
                addFirst(word.charAt(i));
                count++;
            }
            else if(count == 1){
                addAfter(word.charAt(i));
                count++;
            }
            else if(count == 2 && i == word.length()-1){
                addAfter(word.charAt(i));
                count++;
            }
            else if(count == 2){

                addSecond(word.charAt(i));
                count++;
            }
            else{
                addThird(word.charAt(i));
                count = 1;
            }
        }

        for(int i = 0 ; i < 5; i++){
            out.println(framed[i]);
        }


        out.close();
    }
}
