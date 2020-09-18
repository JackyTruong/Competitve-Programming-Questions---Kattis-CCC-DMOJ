import java.util.Scanner;

public class Main {

    static double n, m, begX, begY, x, y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt(); begX = sc.nextInt(); begY = sc.nextInt();
        boolean into = false;
        double slope;
        int numHeight, numWidth, bounces;
        slope = begY / (n - begX);
        for(int a = 1; a <= 100000000 && !into; a++){
            y = slope * ((a * n) - begX);
            x = (a*m)/slope+begX;
            numHeight = (int) ((y - (m/2))/m) + 1;
            numWidth  = (int) ((x - (n/2))/n) + 1;
            double temp = numHeight * m;
            double temp1 =numWidth * n;
            if((Math.abs(temp - y) < 5) || (Math.abs(temp1-x) < 5)){
                if(Math.abs(temp - y) < 5){
                    if(temp != y){
                        bounces = a - 1 + (int) (y/m);
                    }else{
                        bounces = a - 1 + (int) (y/m) -1;
                    }
                }
                else{
                    if(temp1 != x){
                        bounces = a - 1 + (int) (x/n);
                    }
                    else{
                        bounces = a - 1 + (int) (x/n) - 1;
                    }
                }
                System.out.println(bounces);
                into = true;
            }
        }
        if(!into){
            System.out.println(0);
        }
    }
}
