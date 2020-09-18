import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        boolean[][] mine = new boolean[201][402];
        mine[1][201] = true;
        mine[2][201] = true;
        mine[3][201] = true;
        mine[3][202] = true;
        mine[3][203] = true;
        mine[3][204] = true;
        mine[4][204] = true;
        mine[5][204] = true;
        mine[5][205] = true;
        mine[5][206] = true;
        mine[4][206] = true;
        mine[3][206] = true;
        mine[3][207] = true;
        mine[3][208] = true;
        mine[4][208] = true;
        mine[5][208] = true;
        mine[6][208] = true;
        mine[7][208] = true;
        mine[7][207] = true;
        mine[7][206] = true;
        mine[7][205] = true;
        mine[7][204] = true;
        mine[7][203] = true;
        mine[7][202] = true;
        mine[7][201] = true;
        mine[7][200] = true;
        mine[6][200] = true;
        mine[5][200] = true;
        int spotRow = 5;
        int spotCol = 200;
        String direction = next();
        int num = nextInt();
        boolean hit = false;
        while(!direction.equals("q")){
            if(direction.equals("l")){
                for(int i = 0 ; i < num; i++){
                    spotCol--;
                    if(mine[spotRow][spotCol]){
                        hit = true;
                    }
                    mine[spotRow][spotCol] = true;
                }
            }
            else if(direction.equals("d")){
                for(int i = 0 ; i < num ;i++){
                    spotRow++;
                    if(mine[spotRow][spotCol]){
                        hit = true;
                    }
                    mine[spotRow][spotCol] = true;
                }
            }
            else if(direction.equals("r")){
                for(int i = 0 ; i < num; i++){
                    spotCol++;
                    if(mine[spotRow][spotCol]){
                        hit = true;
                    }
                    mine[spotRow][spotCol] = true;
                }
            }
            else if(direction.equals("u")){
                for(int i = 0 ; i < num; i++){
                    spotRow--;
                    if(mine[spotRow][spotCol]){
                        hit = true;
                    }
                    mine[spotRow][spotCol] = true;
                }
            }
            if(hit){
                System.out.println((spotCol - 201) + " " + -spotRow + " DANGER");
                break;
            }
            else{
                System.out.println((spotCol - 201) + " " + -spotRow + " safe");
            }

            direction = next();
            num = nextInt();
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
