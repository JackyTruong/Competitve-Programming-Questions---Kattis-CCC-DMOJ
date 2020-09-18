import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static ArrayList<Pair> animals;
    static int length;

    static class Pair implements Comparable<Pair>{
        int start, end;
        public Pair(int start,int end){
            this.start = start;
            this.end = end;
        }
        public void changeStart(int start){
            this.start = start;
        }
        public void changeEnd(int end){
            this.end = end;
        }
        public int compareTo(Pair A){
            return this.start - A.start;
        }
    }

    private static boolean isWithin(int start, int end){
        boolean isIn = false;
        int index = 0;
        for(int i = 0 ; i < animals.size() && !isIn;i++){
            if(animals.get(i).start < end && animals.get(i).end > end){
                isIn = true;
                index = i;
            }
            else if(animals.get(i).start < start && animals.get(i).end > start){
                isIn = true;
                index = i;
            }
            else if(animals.get(i).end == start || animals.get(i).start == end){
                isIn = true;
                index = i;
            }
        }
        if(isIn){
            if(start < animals.get(index).start){
                animals.get(index).changeStart(start);
            }
            if(end > animals.get(index).end){
                animals.get(index).changeEnd(end);
            }
            isWithin(animals.get(index).start, animals.get(index).end);
            return true;
        }
        else{
            return false;
        }
    }

    private static int longestDist(){
        int longest = Math.abs(0-animals.get(0).start);
        for(int i = 1; i < animals.size(); i++){
            if(Math.abs(animals.get(i).start-animals.get(i-1).end) > longest){
                longest = Math.abs(animals.get(i).start-animals.get(i-1).end);
            }
        }
        if(longest < Math.abs(length-animals.get(animals.size()-1).end)){
            longest = Math.abs(length-animals.get(animals.size()-1).end)-1;
        }
        return longest;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        length = nextInt();
        animals = new ArrayList<>();
        int num = nextInt();
        for(int i = 0 ;i < num; i++){
            int start = nextInt();
            int end = nextInt();
            if(!isWithin(start,end)){
                animals.add(new Pair(start,end));
            }
        }
        Collections.sort(animals);
        /*
        for(int i = 0 ; i < animals.size(); i++){
            System.out.println(animals.get(i).start + " " + animals.get(i).end);
        }

         */

        out.println(longestDist());

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
