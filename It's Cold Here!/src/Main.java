import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    static class Pair implements Comparable<Pair>{
        String name; int temp;

        public Pair(String name, int temp){
            this.name = name;
            this.temp = temp;
        }
        public int compareTo(Pair p){
            return this.temp - p.temp;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        ArrayList<Pair> cities = new ArrayList<>();
        String name = next();
        int temper = nextInt();
        while(!name.equals("Waterloo")){
            cities.add(new Pair(name, temper));
            name = next();
            temper = nextInt();
        }
        cities.add(new Pair(name, temper));
        Collections.sort(cities);
        System.out.println(cities.get(0).name);

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
