import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static class Pair{
        double key;
        double value;
        public Pair(double key, double value){
            this.key = key;
            this.value = value;
        }
        public double getKey(){
            return this.key;
        }
        public double getValue(){
            return this.value;
        }
    }

    private static ArrayList<Pair> closestSheep(Pair[] location, Pair wolf, ArrayList<Pair> caught){
        double shortest = 9999999;
        int spot = -1;
        for(int i = 0 ; i < location.length;i++){
            double dist = Math.sqrt(((location[i].getKey()-wolf.getKey())*(location[i].getKey()-wolf.getKey()))+((location[i].getValue()-wolf.getValue())*(location[i].getValue()-wolf.getValue())));
            if(dist < shortest){
                shortest = dist;
                spot = i;
            }
        }
        if(!caught.contains(location[spot])){
            caught.add(location[spot]);
        }
        return caught;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] location = new Pair[n];
        for(int i = 0; i < n; i++){
            location[i] = new Pair(sc.nextDouble(), sc.nextDouble());
        }
        ArrayList<Pair> caught = new ArrayList<>();
        for(double i = 0; i <= 1001; i+=0.01){
            caught = closestSheep(location, new Pair(i,0.0), caught);
        }

        for(int i = 0; i < caught.size();i++){
            System.out.print("The sheep at (");
            System.out.printf("%.2f", caught.get(i).getKey());
            System.out.print(", ");
            System.out.printf("%.2f", caught.get(i).getValue());
            System.out.println(") might be eaten.");
        }

    }
}
