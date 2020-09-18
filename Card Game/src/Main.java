import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int pA, pB, i;
    static ArrayList<String> cards;
    static boolean turn;

    private static boolean isHighCard(String s){
        if(s.equals("ace") || s.equals("king") || s.equals("queen") || s.equals("jack")){
            return true;
        }
        return false;
    }

    private static void addPoints(String s){
        if(s.equals("ace")){
            if(cards.size() >= 4){
                boolean hasHigh = false;
                for(int a = 0 ; a < 4 && !hasHigh; a++){
                    if(isHighCard(cards.get(a))){
                        hasHigh = true;
                    }
                }
                if(!hasHigh){
                    if(!turn){
                        out.println("Player A scores 4 point(s).");
                        pA += 4;
                    }
                    else{
                        out.println("Player B scores 4 point(s).");
                        pB += 4;
                    }
                }
            }
        }
        else if(s.equals("king")){
            if(cards.size() >= 3){
                boolean hasHigh = false;
                for(int a = 0 ; a < 3 && !hasHigh; a++){
                    if(isHighCard(cards.get(a))){
                        hasHigh = true;
                    }
                }
                if(!hasHigh){
                    if(!turn){
                        out.println("Player A scores 3 point(s).");
                        pA += 3;
                    }
                    else{
                        out.println("Player B scores 3 point(s).");
                        pB += 3;
                    }
                }
            }
        }
        else if(s.equals("queen")){
            if(cards.size() >= 2){
                boolean hasHigh = false;
                for(int a = 0 ; a < 2 && !hasHigh; a++){
                    if(isHighCard(cards.get(a))){
                        hasHigh = true;
                    }
                }
                if(!hasHigh){
                    if(!turn){
                        out.println("Player A scores 2 point(s).");
                        pA += 2;
                    }
                    else{
                        out.println("Player B scores 2 point(s).");
                        pB += 2;
                    }
                }
            }
        }
        else if(s.equals("jack")){
            if(cards.size() >= 1){
                boolean hasHigh = false;
                for(int a = 0 ; a < 1 && !hasHigh; a++){
                    if(isHighCard(cards.get(a))){
                        hasHigh = true;
                    }
                }
                if(!hasHigh){
                    if(!turn){
                        out.println("Player A scores 1 point(s).");
                        pA += 1;
                    }
                    else{
                        out.println("Player B scores 1 point(s).");
                        pB += 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        pA = 0;
        pB = 0;
        turn = false;
        cards = new ArrayList<>();
        for(i = 0 ; i < 52; i++){
            cards.add(next());
        }
        while(cards.size() > 0){
            addPoints(cards.remove(0));
            if(!turn){
                turn = true;
            }
            else{
                turn = false;
            }
        }
        out.println("Player A: " + pA + " point(s).");
        out.println("Player B: " + pB + " point(s).");
        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

}
