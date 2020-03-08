import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String i = sc.nextLine();
        char[] word = i.toCharArray();
        int up =0;
        int left= 0;
        for(int o = 0; o < word.length;o++){
            if(word[o] == 'H'){
                left++;
            }
            else if(word[o] == 'V'){
                up++;
            }
        }
        if(((up%2)==1) && ((left%2) == 1)){
            System.out.println("4  3");
            System.out.println("2  1");
        }
        else if(((up%2)==1) && ((left%2) == 0)){
            System.out.println("2  1");
            System.out.println("4  3");
        }
        else if(((up%2)==0) && ((left%2) == 1)){
            System.out.println("3  4");
            System.out.println("1  2");
        }
        else{
            System.out.println("1  2");
            System.out.println("3  4");
        }
    }
}
