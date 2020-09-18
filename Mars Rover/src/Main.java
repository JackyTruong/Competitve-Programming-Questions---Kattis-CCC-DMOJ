import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = nextInt();
        for(int z = 0 ;z < t; z++){
            int dir = 0;
            int x = 0;
            int y = 0;
            int temp = nextInt();
            while(temp != 0){
                if(temp == 1){
                    int dist = nextInt();
                    if(dir == 0){
                        x += dist;
                    }
                    else if(dir == 90){
                        y += dist;
                    }
                    else if(dir == 180){
                        x -= dist;
                    }
                    else{
                        y -= dist;
                    }
                }
                else if(temp == 2){
                    dir -= 90;
                    if(dir < 0){
                        dir = 270;
                    }
                }
                else{
                    dir += 90;
                    if(dir == 360){
                        dir = 0;
                    }
                }
                temp = nextInt();
            }
            out.println("Distance is " + (Math.abs(x) + Math.abs(y)));
            if(y > 0 && x > 0){
                if(dir == 0){
                    right();
                    forward(y);
                    right();
                    forward(x);
                }
                else if(dir == 90){
                    left();
                    forward(x);
                    left();
                    forward(y);
                }
                else if(dir == 180){
                    forward(x);
                    left();
                    forward(y);
                }
                else if(dir == 270){
                    forward(y);
                    right();
                    forward(x);
                }
            }
            else if(y > 0 && x < 0){
                if(dir == 0){
                    forward(x);
                    right();
                    forward(y);
                }
                else if(dir == 90){
                    right();
                    forward(x);
                    right();
                    forward(y);
                }
                else if(dir == 180){
                    left();
                    forward(y);
                    left();
                    forward(x);
                }
                else if(dir == 270){
                    forward(y);
                    left();
                    forward(x);
                }
            }
            else if(y < 0 && x < 0){
                if(dir == 0){
                    forward(x);
                    left();
                    forward(y);
                }
                else if(dir == 90){
                    forward(y);
                    right();
                    forward(x);
                }
                else if(dir == 180){
                    right();
                    forward(y);
                    right();
                    forward(x);
                }
                else if(dir == 270){
                    left();
                    forward(x);
                    left();
                    forward(y);
                }
            }
            else if(y < 0 && x > 0){
                if(dir == 0){
                    left();
                    forward(y);
                    left();
                    forward(x);
                }
                else if(dir == 90){
                    forward(y);
                    left();
                    forward(x);
                }
                else if(dir == 180){
                    forward(x);
                    right();
                    forward(y);
                }
                else if(dir == 270){
                    right();
                    forward(x);
                    right();
                    forward(y);
                }
            }
            else if(y == 0 && x > 0){
                if(dir == 0){
                    right();
                    right();
                    forward(x);
                }
                else if(dir == 90){
                    left();
                    forward(x);
                }
                else if(dir == 180){
                    forward(x);
                }
                else if(dir == 270){
                    right();
                    forward(x);
                }
            }
            else if(y == 0 && x < 0){
                if(dir == 0){
                    forward(x);
                }
                else if(dir == 90){
                    right();
                    forward(x);
                }
                else if(dir == 180){
                    left();
                    left();
                    forward(x);
                }
                else if(dir == 270){
                    left();
                    forward(x);
                }
            }
            else if(y >0 && x == 0){
                if(dir == 0){
                    right();
                    forward(y);
                }
                else if(dir == 90){
                    left();
                    left();
                    forward(y);
                }
                else if(dir == 180){
                    left();
                    forward(y);
                }
                else if(dir == 270){
                    forward(y);
                }
            }
            else if(y < 0 && x == 0){
                if(dir == 0){
                    left();
                    forward(y);
                }
                else if(dir == 90){
                    forward(y);
                }
                else if(dir == 180){
                    right();
                    forward(y);
                }
                else if(dir == 270){
                    left();
                    left();
                    forward(y);
                }
            }
        }
        out.close();
    }

    private static void forward(int num){
        out.println(1);
        out.println(Math.abs(num));
    }

    private static void right(){
        out.println(2);
    }

    private static void left(){
        out.println(3);
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
