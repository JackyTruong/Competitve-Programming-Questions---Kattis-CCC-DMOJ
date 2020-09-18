import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static ArrayList<Pair> saved;

    static class Pair{
        String word;
        int spot;
        public Pair(String word, int spot){
            this.word = word;
            this.spot = spot;
        }
    }

    private static int beenSaved(String word){
        for(int i = 0 ; i < saved.size();i++){
            if(word.equals(saved.get(i).word)){
                return saved.get(i).spot;
            }
        }
        return -1;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = nextInt();
        int count = 0;
        int num = 1;

        while(count <= t){
            String one = br.readLine();
            if(one.equals("") || count == 0){
                num = 1;
                saved = new ArrayList<>();
                count++;
            }
            StringTokenizer oneST = new StringTokenizer(one, " ");
            while(oneST.hasMoreTokens()){
                String tempTok = oneST.nextToken();
                int temp =beenSaved(tempTok);
                if(temp != -1){
                    System.out.print(temp + " ");
                }
                else{
                    System.out.print(tempTok + " ");
                    saved.add(new Pair(tempTok, num));
                    num++;
                }
            }
            System.out.println("");
        }

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
