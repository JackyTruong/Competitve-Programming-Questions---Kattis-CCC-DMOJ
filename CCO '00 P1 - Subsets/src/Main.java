import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static PrintWriter out;
    static BufferedReader br;
    static ArrayList<Container> subs;
    static ArrayList<Pair> otherCons;
    static boolean change;

    static class Container implements Comparable<Container>{
        String letter;
        ArrayList<String> contains;
        boolean[] letters = new boolean[26];
        public Container(String letter){
            this.letter = letter;
            contains = new ArrayList<>();
        }
        public void addContains(String letter){
            this.contains.add(letter);
        }
        public int compareTo(Container other){
            return this.letter.charAt(0)-other.letter.charAt(0);
        }
    }

    static class Pair{
        String first, second;
        public Pair(String first, String second){
            this.first = first;
            this.second= second;
        }
    }

    private static boolean isLowercase(String temp){
        if(temp.charAt(0) < 96){
            return false;
        }
        return true;
    }

    private static void addTo(String first, String addThis){
        int temp = findSpot(first);
        //System.out.println(temp + " " + addThis);
        if(!subs.get(temp).letters[addThis.charAt(0)-97]){
            subs.get(temp).addContains(addThis);
            subs.get(temp).letters[addThis.charAt(0)-97] = true;
        }
    }

    private static int findSpot(String looking){
        for(int i = 0 ; i < subs.size(); i++){
            if(subs.get(i).letter.equals(looking)){
                return i;
            }
        }
        return -1;
    }

    //TODO MAKE IT SO THAT IF THEY ALREADY HAVE SUCH A LETTER DO NOT ADD IT FOR WHEN U DO THE A CONTAINS B SUBSETS

    private static void addOtherCons(String first, String second){
        int temp = findSpot(second);
        int firstTemp = findSpot(first);
        for(int i = 0 ; i < subs.get(temp).contains.size();i++){
            if(!subs.get(firstTemp).letters[subs.get(temp).contains.get(i).charAt(0)-97]){
                subs.get(firstTemp).letters[subs.get(temp).contains.get(i).charAt(0)-97] = true;
                subs.get(firstTemp).contains.add(subs.get(temp).contains.get(i));
                change = true;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(next());
        subs = new ArrayList<>();
        otherCons = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            String first = next();
            String con = next();
            String second = next();
            if(findSpot(first) == -1){
                subs.add(new Container(first));
            }
            if(isLowercase(second)){
                addTo(first, second);
            }
            else{
                if(findSpot(second) == -1){
                    subs.add(new Container(second));
                }
                otherCons.add(new Pair(first, second));
            }
        }
        change = true;
        while(change){
            change = false;
            for(int i = 0 ; i < otherCons.size(); i++){
                addOtherCons(otherCons.get(i).first, otherCons.get(i).second);
            }
        }
        Collections.sort(subs);
        for(int i = 0 ;i < subs.size(); i++){
            Collections.sort(subs.get(i).contains);
            out.print(subs.get(i).letter + " = {");
            for(int o = 0; o < subs.get(i).contains.size()-1; o++){
                out.print(subs.get(i).contains.get(o) + ",");
            }
            if(subs.get(i).contains.size() >= 1){
                out.println(subs.get(i).contains.get(subs.get(i).contains.size()-1) + "}");
            }
            else{
                out.println("}");
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

}
