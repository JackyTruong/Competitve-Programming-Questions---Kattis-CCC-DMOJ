import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static ArrayList<Test> tests;

    static class Test implements  Comparable<Test>{
        int first, last, points;
        public Test(int first,int last, int points){
            this.first = first;
            this.last = last;
            this.points = points;
        }
        public int compareTo(Test other){
            if(this.first - other.first == 0){
                return other.last - this.last;
            }
            return this.first - other.first;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        tests = new ArrayList<>();
        long total = 0;
        for(int i = 0 ; i < n; i++){
            tests.add(new Test(nextInt(), nextInt(), nextInt()));
            total += tests.get(i).points;
        }
        Collections.sort(tests);
        int wrong = nextInt();
        for(int i = 0; i < wrong; i++){
            int wrongCase = nextInt();
            boolean end = false;
            for(int o = 0; o < tests.size() && !end; o++){
                if(tests.get(o).first > wrongCase){
                    end = true;
                }
                else{
                    if(tests.get(o).last >= wrongCase){
                        total -= tests.get(o).points;
                        tests.remove(o);
                        o--;
                    }

                }
            }
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
