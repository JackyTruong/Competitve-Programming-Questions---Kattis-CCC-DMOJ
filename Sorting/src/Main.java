import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    static class Pair{
        int begin, end;
        public Pair(int begin, int end){
            this.begin = begin;
            this.end = end;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        int[] wildCard = new int[2];
        wildCard[1] = 1000001;
        int[] arr = new int[n];
        boolean nope = false;
        arr[0] = nextInt();
        ArrayList<Pair> temp = new ArrayList<>();
        for(int i = 1; i < n; i++){
            arr[i] = nextInt();
            //System.out.println(arr[i] + " " + arr[i-1]);
            if(arr[i] < arr[i-1] && arr[i] != 0 && arr[i-1] != 0){
                //System.out.println("here");
                nope = true;
            }
        }
        if(n > 1){
            for(int i = 0 ; i < n; i++){
                if(arr[i] == 0){
                    if(i-1 < 0){
                        temp.add(new Pair(0, arr[i+1]));
                    }
                    else if(i+1 >= n){
                        temp.add(new Pair(arr[i-1], 1000001));
                    }
                    else{
                        temp.add(new Pair(arr[i-1], arr[i+1]));
                    }
                }
            }
            for(int i = 0 ; i < temp.size() && !nope; i++){
                if(temp.get(i).begin == 0 && temp.get(i).end == 0){
                    temp.remove(i);
                }
                if(temp.get(i).end == 0){
                    temp.get(i).end = 1000001;
                }
                if((temp.get(i).begin < wildCard[0] && temp.get(i).end < wildCard[0]) || (temp.get(i).begin > wildCard[1] && temp.get(i).end > wildCard[1])){
                    nope = true;
                }
                else{
                    if(temp.get(i).begin > wildCard[0]){
                        wildCard[0] = temp.get(i).begin;
                    }
                    if(temp.get(i).end < wildCard[1]){
                        wildCard[1] = temp.get(i).end;
                    }
                }
                //System.out.println(temp.get(i).begin + " " + temp.get(i).end);
            }
        }


        //System.out.println(wildCard[0] + " " + wildCard[1]);
        if(!nope){
            out.println("YES");
        }
        else{
            out.println("NO");
        }


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st =new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
