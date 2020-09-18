import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static ArrayList<Person> people;
    static int lowest;
    static class Person{
        int num;
        ArrayList<Integer> friends;
        public Person(int num, int friend){
            this.num = num;
            this.friends = new ArrayList<>();
            this.friends.add(friend);
        }
    }

    private static int numFriends(int num){
        for(int i = 0 ; i < people.size(); i++){
            if(people.get(i).num == num){
                return people.get(i).friends.size();
            }
        }
        return 0;
    }

    private static int indexOf(int num){
        for(int i = 0 ; i < people.size();i++){
            if(people.get(i).num ==  num){
                return i;
            }
        }
        return 0;
    }

    private static int numFriendsOfFriends(int num){
        //System.out.println("this num" + num);
        ArrayList<Integer> ff = new ArrayList<>();
        int spot = indexOf(num);
        for(int i = 0 ; i < people.get(spot).friends.size(); i++){
            int friendSpot = indexOf(people.get(spot).friends.get(i));
            for(int o = 0 ; o < people.get(friendSpot).friends.size(); o++){
                if(!ff.contains(people.get(friendSpot).friends.get(o)) && !people.get(spot).friends.contains(people.get(friendSpot).friends.get(o))){
                    ff.add(people.get(friendSpot).friends.get(o));
                }
            }
        }
        return ff.size()-1;
    }

    private static int getTo(int first, int second, int count, boolean[] beenTo){
        beenTo[first] = true;
        if(first == second){
            return count;
        }
        int spot = indexOf(first);
        /*
        System.out.println("these are the directions ");
        for(int i = 0 ; i < people.get(spot).friends.size(); i++){
            System.out.println(people.get(spot).friends.get(i) + "tese");
        }

         */
        boolean[] tempBeen = beenTo.clone();
        for(int i = 0 ; i < people.get(spot).friends.size(); i++){
            if(!tempBeen[people.get(spot).friends.get(i)]){
                int temp = getTo(people.get(spot).friends.get(i), second, count+1, tempBeen);
                if(temp < lowest){
                    lowest = temp;
                }
            }
        }
        return lowest;
    }

    private static void addFriend(int first, int second){
        boolean firstE = false;
        boolean secondE = false;
        for(int i = 0 ; i < people.size(); i++){
            if(people.get(i).num == first){
                people.get(i).friends.add(second);
                firstE = true;
            }
            if(people.get(i).num == second){
                people.get(i).friends.add(first);
                secondE = true;
            }
        }
        if(!firstE){
            people.add(new Person(first, second));
        }
        if(!secondE){
            people.add(new Person(second, first));
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        people = new ArrayList<>();
        addFriend(2,6);
        addFriend(1,6);
        addFriend(7,6);
        addFriend(5,6);
        addFriend(4,6);
        addFriend(4,5);
        addFriend(3,6);
        addFriend(3,5);
        addFriend(3,4);
        addFriend(3,15);
        addFriend(15,13);
        addFriend(13,12);
        addFriend(13,14);
        addFriend(12,11);
        addFriend(11,10);
        addFriend(12,9);
        addFriend(9,10);
        addFriend(9,8);
        addFriend(8,7);
        addFriend(18,16);
        addFriend(17,16);
        addFriend(18,17);
        String instruct = next();
        while(!instruct.equals("q")){
            if(instruct.equals("i")){
                int first = nextInt();
                int second = nextInt();
                addFriend(first, second);
            }
            else if(instruct.equals("d")){
                int first = nextInt();
                int second = nextInt();
                for(int i = 0 ; i < people.size(); i++){
                    if(people.get(i).num == first){
                        if(people.get(i).friends.contains(second)){
                            people.get(i).friends.remove(people.get(i).friends.indexOf(second));
                        }
                    }
                    if(people.get(i).num == second){
                        if(people.get(i).friends.contains(first)){
                            people.get(i).friends.remove(people.get(i).friends.indexOf(first));
                        }
                    }
                }
            }
            else if(instruct.equals("n")){
                int first = nextInt();
                out.println(numFriends(first));
            }
            else if(instruct.equals("f")){
                int first = nextInt();
                int ff = numFriendsOfFriends(first);
                out.println(ff);
            }
            else if(instruct.equals("s")){
                int first = nextInt();
                int second = nextInt();
                lowest = Integer.MAX_VALUE;
                boolean[] beenTo = new boolean[51];
                Arrays.fill(beenTo, false);
                getTo(first, second, 0, beenTo);
                if(lowest != Integer.MAX_VALUE){
                    out.println(lowest);
                }
                else{
                    out.println("Not connected");
                }

            }

            instruct = next();
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
