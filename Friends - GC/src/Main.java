import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static Map<String, Integer> hashmap;
    static ArrayList<ArrayList<Integer>> connections;
    static boolean[] beenTo;
    static int count;

    private static int findFriend(String name){
        if(!hashmap.containsKey(name)){
            hashmap.put(name, hashmap.size());
        }
        return hashmap.get(name);
    }

    private static boolean isFriends(String first, String second){
        char[] firstA = new char[26];
        char[] secondA = new char[26];
        int shortest = Math.min(first.length(), second.length());
        for(int i = 0 ; i < shortest; i++){
            firstA[first.charAt(i)-65]++;
            secondA[second.charAt(i)-65]++;
        }
        for(int i = 0 ; i < 26; i++){
            if(firstA[i] > 0 && secondA[i] > 0){
                return true;
            }
        }
        return false;
    }

    private static void findConnection(int spot, int b, int move){
        if(spot == b && move < count){
            count = move;
        }
        if(move < count){
            beenTo[spot] = true;
            int size = connections.get(spot).size();
            for(int i = 0 ; i < size; i++){
                if(!beenTo[connections.get(spot).get(i)]){
                    findConnection(connections.get(spot).get(i), b, move + 1);
                }

            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = nextInt();
        for(int z = 0 ;z  < t; z++){
            hashmap = new HashMap<>();
            connections = new ArrayList<>();
            int names = nextInt();
            int q = nextInt();
            String[] people = new String[names];
            for(int i = 0 ; i < names; i++){
                people[i] = next();
                findFriend(people[i]);
                connections.add(new ArrayList<>());
            }

            for(int i = 0 ; i < names; i++){
                for(int o = 0; o < names; o++){

                    if(i != o){
                        if(isFriends(people[i], people[o])){
                            int personA = findFriend(people[i]);
                            int personB = findFriend(people[o]);
                            connections.get(personA).add(personB);
                            connections.get(personB).add(personA);
                        }
                    }
                }
            }

            out.print("Case #" + (z+1) + ": ");
            for(int i = 0 ; i < q; i++){
                count = 999999999;
                int a = nextInt()-1;
                int b = nextInt()-1;
                beenTo = new boolean[names];
                findConnection(a, b, 0);
                if(count == 999999999){
                    out.print(-1 + " ");
                }
                else{
                    if(count == 1){
                        count++;
                    }
                    out.print(count + " ");
                }

            }
            out.println();
        }

        out.close();
    }

    private static String next()throws IOException {
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
