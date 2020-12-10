import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int n, count;
    static int[]arr;
    static ArrayList<Bonus> bonuses;
    static ArrayList<Pair> used;

    static class Bonus implements  Comparable<Bonus>{
        int cost, amount;
        public Bonus(int cost){
            this.cost = cost;
            amount = 1;
        }
        public void addBonus(){
            this.amount++;
        }
        public int compareTo(Bonus other){
            return other.amount - this.amount;
        }
    }

    static class Pair{
        int first, second;
        public Pair(int first, int second){
            this.first =first;
            this.second =second;
        }
    }

    private static void addToB(int num){
        boolean found = false;
        for(int i = 0; i < bonuses.size() && !found; i++){
            if(bonuses.get(i).cost == num){
                bonuses.get(i).addBonus();
                found = true;
            }
        }
        if(!found){
            bonuses.add(new Bonus(num));
        }
    }

    private static boolean within(Pair temp){
        for(int i = 0 ; i < used.size(); i++){
            if(used.get(i).first == temp.first && used.get(i).second == temp.second){
                return true;
            }
        }
        return false;
    }

    private static void isSub(int start, int end){
        if(start != end){
            bonuses = new ArrayList<>();
            for(int i = start; i < end; i++){
                addToB(arr[i]);
            }
            boolean isNot = false;
            for(int i = 1 ; i < bonuses.size() && !isNot;i++){
                if(bonuses.get(i).amount != bonuses.get(i-1).amount || bonuses.size() != bonuses.get(i).amount){
                    isNot = true;
                }
            }
            if(!isNot){
                if((bonuses.size() == 1 && bonuses.get(0).amount == 1) || bonuses.size() > 1){
                    Pair temp = new Pair(start, end);
                    if(!within(temp)){
                        /*
                        System.out.println(start + " " + end);
                        for(int i = 0 ; i < bonuses.size(); i++){
                            System.out.print(bonuses.get(i).amount + " ");
                        }
                        System.out.println();
                        System.out.println();

                         */
                        count++;
                        used.add(temp);
                    }

                }
            }
            isSub(start+1, end);
            isSub(start, end-1);
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt();
        used = new ArrayList<>();
        count = 0;
        arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = nextInt();
        }
        isSub(0, n);
        out.println(count);

        out.close();
    }

    private static String next()throws IOException {
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
