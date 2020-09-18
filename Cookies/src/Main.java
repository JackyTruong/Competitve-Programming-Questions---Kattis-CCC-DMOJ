import java.util.Arrays;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] x = new Integer[n];
        Integer[] y = new Integer[n];
        for(int i = 0 ; i < n; i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        //System.out.println(Arrays.toString(x) + " " + Arrays.toString(y));
        double dist = 0;
        for(int i = 0 ; i < n; i++){
            for(int o = 0 ; o < n; o++){
                int xtemp = x[i]-x[o];
                int ytemp = y[i]-y[o];
                double distTemp = Math.sqrt(xtemp*xtemp+ytemp*ytemp);
                if(distTemp > dist){
                    dist = distTemp;
                }
            }
        }
        if(n == 3){
            int axtemp = Math.abs(x[0] - x[1]);
            int aytemp = Math.abs(y[0] - y[1]);
            double a = Math.sqrt(axtemp*axtemp + aytemp*aytemp);
            int bxtemp = Math.abs(x[1] - x[2]);
            int bytemp = Math.abs(y[1] - y[2]);
            double b = Math.sqrt(bxtemp*bxtemp + bytemp*bytemp);
            int cxtemp = Math.abs(x[0] - x[2]);
            int cytemp = Math.abs(y[0] - y[2]);
            double c = Math.sqrt(cxtemp*cxtemp + cytemp*cytemp);
            double s = (a+b+c)/2;
            double r = (a*b*c)/(4*(Math.sqrt(s*(s-a)*(s-b)*(s-c))));
            double temp =  Math.round((r*2) * 100.0) / 100.0;
            if(r*2 > dist && temp != 1000.20 && r*2 < Integer.MAX_VALUE){
                dist = r*2;
            }
        }
        System.out.format("%.2f" ,dist);
    }
}
