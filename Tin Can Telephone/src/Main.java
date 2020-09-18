import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int xR, yR, xJ, yJ;

    static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isOnLine(int xF, int yF, int xS, int yS, int xP, int yP){
        if((xP <= Math.max(xF, xS) && xP >= Math.min(xF, xS)) && (yP <= Math.max(yF, yS) && yP >= Math.min(yF, yS))){
            return true;
        }
        return false;
    }

    private static int direction(int xF, int yF, int xS, int yS, int xT, int yT){
        int v = ((yS - yF)*(xT-xS))-((xS-xF)*(yT-yS));
        if(v == 0){
            return 0;
        }
        else if(v < 0){
            return 2;
        }
        return 1;
    }

    private static boolean isTouching(int xF, int yF, int xS, int yS){
        int dirF = direction(xR, yR, xJ, yJ, xF, yF);
        int dirS = direction(xR, yR, xJ, yJ, xS, yS);
        int dirT = direction(xF, yF, xS, yS, xR, yR);
        int dirFour = direction(xF, yF, xS, yS, xJ, yJ);
        if(dirF != dirS && dirT != dirFour){
            return true;
        }
        if(dirF == 0 && isOnLine(xR, yR, xJ, yJ, xF, yF)){
            return true;
        }
        if(dirS == 0 && isOnLine(xR, yR, xJ, yJ, xS, yS)){
            return true;
        }
        if(dirT == 0 && isOnLine(xF, yF, xS, yS, xR, yR)){
            return true;
        }
        if(dirFour == 0 && isOnLine(xF, yF, xS, yS, xJ, yJ)){
            return true;
        }
        return false;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        xR = nextInt();yR = nextInt();xJ = nextInt();yJ = nextInt();
        int count = 0;
        int n = nextInt();
        for(int i = 0 ; i < n; i++){
            int sides = nextInt();
            Point[] cords = new Point[sides];
            for(int o = 0; o < sides; o++){
                cords[o] = new Point(nextInt(), nextInt());
            }
            boolean isBlock = false;
            if(isTouching(cords[sides-1].x,cords[sides-1].y, cords[0].x, cords[sides-1].y)){
                isBlock = true;
            }
            for(int a = 1; a < sides && !isBlock; a++){
                if(isTouching(cords[a].x, cords[a].y, cords[a-1].x, cords[a-1].y)){
                    isBlock = true;
                }
            }
            if(isBlock){
                count++;
            }
        }
        out.println(count);
        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
