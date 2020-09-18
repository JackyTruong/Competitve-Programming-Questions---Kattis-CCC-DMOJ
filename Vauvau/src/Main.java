import java.util.Scanner;

public class Main {

    static int[] dogA, dogB;
    static int P, M, G;

    private static void caught(int who){
        int A = who%(dogA[0] + dogA[1]);
        int B = who%(dogB[0] + dogB[1]);
        boolean Amad = false;
        boolean Bmad = false;
        if(A <= dogA[0] && A > 0){
            Amad = true;
        }
        if(B <= dogB[0] && B > 0){
            Bmad = true;
        }
        if(Bmad && Amad){
            System.out.println("both");
        }
        else if(Bmad || Amad) {
            System.out.println("one");
        }
        else{
            System.out.println("none");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dogA = new int[2];
        dogB = new int[2];
        for(int i = 0 ; i < 2; i++){
            dogA[i] = sc.nextInt();
        }
        for(int i = 0 ; i < 2; i++){
            dogB[i] = sc.nextInt();
        }
        P = sc.nextInt(); M = sc.nextInt(); G = sc.nextInt();
        caught(P);
        caught(M);
        caught(G);
    }
}
