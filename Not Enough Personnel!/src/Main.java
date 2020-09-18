
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int vets, newbies, spot, diff;
    static Veteran[] people;

    static class Veteran{
        String name;
        int skill;
        public Veteran(String name, int skill){
            this.name=  name;
            this.skill = skill;
        }
    }

    private static void findSuit(int s, int d){
        for(int i = 0 ; i < vets; i++){
            if(people[i].skill >= s && people[i].skill <= s+d && Math.abs(people[i].skill - s) < diff){
                spot = i;
                diff = Math.abs(people[i].skill - s);
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out=  new PrintWriter(new OutputStreamWriter(System.out));
        vets =nextInt();
        people = new Veteran[vets];
        for(int i = 0 ; i < vets; i++){
            people[i] = new Veteran(next(), nextInt());
        }
        newbies = nextInt();
        for(int i = 0 ; i < newbies; i++){
            diff = Integer.MAX_VALUE;
            spot = Integer.MAX_VALUE;
            int s = nextInt(), d = nextInt();
            findSuit(s, d);
            if(spot != Integer.MAX_VALUE){
                out.println(people[spot].name);
            }
            else{
                out.println("No suitable teacher!");
            }

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
