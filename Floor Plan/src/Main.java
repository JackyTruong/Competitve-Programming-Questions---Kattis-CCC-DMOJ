import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int tiles, row, col;
    static boolean[][] beenTo;
    static int count = 0;
    static int[][] roomSize;

    private static void mapRooms(String[] house, int x, int y){
        beenTo[x][y] = true;
        count++;
        //System.out.println("this x and y" + x + " " + y + " " + house[x].charAt(y));
        if(house[x].charAt(y) == '.'){
            if(x+1 < row&& !beenTo[x+1][y]){
                mapRooms(house, x+1, y);
            }
            if(x-1 >= 0 &&!beenTo[x-1][y]){
                mapRooms(house, x-1, y);
            }
            if(y+1 < col&& !beenTo[x][y+1]){
                mapRooms(house, x, y+1);
            }
            if(y-1 >= 0 &&!beenTo[x][y-1]){
                mapRooms(house, x, y-1);
            }
        }
        else{
            count--;
        }
    }



    private static int[][] fillRooms(String[] house, int x, int y){
        beenTo[x][y] = true;
        if(house[x].charAt(y) == '.'){
            roomSize[x][y] = count;
            if(x+1 < row&& !beenTo[x+1][y]){
                fillRooms(house, x+1, y);
            }
            if(x-1 >= 0 && !beenTo[x-1][y]){
                fillRooms(house, x-1, y);
            }
            if(y+1 < col&& !beenTo[x][y+1]){
                fillRooms(house, x, y+1);
            }
            if(y-1 >= 0 && !beenTo[x][y-1]){
                fillRooms(house, x, y-1);
            }
        }
        //out.println("work" + count + " " + x + "  " + y);
        return roomSize;
    }


    public static void main(String[] args)throws IOException {
        br =  new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        tiles = nextInt(); row = nextInt(); col = nextInt();
        beenTo = new boolean[row][col];
        String[] house = new String[row];
        roomSize = new int[row][col];
        ArrayList<Integer> sizes = new ArrayList<>();
        for(int i = 0 ; i < row; i++){
            Arrays.fill(beenTo[i], false);
            Arrays.fill(roomSize[i], -1);
        }
        for(int i = 0; i < row; i++){
            house[i] = next();
            //out.println(house[i]);
        }
        for(int x = 0 ; x < row; x++){
            for(int y = 0; y < col; y++) {

                if(house[x].charAt(y) != 'I' ){
                    if(roomSize[x][y] == -1){
                        //out.println("this is the new room " + x + " " + y + " " + roomSize[x][y]);
                        mapRooms(house, x, y);
                        //System.out.println(count);
                        //for(int i = 0 ; i < row; i++){
                        //    System.out.println(Arrays.toString(beenTo[i]));
                        //}
                        //System.out.println("this is count bef " + count);
                        //System.out.println("end");
                        for(int i = 0 ; i < row; i++){
                            Arrays.fill(beenTo[i], false);
                        }
                        roomSize = fillRooms(house, x, y);
                        sizes.add(count);
                       // System.out.println("this is cout afta" + count);
                        roomSize[x][y] = count;
                        count = 0;
                    }
                }


            }
        }
        /*
        for(int i = 0 ; i < row; i++){
            for(int o = 0; o < col; o++){
                System.out.print(roomSize[i][o] + " ");
            }
            System.out.println("");
        }

         */
        Collections.sort(sizes,Collections.reverseOrder());
        int roomsFill = 0;
        for(int i = 0 ; i < sizes.size(); i++){
            if(tiles - sizes.get(i) >= 0){
                tiles-=sizes.get(i);
                roomsFill++;
            }
            else{
                break;
            }
        }
        if(roomsFill == 1){
            out.println(roomsFill + " room, " + tiles + " square metre(s) left over");
        }
        else{
            out.println(roomsFill + " rooms, " + tiles + " square metre(s) left over");
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
