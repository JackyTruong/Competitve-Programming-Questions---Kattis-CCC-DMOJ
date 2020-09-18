import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static ArrayList<ribbonLength> blues;

    static class ribbonLength{
        int begin, end;
        public ribbonLength(int begin, int end){
            this.begin = begin;
            this.end = end;
        }
        public void changeBegin(int begin){
            this.begin = begin;
        }
        public void changeEnd(int end){
            this.end = end;
        }
    }

    private static void deleteSame(int begin, int end, int spot){
        for(int i = 0 ; i < blues.size(); i++){
            if(i != spot){
                if(blues.get(i).begin == begin &&  blues.get(i).end == end){
                    blues.remove(i);
                    i--;
                    spot--;
                }
                else if(blues.get(i).begin >= begin && blues.get(i).end <= end){
                    blues.remove(i);
                    i--;
                    spot--;
                }
            }
        }

    }

    private static void overlap(int begin, int end){
        for(int i = 0 ; i < blues.size(); i++){
            if(blues.get(i).begin <= begin && blues.get(i).end > begin && blues.get(i).end < end){
                blues.get(i).changeEnd(end);
                deleteSame(blues.get(i).begin, blues.get(i).end, i);
                overlap(blues.get(i).begin, blues.get(i).end);
                return;
            }
            else if(blues.get(i).begin > begin && blues.get(i).end < end){
                blues.add(new ribbonLength(begin, end));
                blues.remove(i);
                deleteSame(blues.get(i).begin, blues.get(i).end, i);
                overlap(blues.get(blues.size()-1).begin, blues.get(blues.size()-1).end);
                return;
            }
            else if(blues.get(i).begin > begin && blues.get(i).end >= end && blues.get(i).begin < end){
                blues.get(i).changeBegin(begin);
                deleteSame(blues.get(i).begin, blues.get(i).end, i);
                overlap(blues.get(i).begin, blues.get(i).end);
                return;
            }
            else if(blues.get(i).begin <= begin && blues.get(i).end >= end){
                return;
            }
        }
        blues.add(new ribbonLength(begin, end));
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt(), q  = nextInt();
        blues = new ArrayList<>();
        for(int i = 0 ; i < q; i++){
            overlap(nextInt(), nextInt());
        }
        int blue = 0;
        for(int i = 0 ; i < blues.size();i++){
            blue += blues.get(i).end - blues.get(i).begin;
            System.out.println(blues.get(i).begin + " " + blues.get(i).end);
        }
        out.println((n-blue) + " " + blue);



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
