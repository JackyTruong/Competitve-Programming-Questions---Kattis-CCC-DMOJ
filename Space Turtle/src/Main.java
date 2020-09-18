import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static double shipX, shipY, shipZ, shellX, shellY, shellZ;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        shipX = nextDouble();shipY = nextDouble();shipZ = nextDouble();shellX = nextDouble();shellY = nextDouble();shellZ = nextDouble();
        double dist = nextDouble(); String direction = next();
        double x = shellX - shipX;
        double y = shellY - shipY;
        double z = shellZ - shipZ;
        double closest = x*x+y*y+z*z;
        double temp;
        while(!direction.equals("E")){
            double tempX = x - dist;
            if(tempX * x < 0){
                closest = Math.min(closest, y*y+z*z);
            }
            else{
                closest = Math.min(closest, y*y+z*z+tempX*tempX);
            }
            x = tempX;
            temp = x;
            if(direction.equals("L")){
                x = y;
                y = -temp;
            }
            else if(direction.equals("R")){
                x = -y;
                y = temp;
            }
            else if(direction.equals("U")){
                x = z;
                z = -temp;
            }
            else{
                x = -z;
                z = temp;
            }
           dist = nextDouble();
           direction = next();
        }
        double tempX = x - dist;
        if(tempX * x < 0){
            closest = Math.min(closest, y*y+z*z);
        }
        else{
            closest = Math.min(closest, y*y+z*z+tempX*tempX);
        }
        out.println((int)((Math.sqrt(closest) * 100) + 0.5) / 100.0);

        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static double nextDouble()throws IOException{
        return Double.parseDouble(next());
    }
}
