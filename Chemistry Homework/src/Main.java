import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    static class Bonds{
        int atom;
        ArrayList<Integer> connected;
        public Bonds(int atom){
            this.atom = atom;
            this.connected = new ArrayList<>();
        }

        public void addCon(int con){
            this.connected.add(con);
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        Bonds[] cons = new Bonds[n];
        for(int i = 0 ; i < n; i++){
            cons[i] = new Bonds(i);
        }
        int m = nextInt();
        for(int i = 0 ; i < m ;i++){
            int f = nextInt()-1;
            int s = nextInt()-1;
            cons[f].addCon(s);
            cons[s].addCon(f);
        }
        int[] type = new int[n];
        boolean possible = true;
        for(int i = 0 ;  i < n && possible; i++){
            if(cons[i].connected.size() == 4){
                type[i] = 1;
            }
            else if(cons[i].connected.size() == 1){
                type[i] = 0;
            }
            else{
                possible = false;
            }
        }
        int energy = 0;
        int numC = 0;
        int numH = 0;
        int doubles = 0;
        int singles = 0;
        for(int i = 0 ; i < n && possible; i++){
            if(type[i] == 1){
                numC++;
            }
            else{
                numH++;
            }
            ArrayList<Integer> done = new ArrayList<>();
            for(int o = 0 ; o < cons[i].connected.size();o++){
                if(type[i] == 1 && type[cons[i].connected.get(o)] == 0){
                    int temp = cons[i].connected.get(o);
                    int count = 0;
                    for(int a = 0; a < cons[i].connected.size();a++){
                        if(cons[i].connected.get(a) == temp){
                            count++;
                        }
                    }
                    if(count == 1){
                        energy += 413;

                    }
                    else{
                        possible = false;
                    }
                }
                else if(type[i] == 1 && type[cons[i].connected.get(o)] == 1){
                    int temp = cons[i].connected.get(o);
                    if(!done.contains(temp)){
                        int count = 0;
                        for(int a = 0; a < cons[i].connected.size();a++){
                            if(cons[i].connected.get(a) == temp){
                                count++;
                            }
                        }
                        if(count == 2){
                            energy+=615;
                            doubles++;
                        }
                        else if(count == 1){
                            energy += 346;
                            singles++;
                        }
                        else{
                            possible = false;
                        }
                        done.add(temp);
                    }
                }
            }
        }
        energy -= (doubles/2)*615;
        energy -= (singles/2)*346;
        /*
        for(int i = 0 ; i < n; i++){
            System.out.println(i + "this");
            for(int o = 0 ; o < cons[i].connected.size();o++){
                System.out.print(cons[i].connected.get(o) + " ");
            }
            System.out.println();
        }

         */
        if(!possible){
            out.println("Impossible");
        }
        else{
            out.println(energy);
            if(numC > 1){
                out.print("C"+numC);
            }
            else{
                out.print("C");
            }
            if(numH > 1){
                out.print("H"+numH);
            }
            else{
                out.print("H");
            }
        }


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st=  new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
