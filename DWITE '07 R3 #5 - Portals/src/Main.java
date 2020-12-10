import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static char[][] map;
    static boolean[][] beenTo;
    static int[] count;
    static int rows, cols, spot;
    static Cords[] Tp;

    static class Cords{
        int row, col;
        public Cords(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    private static void findRoom(int row, int col){
        if(row >= 0 && row < rows && col >= 0 && col < cols && map[row][col] != '#' && !beenTo[row][col]){
            beenTo[row][col] = true;
            count[spot]++;
            findRoom(row +1, col);
            findRoom(row -1, col);
            findRoom(row, col+1);
            findRoom(row, col-1);
            if(map[row][col] == 'a'){
                findRoom(Tp[0].row, Tp[0].col);
            }
            else if(map[row][col] == 'b'){
                findRoom(Tp[1].row, Tp[1].col);
            }
            else if(map[row][col] == 'c'){
                findRoom(Tp[2].row, Tp[2].col);
            }
            else if(map[row][col] == 'd'){
                findRoom(Tp[3].row, Tp[3].col);
            }
            else if(map[row][col] == 'e'){
                findRoom(Tp[4].row, Tp[4].col);
            }
            else if(map[row][col] == 'f'){
                findRoom(Tp[5].row, Tp[5].col);
            }
            else if(map[row][col] == 'g'){
                findRoom(Tp[6].row, Tp[6].col);
            }
            else if(map[row][col] == 'h'){
                findRoom(Tp[7].row, Tp[7].col);
            }
            else if(map[row][col] == 'i'){
                findRoom(Tp[8].row, Tp[8].col);
            }
            else if(map[row][col] == 'j'){
                findRoom(Tp[9].row, Tp[9].col);
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        rows = Integer.parseInt(next()); cols = Integer.parseInt(next());
        map = new char[rows][cols];
        Cords[] RMI = new Cords[5];
        Tp = new Cords[10];
        count = new int[5];
        for(int i = 0 ; i < rows; i++){

            map[i] = next().toCharArray();
            for(int o = 0 ; o < cols; o++){
                if(map[i][o] == '1'){
                    RMI[0] = new Cords(i, o);
                }
                else if(map[i][o] == '2'){
                    RMI[1] = new Cords(i,o);
                }
                else if(map[i][o] == '3'){
                    RMI[2] = new Cords(i,o);
                }
                else if(map[i][o] == '4'){
                    RMI[3] = new Cords(i,o);
                }
                else if(map[i][o] == '5'){
                    RMI[4] = new Cords(i,o);
                }
                else if(map[i][o] == 'A'){
                    Tp[0] = new Cords(i,o);
                }
                else if(map[i][o] == 'B'){
                    Tp[1] = new Cords(i,o);
                }
                else if(map[i][o] == 'C'){
                    Tp[2] = new Cords(i,o);
                }
                else if(map[i][o] == 'D'){
                    Tp[3] = new Cords(i,o);
                }
                else if(map[i][o] == 'E'){
                    Tp[4] = new Cords(i,o);
                }
                else if(map[i][o] == 'F'){
                    Tp[5] = new Cords(i,o);
                }
                else if(map[i][o] == 'G'){
                    Tp[6] = new Cords(i,o);
                }
                else if(map[i][o] == 'H') {
                    Tp[7] = new Cords(i, o);
                }
                else if(map[i][o] == 'I'){
                    Tp[8] = new Cords(i,o);
                }
                else if(map[i][o] == 'J'){
                    Tp[9] = new Cords(i,o);
                }
            }
        }
        spot = 0;
        for(; spot < 5; spot++){
            beenTo = new boolean[rows][cols];
            findRoom(RMI[spot].row, RMI[spot].col);
        }
        for(int i = 0 ; i < 5; i++){
            out.println(count[i]);
        }


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

}
