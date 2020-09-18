import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static PrintWriter out;
    static BufferedReader br;
    static int n, k, q, a,b,x,y;
    static int[]pre,seq;
    static ArrayList<Spot> places;

    static class Spot implements Comparable<Spot>{
        int num;
        ArrayList<Integer> spots;
        public Spot(int num, int spot){
            this.num = num;
            this.spots = new ArrayList<>();
            this.spots.add(spot);
        }

        public void addSpot(int spot){
            this.spots.add(spot);
        }
        public int compareTo(Spot other){
            return this.num - other.num;
        }
    }

    private static boolean isGreat(){
        int temp = pre[y]-pre[x]+seq[x];
        //System.out.println(temp + " " + containsF + " " + containsS);
        if(temp > k && includesAB()){
            return true;
        }
        return false;
    }

    private static int find(int num){
        int l = 0, r = places.size()-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(places.get(mid).num == num){
                return mid;
            }
            if(places.get(mid).num < num){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return -1;
    }

    private static boolean includesAB(){
        boolean hasA = false;
        boolean hasB = false;
        int aSpot = find(a);
        int bSpot = find(b);
        if(aSpot != -1){
            int l = 0, r = places.get(aSpot).spots.size()-1;
            while(l <= r && !hasA){
                int mid = l + (r-l)/2;
                if(places.get(aSpot).spots.get(mid) > y){
                    r = mid - 1;
                }
                else if(places.get(aSpot).spots.get(mid) < x){
                    l = mid + 1;
                }
                else{
                    hasA = true;
                }
            }
        }
        if(bSpot != -1){
            int l = 0, r = places.get(bSpot).spots.size()-1;
            while(l <= r && !hasB){
                int mid = l + (r-l)/2;
                if(places.get(bSpot).spots.get(mid) > y){
                    r = mid - 1;
                }
                else if(places.get(bSpot).spots.get(mid) < x){
                    l = mid + 1;
                }
                else{
                    hasB = true;
                }
            }
        }
        //System.out.println(hasA + " " + hasB);
        return (hasA && hasB);
    }

    private static void add(int num, int spot){
        for(int i = 0 ; i < places.size(); i++){
            if(places.get(i).num == num){
                places.get(i).addSpot(spot);
                return;
            }
        }
        places.add(new Spot(num, spot));
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt(); k = nextInt(); q = nextInt();
        places = new ArrayList<>();
        seq = new int[n];
        pre = new int[n];
        seq[0] = nextInt();
        pre[0] = seq[0];
        add(seq[0], 0);
        for(int i = 1 ; i < n; i++){
            seq[i] = nextInt();
            add(seq[i], i);
            pre[i] = pre[i-1] + seq[i];
        }
        Collections.sort(places);
        /*
        for(int i = 0 ; i < places.size(); i++){
            System.out.print(places.get(i).num + " ");
        }


        System.out.println();

         */
        for(int i = 0 ; i < q; i++){
            a = nextInt(); b = nextInt(); x = nextInt()-1; y = nextInt()-1;
            if(isGreat()){
                out.println("Yes");
            }
            else{
                out.println("No");
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
