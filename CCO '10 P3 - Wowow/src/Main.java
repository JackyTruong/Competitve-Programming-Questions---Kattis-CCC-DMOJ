import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int n;
    static int[] arr;
    static ArrayList<Pair> players;

    static class Pair implements Comparable<Pair>{
        int person, rating;
        public Pair(int person, int rating){
            this.person = person;
            this.rating = rating;
        }
        public int compareTo(Pair other){
            return this.rating-other.rating;
        }
        public void changeRating(int rating){
            this.rating = rating;
        }
    }

    private static int BinarySearch(int rating, int l, int r){
        if(r >= l){
            int mid = l + (r-l)/2;
            //System.out.println(mid + " thjismid " + players.get(mid).rating + " "  + rating);
            if(players.get(mid).rating == rating){
                return mid;
            }
            if(players.get(mid).rating > rating){
                return BinarySearch(rating, l, mid-1);
            }
            return BinarySearch(rating,mid+1, r);
        }
        return -1;
    }

    private static int findSpotAdd(int rating, int l, int r){
        if(r >= l){
            int mid = l+(r-l)/2;
            if((players.get(mid).rating < rating && (mid == players.size()-1 || players.get(mid+1).rating > rating))){
                return mid+1;
            }
            if(players.get(mid).rating > rating && mid == 0){

                return mid;
            }

            if(players.get(mid).rating > rating){
                return findSpotAdd(rating, l, mid-1);
            }
            if(players.get(mid).rating < rating){
                return findSpotAdd(rating, mid+1, r);
            }
        }
        return 0;
    }

    //TODO REMEMBER THEIR RATINGS IF THERE IS A CHANGE U CAN LOOK FOR THEIR RATING WITHIN THE PLAYERS ARRAYLIST USING BINARY SEARCH BASED ON RATING THEN SWAP IT

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        arr = new int[1000001];
        players = new ArrayList<>();
        n = nextInt();
        for(int i = 0 ; i < n; i++){
            char letter = next().charAt(0);
            if(letter == 'N'){
                int spot = nextInt();
                int rating = nextInt();
                arr[spot] = rating;
                //System.out.println(findSpotAdd(rating, 0, players.size()-1));
                players.add(findSpotAdd(rating, 0, players.size()-1),new Pair(spot, rating));
            }
            else if(letter == 'M'){
                /*

                 */

                int spot = nextInt();
                int rating = nextInt();
                int prev = arr[spot];
                arr[spot] = rating;
                //System.out.println(prev);

                int temp = BinarySearch(prev, 0, players.size()-1);
                players.remove(temp);
                players.add(findSpotAdd(rating, 0, players.size()-1), new Pair(spot, rating));
            }
            else{
                int num = nextInt();
                out.println(players.get(players.size()-num).person);
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
