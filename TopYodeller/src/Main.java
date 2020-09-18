import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    static class Pair{
        int score, num, worstRank;
        Pair(int score, int num){
            this.score = score;
            this.num = num;
        }

    }
    static class SortByScore implements Comparator<Pair>{
        public int compare(Pair a, Pair b){
            return b.score-a.score;
        }
    }
    static class SortByNum implements Comparator<Pair>{
        public int compare(Pair a, Pair b){
            return a.num - b.num;
        }
    }

    public static void main(String[] args)throws IOException{
        //FileInputStream file = new FileInputStream("s2.3.data");
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt(), rounds = nextInt();
        ArrayList<Pair> yodels = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            yodels.add(new Pair(nextInt(), i));
        }
        Collections.sort(yodels, new SortByScore());
        for(int i = 0 ; i < yodels.size();i++){
            if(yodels.get(i).worstRank < i && yodels.get(i).score < yodels.get(i-1).score) {
                yodels.get(i).worstRank = i;
            }
        }
        for(int i = 0 ; i < rounds-1;i++){
            Collections.sort(yodels, new SortByNum());
            for(int o = 0 ; o < n; o++){
                yodels.get(o).score += nextInt();

            }
            Collections.sort(yodels, new SortByScore());
                for(int a = 1 ; a < yodels.size();a++){
                    if(yodels.get(a).worstRank < a && yodels.get(a).score < yodels.get(a-1).score) {
                        yodels.get(a).worstRank = a;
                    }
                }

        }
        int highestScore = yodels.get(0).score;
        for(int i = 0 ; i < n; i++){
            if(yodels.get(i).score >= highestScore){
                out.println("Yodeller " + (yodels.get(i).num+1) + " is the TopYodeller: score " + yodels.get(i).score + ", worst rank " + (yodels.get(i).worstRank+1));
            }
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

}
