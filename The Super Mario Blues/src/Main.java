import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n; i++){
            StringTokenizer temp = new StringTokenizer(br.readLine(), "-");
            int world = Integer.parseInt(temp.nextToken());
            int level = Integer.parseInt(temp.nextToken());
            int goneThrough = 0;
            if(world == 1 && level <= 2){
                goneThrough += 2-level+1;
                world = 4;
                level = 1;
            }
            else if(world < 4){
                goneThrough += 4-level+1;
                goneThrough += (3-world)*4;
                world =4;
                level = 1;
                //System.out.println(goneThrough);
            }
            if(world <= 4 && level <= 2){
                goneThrough += 2-level+1;
                goneThrough += (4-world) * 4;
                world = 8;
                level = 1;
            }

            if(world >= 4){
                //System.out.println(goneThrough);
                goneThrough += 4-level+1;
                goneThrough += (8-world)*4;
            }
            System.out.println(goneThrough);
        }
    }
}
