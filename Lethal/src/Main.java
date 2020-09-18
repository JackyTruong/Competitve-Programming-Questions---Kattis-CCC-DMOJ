import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int mins, hp, tank;
    static int[] attack;
    static boolean lethal;

    private static void findLethal(boolean[] used, int tank, int hp){
        if(tank > 0){
            for(int i = 0 ; i < mins; i++){
                if(!used[i]){
                    boolean temp[] = used.clone();
                    temp[i] = true;
                    int tempT = tank;
                    tempT -= attack[i];
                    findLethal(temp, tempT, hp);
                }

            }

        }
        else{
            for(int i = 0 ; i < mins; i++){
                if(!used[i]){
                    hp -= attack[i];
                }
            }
            if(hp <= 0){
                lethal = true;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        for(int z = 0 ; z < n ;z++){
            lethal = false;
            mins = nextInt();
            attack = new int[mins];
            for(int i = 0 ; i < mins; i++){
                attack[i] = nextInt();
            }
            Arrays.sort(attack);
            int hp = nextInt();
            int tank = nextInt();
            findLethal(new boolean[mins], tank, hp);
            if(lethal){
                System.out.println("LETHAL");
            }
            else{
                System.out.println("NOT LETHAL");
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
