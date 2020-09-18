
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static Friend[] friends;
    static int count, n;
    static boolean[] beenTo;

    static class Friend{
        int src, dest;

        public Friend(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    private static int connected(int src, int dest){
        beenTo[src] = true;
        if(src == dest){
            return count;
        }
        int spot = 0;
        for(int i = 1 ; i < friends.length; i++){
            if(friends[i].src == src){
                spot = i;
                break;
            }
        }
        if(!beenTo[friends[spot].dest]){
            count++;
            connected(friends[spot].dest, dest);
        }
        else{
            count =  -1;
        }
        return count;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        friends = new Friend[n];
        for(int i  = 0 ; i < n; i++){
            int src = nextInt();
            int dest = nextInt();
            friends[i] = new Friend(src, dest);
        }
        int first = nextInt(), second = nextInt();
        while(first != 0 && second != 0){
            beenTo = new boolean[10000];
            Arrays.fill(beenTo, false);
            count = 0;
            count = connected(first, second);
            if(count != -1){
                out.println("Yes " + (count-1));
            }
            else{
                out.println("No");
            }
            first = nextInt();
            second = nextInt();
        }


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
