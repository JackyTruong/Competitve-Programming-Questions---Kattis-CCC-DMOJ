import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        int k = nextInt();
        ArrayList<ArrayList<String>> coachFav = new ArrayList<>();
        ArrayList<ArrayList<String>> playersGotten = new ArrayList<>();
        ArrayList<String> players = new ArrayList<>();
        ArrayList<String> removed;
        boolean picked;
        for(int i = 0; i < n; i++){
            playersGotten.add(new ArrayList<>());
            int o = nextInt();
            ArrayList<String> temp = new ArrayList<>();
            for(int a = 0; a < o; a++){
                temp.add(next());
            }
            coachFav.add(temp);
        }
        int numNames = nextInt();
        for(int i = 0; i < numNames; i++){
            players.add(next());
        }
        for(int i = 0; i < k; i++){
            removed = new ArrayList<>();
            for(int o = 0; o < n; o++){
                picked = false;
                for(int b = 0; b < removed.size();b++){
                    coachFav.get(o).remove(removed.get(b));
                }
                for(int a = 0; a < coachFav.get(o).size() && !picked;a++){
                    if(players.contains(coachFav.get(o).get(a))){
                        removed.add(coachFav.get(o).get(a));
                        playersGotten.get(o).add(coachFav.get(o).get(a));
                        players.remove(coachFav.get(o).get(a));
                        a--;
                        picked = true;
                    }
                }
                if(!picked){
                    removed.add(players.get(0));
                    playersGotten.get(o).add(players.get(0));
                    players.remove(0);
                }
            }
        }
        for(int i = 0; i < n;i++){
            for(int o = 0; o < k; o++){
                out.print(playersGotten.get(i).get(o) + " ");
            }
            out.println();
        }

        out.close();
    }
    static String next() throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}