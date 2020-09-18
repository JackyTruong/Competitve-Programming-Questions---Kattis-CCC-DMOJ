import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static class Pair implements Comparable<Pair>{
        int number, found;
        public Pair(int number){
            this.number = number;
            this.found = 1;
        }
        public void addNum(){
            this.found++;
        }
        public int compareTo(Pair a){
            return this.found - a.found;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pair> first = new ArrayList<>();
        ArrayList<Pair> second = new ArrayList<>();
        for(int i = 0 ; i < 3; i++){
            int numF = sc.nextInt();
            int numS = sc.nextInt();
            boolean foundF = false;
            boolean foundS = false;
            for(int o = 0; o < first.size() && !foundF; o++){
                if(first.get(o).number == numF){
                    first.get(o).addNum();
                    foundF = true;
                }
            }
            if(!foundF){
                first.add(new Pair(numF));
            }
            for(int o = 0; o < second.size() && !foundS; o++){
                if(second.get(o).number == numS){
                    second.get(o).addNum();
                    foundS = true;
                }
            }
            if(!foundS){
                second.add(new Pair(numS));
            }
        }
        Collections.sort(first);
        Collections.sort(second);
        System.out.println(first.get(0).number + " " + second.get(0).number);
    }
}
