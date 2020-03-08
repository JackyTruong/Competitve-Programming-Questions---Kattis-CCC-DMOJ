
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int combineTwo(ArrayList<Integer> riceballs){
        int removed = 0;
        for(int i = 0 ; i < riceballs.size()-1;i++){
            if(riceballs.get(i).equals(riceballs.get(i+1))){
                riceballs.set(i, riceballs.get(i)*2);
                riceballs.remove(i+1);
                removed++;
            }
        }
        //System.out.println(removed);
        return removed;
    }

    public static int combineThree(ArrayList<Integer> riceballs){
        int removed = 0;
        for(int i = 0 ; i < riceballs.size()-2;i++){
            if(riceballs.get(i).equals(riceballs.get(i+2))){
                //System.out.println((riceballs.get(i)*2)+riceballs.get(i+1));
                riceballs.set(i, (riceballs.get(i)*2)+riceballs.get(i+1));
                riceballs.remove(i+2);
                riceballs.remove(i+1);
                removed += 2;
            }
        }
        //System.out.println(removed);
        return removed;
    }

    public static void biggestRiceball(ArrayList<Integer> riceballs){
        int largest = 0;
        for(int i = 0; i < riceballs.size();i++){
            if(largest < riceballs.get(i)){
                largest = riceballs.get(i);
            }
        }
        System.out.println(largest);
    }

    public static void main(String[] args)throws Exception {
        File file = new File("s4.31.in");
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
        ArrayList<Integer> riceballs = new ArrayList<>();
	    for(int i = 0; i < n; i++){
	        riceballs.add(sc.nextInt());
        }

	    while(combineThree(riceballs) != 0 || combineTwo(riceballs) != 0){

        }

	    biggestRiceball(riceballs);
    }
}
