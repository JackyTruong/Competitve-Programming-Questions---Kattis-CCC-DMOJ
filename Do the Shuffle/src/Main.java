import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Character> playlist;

    private static void But1(){
        playlist.add(playlist.remove(0));
    }

    private static void But2(){
        playlist.add(0, playlist.remove(playlist.size()-1));
    }

    private static void But3(){
        char temp = playlist.get(0);
        playlist.set(0, playlist.get(1));
        playlist.set(1, temp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        playlist = new ArrayList<>();
        playlist.add('A');
        playlist.add('B');
        playlist.add('C');
        playlist.add('D');
        playlist.add('E');
        int butClick = sc.nextInt();
        int numTimes = sc.nextInt();
        while(butClick != 4){
            for(int i = 0 ; i < numTimes; i++){
                if(butClick == 1){
                    But1();
                }
                else if(butClick == 2){
                    But2();
                }
                else{
                    But3();
                }
            }
            butClick = sc.nextInt();
            numTimes = sc.nextInt();
        }
        System.out.print(playlist.get(0));
        for(int i = 1 ; i < playlist.size();i++){
            System.out.print(" " + playlist.get(i));
        }
    }
}
