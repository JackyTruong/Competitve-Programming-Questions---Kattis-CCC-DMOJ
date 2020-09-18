import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int higher = 0;
        int lower = 0;
        int equal = 0;
        int[] depth = new int[4];
        for(int i = 0 ; i < 4; i++){
            depth[i] = sc.nextInt();
        }
        for(int i = 1; i < 4; i++){
            if(depth[i] > depth[i-1]){
                higher++;
            }
            else if(depth[i] < depth[i-1]){
                lower++;
            }
            else{
                equal++;
            }
        }
        if(higher == 3){
            System.out.println("Fish Rising");
        }
        else if(lower == 3){
            System.out.println("Fish Diving");
        }
        else if(equal == 3){
            System.out.println("Fish At Constant Depth");
        }
        else{
            System.out.println("No Fish");
        }
    }
}
