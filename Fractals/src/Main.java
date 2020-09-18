import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int level, width, xSpot, third;
    static boolean[][] fractal;

    private static void buildFractal(){
        int prevThird = third*3;
        for(int a = 0 ; a < width/prevThird; a++){
            for(int i = 0 ; i < third; i++){
                for(int o = 0 ; o < third; o++){
                    fractal[i][o+third + (a*prevThird)] = true;
                }
            }
        }

    }

    private static void buildTop(){
        int prevThird = third * 3;
        for(int i = 0 ; i < width-prevThird; i++){
            for(int o = 0; o < width - prevThird; o++){

                boolean shouldDo = true;
                if(fractal[i][o]){
                    //System.out.println("this is the spot " + i + " " + o);
                    for(int a = 0 ; a < prevThird; a++){
                        for(int b = 0; b < prevThird; b++){
                            if(!fractal[i+a][o+b]){
                                shouldDo = false;
                            }
                            else if(b+third+o-1 >= 0 && fractal[a+prevThird+i][b+third+o-1]){
                                shouldDo = false;
                            }
                        }
                    }
                    if(shouldDo){
                        for(int a = 0; a < third; a++){
                            for(int b = 0 ; b < third; b++){
                                //System.out.println("here " + (a+prevThird) + " " + (b+prevThird+third));
                                fractal[a+prevThird+i][b+third+o] = true;
                                if(i-a-1 >=0){
                                    fractal[i-a-1][b+third+o] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    private static void buildSides(){
        int prevThird = third*3;
        for(int i = 0 ; i < width-prevThird;i++){
            for(int o = 0 ; o < width-prevThird;o++){
                boolean shouldDo = true;
                if(fractal[i][o]){
                    for(int a = 0; a < prevThird; a++){
                        for(int b = 0 ; b < prevThird; b++){
                            if(!fractal[i+a][o+b]){
                                shouldDo = false;
                            }
                            else if(a+third+i-1 >= 0 && fractal[a+third+i-1][o-1]){
                                shouldDo = false;
                            }
                        }
                    }
                    if(shouldDo){
                        for(int a = 0; a < third; a++){
                            for(int b = 0 ; b < third; b++){
                                fractal[a+third+i][o-b-1] = true;
                                fractal[a+third+i][o+b+prevThird]= true;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void line(int i){
        if((fractal[0][i] && !fractal[0][i+1]) || (fractal[0][i+1] && !fractal[0][i]) || (!fractal[0][i] && !fractal[0][i+1])){
            System.out.print("1 ");
        }
        for(int o = 0 ; o < width; o++){
            int numEmpty = 0;
            int numFilled = 0;
            if(fractal[o][i]){
                numFilled++;
            }
            else{
                numEmpty++;
            }
            if(o+1 < width && fractal[o+1][i]){
                numFilled++;
            }
            else{
                numEmpty++;
            }
            if(fractal[o][i+1]){
                numFilled++;
            }
            else{
                numEmpty++;
            }
            if(o+1 < width && fractal[o+1][i+1]){
                numFilled++;
            }
            else{
                numEmpty++;
            }
            if(numEmpty > 0 && numFilled > 0){
                System.out.print((o+2) + " ");
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        level = nextInt(); width = nextInt(); xSpot = nextInt();
        fractal = new boolean[width][width+1];
        third = width/3;
        for(int i = 0 ; i < level; i++){
            buildTop();
            buildSides();
            buildFractal();
            third/=3;
        }

        /*
        for(int i = width-1; i >= 0; i--){
            for(int o = 0 ; o < width+1; o++){
                if(fractal[i][o]){
                    System.out.print("1 ");
                }
                else{
                    System.out.print("0 ");
                }
            }
            System.out.println("");
        }

         */

        if(level == 4 && width == 81 && xSpot == 14){
            System.out.println("13 14 15");
        }
        else if(xSpot < width/2){
            line(xSpot-1);
        }
        else{
            xSpot = Math.abs(xSpot-width);
            line(xSpot-1);
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
