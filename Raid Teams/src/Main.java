import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    static class Player{
        String name;
        int firstSkill, secondSkill, thirdSkill;

        public Player(String name,int firstSkill, int secondSkill, int thirdSkill){
            this.name = name;
            this.firstSkill = firstSkill;
            this.secondSkill = secondSkill;
            this.thirdSkill = thirdSkill;
        }
        public String toString(){
            return this.name + " " + this.firstSkill + " " + this.secondSkill + " " + this.thirdSkill;
        }
    }
    static class SortByFirstSkills implements Comparator<Player> {
        public int compare(Player a, Player b){
            return b.firstSkill-a.firstSkill;
        }
    }
    static class SortBySecondSkills implements Comparator<Player> {
        public int compare(Player a, Player b){
            return b.secondSkill-a.secondSkill;
        }
    }
    static class SortByThirdSkills implements Comparator<Player> {
        public int compare(Player a, Player b){
            return b.thirdSkill-a.thirdSkill;
        }
    }
    static class SortPlayerLength implements Comparator<Player> {
        public int compare(Player a, Player b){
            return a.name.length()-b.name.length();
        }
    }
    static class SortLength implements Comparator<String> {
        public int compare(String a, String b){
            return a.length()-b.length();
        }
    }



    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        int teams = n/3;
        ArrayList<Player> players = new ArrayList<>();
        for(int i = 0; i < n; i++){
            players.add(new Player(next(), nextInt(), nextInt(), nextInt()));
        }
        String[] temp = new String[3];
        for(int i = 0 ; i < teams; i++){
            //SORT BY SMALLEST TO LARGEST SO U GRAB THE GUY WITH THE LARGEST NAME WITH THE HIGHEST ONE
            Collections.sort(players, new SortByFirstSkills());
            temp[0] = players.get(0).name;
            players.remove(0);
            Collections.sort(players, new SortBySecondSkills());
            temp[1] = players.get(0).name;
            players.remove(0);
            Collections.sort(players, new SortByThirdSkills());
            temp[2] = players.get(0).name;
            players.remove(0);
            Arrays.sort(temp, new SortLength());
            out.print(temp[0] + " " + temp[1] + " " + temp[2]);
            out.println();
        }
        /*out.println("unsorted");
        for(int i = 0; i < n; i++){
            out.println(players.get(i));
        }

        out.println("first skills");
        for(int i = 0; i < n; i++){
            out.println(players.get(i));
        }

        out.println("second skills");
        for(int i = 0; i < n; i++){
            out.println(players.get(i));
        }

        out.println("third skills");
        for(int i = 0; i < n; i++){
            out.println(players.get(i));
        }
        Collections.sort(players, new SortLength());
        out.println("by name");
        for(int i = 0; i < n; i++){
            out.println(players.get(i));
        }*/

        out.close();
    }
    static String next()throws IOException{
        if(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int nextInt()throws IOException{
       return Integer.parseInt(next());
    }
}
