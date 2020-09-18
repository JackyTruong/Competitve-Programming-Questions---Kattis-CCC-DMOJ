import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int width, height, cutOutSide, cutOutTop, y , x, steps, walkedSteps;
    static int[][] map;
    static boolean[][] beenTo;

    private static void walkRight(){
        beenTo[y][x] = true;
        if(x + 1 < width && map[y][x+1] != -1 && !beenTo[y][x+1] && steps != walkedSteps){
            if(y-1 >= 0 && (map[y-1][x] != 0 || beenTo[y-1][x])){
                x++;
                walkedSteps++;
                walkRight();
            }
            else if(y-1 < 0) {
                x++;
                walkedSteps++;
                walkRight();
            }
        }
    }

    private static void walkLeft(){
        beenTo[y][x] = true;
        if(x - 1 >= 0 && map[y][x-1] != -1 && !beenTo[y][x-1] && steps != walkedSteps){
            if(y+1 < height && (map[y+1][x] != 0 || beenTo[y+1][x])){
                x--;
                walkedSteps++;
                walkLeft();
            }
            else if(y+1 >= height){
                x--;
                walkedSteps++;
                walkLeft();
            }
        }
    }

    private static void walkDown(){
        beenTo[y][x] = true;

        if(y + 1 < height && map[y+1][x] != -1 && !beenTo[y+1][x] && steps != walkedSteps){

            if(x+1 < width && (map[y][x+1] != 0 || beenTo[y][x+1])){
                y++;
                walkedSteps++;
                walkDown();
            }
            else if(x+1 >= width){
                y++;
                walkedSteps++;
                walkDown();
            }
        }
    }

    private static void walkUp(){
        beenTo[y][x] = true;

        if(y - 1 >= 0 && map[y-1][x] != -1 && !beenTo[y-1][x] && steps != walkedSteps){
            if(x-1 >= 0 && (map[y][x-1] != 0 || beenTo[y][x-1])){
                y--;
                walkedSteps++;
                walkUp();
            }
            else if(x-1 < 0){
                y--;
                walkedSteps++;
                walkUp();
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        width = sc.nextInt(); height = sc.nextInt();cutOutSide = sc.nextInt();cutOutTop = sc.nextInt();steps = sc.nextInt();
        map = new int[height][width];
        beenTo = new boolean[height][width];
        for(int i = 0 ; i < height; i++){
            Arrays.fill(map[i], 0);
            Arrays.fill(beenTo[i], false);
        }
        for(int i = 0; i < cutOutTop; i++){
            for(int o = 0; o < cutOutSide; o++){
                map[i][o] = -1;
                beenTo[i][o] = true;
            }
        }
        for(int i = 0; i < cutOutTop; i++){
            for(int o = width - cutOutSide; o < width; o++){
                map[i][o] = -1;
                beenTo[i][o] = true;
            }
        }
        for(int i = height-cutOutTop; i < height; i++){
            for(int o = 0; o < cutOutSide; o++){
                //System.out.println(i + " " + o);
                map[i][o] = -1;
                beenTo[i][o] = true;
            }
        }
        for(int i = height-cutOutTop; i < height; i++){
            for(int o = width - cutOutSide; o < width; o++){
                //System.out.println(i + " " + o);
                map[i][o] = -1;
                beenTo[i][o] = true;
            }
        }
        for(int i = 0 ; i < width; i++){
            if(map[0][i] == 0){
                x = i;
                break;
            }
        }
        //System.out.println(y + " " + x + " " + walkedSteps);
        //while(steps != walkedSteps){
        for(int i = 0 ; i < 6 && steps != walkedSteps; i++){
            walkRight();
            walkDown();
            walkRight();
            walkDown();
            walkLeft();
            walkDown();
            walkLeft();
            walkUp();
            walkLeft();
            walkUp();
            walkRight();
            walkUp();
        }

        //}

        map[y][x] = 1;
        System.out.println(x+1);
        System.out.println(y+1);
    }
}
