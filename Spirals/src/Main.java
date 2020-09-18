import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        //int n = sc.nextInt();
        //System.out.println(n);
        //for(int b = 0 ; b < n; b++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            ArrayList<ArrayList<Integer>> spiral = new ArrayList<>();
            for(int i = 0; i < 10; i++){
                spiral.add(new ArrayList<>());
            }

            int count = 1;
            int times = 1;
            int rotation = 0;
            int base = 4;
            spiral.get(base).add(x);
            for(int i = x+1 ; i < y+1;){
                for(int o = 0; o < count && i < y+1;o++){
                    if(rotation == 0){
                        base++;
                        spiral.get(base).add(0, i);
                    }
                    if(rotation == 1){
                        spiral.get(base).add(i);
                    }
                    if(rotation == 2){
                        base--;
                        spiral.get(base).add(i);
                    }
                    if(rotation == 3){
                        spiral.get(base).add(0,i);
                    }
                    i++;
                    //System.out.println(i + " " + rotation);
                }
                if(times == 2){
                    times = 0;
                    count++;
                }
                rotation++;
                if(rotation == 4){
                    rotation = 0;
                }
                times++;
            }
            int biggest = 0;
            for(int i = 0; i < spiral.size();i++){
                if(spiral.get(i).size() > biggest){
                    biggest = spiral.get(i).size();
                }
            }
            for(int i = 0; i < spiral.size();i++){
                boolean will = false;
                if(spiral.get(i).size() > 0){
                    will = true;
                }
                if(spiral.get(i).size() < biggest && will && rotation != 2 && rotation != 3){
                    int temp = biggest - spiral.get(i).size();
                    for(int a = 0; a < temp;a++){
                        System.out.print("   ");
                    }
                }
                for(int o = 0; o < spiral.get(i).size();o++){
                    if(spiral.get(i).get(o)/10 == 0){
                        System.out.print("0");
                    }
                    if(o < spiral.get(i).size()-1){
                        System.out.print(spiral.get(i).get(o) + " ");
                    }
                    else{
                        System.out.print(spiral.get(i).get(o));
                    }
                }
                if(will){
                    System.out.println("");
                }
            }
            System.out.println("");
        //}

    }
}
