import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static ArrayList<Acorn> acorns;

    static class Acorn implements  Comparable<Acorn>{
        int cost, amount;
        public Acorn(int cost){
            this.cost = cost;
            amount = 1;
        }
        public void addAcorn(){
            this.amount++;
        }
        public void removeAcorn(){
            this.amount--;
        }
        public int compareTo(Acorn other){
            return other.cost - this.cost;
        }
    }

    private static void addToA(int num){
        boolean found = false;
        for(int i = 0; i < acorns.size() && !found; i++){
            if(acorns.get(i).cost == num){
                acorns.get(i).addAcorn();
                found = true;
            }
        }
        if(!found){
            acorns.add(new Acorn(num));
        }
    }

    private static void takeAway(int largest){
        for(int i = 0 ; i < acorns.size();i++){
            acorns.get(i).removeAcorn();
            if(acorns.get(i).amount == 0){
                acorns.remove(i);
                i--;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        acorns = new ArrayList<>();
        int total = 0;
        for(int i = 0 ; i < n; i++){
            int temp = nextInt();
            addToA(temp);
        }
        Collections.sort(acorns);
        /*
        for(int i = 0 ; i < acorns.size(); i++){
            System.out.println(acorns.get(i).cost + " " + acorns.get(i).amount);
        }

         */
        while(!acorns.isEmpty()){
            total += acorns.get(0).cost;
            takeAway(acorns.get(0).cost);
        }
        out.println(total);


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
