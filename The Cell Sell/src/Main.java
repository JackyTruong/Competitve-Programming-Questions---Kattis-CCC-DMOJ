import java.util.Scanner;

public class Main {

    private static double planB (int daytime, int evening, int weekend){
        double cost = 0;
        daytime-= 250;
        if(daytime > 0){
            cost+= daytime * 0.45;
        }
        cost += 0.35*evening;
        cost += 0.25*weekend;
        return cost;
    }

    private static double planA (int daytime, int evening, int weekend){
        double cost = 0;
        daytime-=100;
        if(daytime > 0){
            cost += 0.25*daytime;
        }
        cost += evening*0.15;
        cost += weekend*0.20;
        return cost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int daytime = sc.nextInt(), evening = sc.nextInt(), weekend = sc.nextInt();
        //System.out.println(daytime + " " + evening + " " + weekend);
        double planA = planA(daytime, evening, weekend);
        double planB = planB(daytime, evening, weekend);
        double temp = Math.round(planA*100);
        double temp1 = Math.round(planB*100);
        planA = temp/100;
        planB = temp1/100;
        System.out.println("Plan A costs " + planA);
        System.out.println("Plan B costs " + planB);
        if(planA < planB){
            System.out.println("Plan A is cheapest.");
        }
        else if (planA > planB){
            System.out.println("Plan B is cheapest.");
        }
        else{
            System.out.println("Plan A and B are the same price.");
        }
    }
}
