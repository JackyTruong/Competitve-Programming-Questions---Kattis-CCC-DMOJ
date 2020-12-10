import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static Map<String, Integer> hashMap;
    static ArrayList<Place> flights;
    static int min;

    private static int findCode(String name){
        if(!hashMap.containsKey(name)){
            hashMap.put(name, hashMap.size());
        }
        return hashMap.get(name);
    }

    static class Place{
        ArrayList<Cost> travel;
        public Place(){
            travel = new ArrayList<>();
        }
    }

    static class Cost{
        String place;
        int cost;
        public Cost(String place, int cost){
            this.place=  place;
            this.cost = cost;
        }
    }

    private static void findEnd(String name, int count, ArrayList<String> beenTo){
        if(count < min){
            if(name.equals("SEA")){
                min = count;
            }
            else{
                beenTo.add(name);
                int spot = findCode(name);
                for(int i = 0 ; i < flights.get(spot).travel.size(); i++){
                    if(!beenTo.contains(flights.get(spot).travel.get(i).place)){
                        findEnd(flights.get(spot).travel.get(i).place, count + flights.get(spot).travel.get(i).cost, beenTo);
                    }

                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int z= 0 ; z < 5; z++){
            min = 999999999;
            hashMap = new HashMap<>();
            flights = new ArrayList<>();
            int n = nextInt();
            for(int i = 0 ; i < n; i++){
                int from = findCode(next());
                String temp = next();
                int to = findCode(temp);
                while(to >= flights.size()){
                    flights.add(new Place());
                }
                flights.get(from).travel.add(new Cost(temp, nextInt()));
            }
            findEnd("YYZ", 0, new ArrayList<>());
            out.println(min);


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
