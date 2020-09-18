import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    static class comp implements Comparable<comp>{
        String name; int num;

        public comp(String name, int num){
            this.name = name;
            this.num = num;
        }

        public int compareTo(comp other){
            return  other.num -this.num;
        }

    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        ArrayList<comp> computers = new ArrayList<>();
        int n = nextInt();
        for(int i = 0 ; i < n; i++){
            String name = next();
            int r = nextInt();
            int c = nextInt();
            int d = nextInt();
            computers.add(new comp(name, (2*r)+(3*c)+d));
        }
        if(n > 1){
            Collections.sort(computers);
            int highest = computers.get(0).num;
            ArrayList<String> names = new ArrayList<>();
            for(int i = 0 ; i < computers.size(); i++){
                if(highest == computers.get(i).num){
                    names.add(computers.get(i).name);
                }
                else{
                    break;
                }
            }
            Collections.sort(names);
            if(names.size() > 1){
                System.out.println(names.get(0));
                System.out.println(names.get(1));
            }
            else{
                System.out.println(computers.get(0).name);
                System.out.println(computers.get(1).name);
            }

        }
        else if(n > 0){
            System.out.println(computers.get(0).name);
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
