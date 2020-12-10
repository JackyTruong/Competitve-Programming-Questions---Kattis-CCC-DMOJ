import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int[][] percents;
    static int bonds;
    static ArrayList<Integer> bondsUsed, bondPercent;

    static class Bond implements Comparable<Bond>{
        int num, percent;
        public Bond(int num, int percent){
            this.num = num;
            this.percent = percent;
        }

        public int compareTo(Bond o){
            return o.percent-this.percent ;
        }
    }

    private static void findHighest(int row){
        Bond[] temp = new Bond[bonds];
        for(int i = 0 ; i < bonds; i++){
            temp[i] = new Bond(i, percents[row][i]);
        }
        Arrays.sort(temp);
        boolean foundBond = false;
        for(int i = 0 ; i < bonds && !foundBond; i++){
            if(!bondsUsed.contains(temp[i].num)){
                bondsUsed.add(temp[i].num);
                bondPercent.add(temp[i].percent);
                foundBond = true;
            }
        }

        /*
        for(int i = 0 ; i < bonds; i++){
            System.out.println(temp[i].num + " " + temp[i].percent);
        }

         */
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        bonds = nextInt();
        bondsUsed = new ArrayList<>();
        bondPercent = new ArrayList<>();
        percents = new int[bonds][bonds];
        for(int i = 0 ; i < bonds; i++){
            for(int o = 0 ; o < bonds; o++){
                percents[i][o] = nextInt();
            }
        }

        for(int i = 0 ; i < bonds; i++){
            findHighest(i);
        }
        double total = 1;
        for(int i = 0 ; i < bondPercent.size(); i++){
            total *= (double)bondPercent.get(i)/100;
        }
        System.out.printf("%.06f", total*100);

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
