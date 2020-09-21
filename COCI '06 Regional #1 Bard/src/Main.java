import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    static class Villager{
        boolean[] songs;
        public Villager(){
            songs = new boolean[51];
        }
        public void addSong(int song){
            songs[song] = true;
        }
    }

    private static boolean[] combine(boolean[] first, boolean[] second){
        boolean[] output = new boolean[51];
        for(int i = 1; i < 51; i++){
            if(first[i] || second[i]){
                output[i] = true;
            }
        }
        return output;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int v = nextInt();
        int e = nextInt();
        Villager[] villagers = new Villager[v+1];
        for(int i = 1; i <= v; i++){
            villagers[i] =  new Villager();
        }
        int song = 1;
        for(int i = 0 ; i < e; i++){
            int present = nextInt();
            int[] temp = new int[present];
            boolean hasOne = false;
            for(int o = 0 ; o < present; o++){
                temp[o] = nextInt();
                if(temp[o] == 1){
                    hasOne = true;
                }
            }
            if(hasOne){
                for(int o = 0; o < present; o++){
                    //System.out.println("this is person " + temp[o] + " " + song);
                    villagers[temp[o]].songs[song] = true;
                }
                //System.out.println();
                song++;
            }
            else {
                boolean[] songsKnown = villagers[temp[0]].songs;
                for (int o = 1; o < present; o++) {
                    songsKnown = combine(songsKnown, villagers[temp[o]].songs);
                }

                for (int o = 0; o < present; o++) {
                    villagers[temp[o]].songs = combine(villagers[temp[o]].songs, songsKnown);
                    /*
                    for(int a = 1 ; a < 51; a++){
                        System.out.println(temp[o] + " " + a + " " + villagers[temp[o]].songs[a]);
                    }

                     */
                }
            }

        }

        for(int i = 1; i <= v; i++){
            boolean hasAll = true;
            for(int o = 1; o < song; o++){
                //System.out.println(i + " " + o + " " + villagers[i].songs[o]);
                if(!villagers[i].songs[o]){
                    hasAll = false;
                    break;
                }
            }
            if(hasAll){
                out.println(i);
            }
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
