import java.util.Scanner;

public class Main {

    private static boolean isPalindrome(int x){
        boolean flip = true;
        char[] temp = ("" + x).toCharArray();
        int back = temp.length-1;
        for(int i = 0; i < temp.length/2;i++){

            //TODO if the number is 6 or 9 check if the other number is also 6 or 9 then have an else to do the checking whether they are the same number

            if(temp[i] == '6'){
                if(temp[back] == '6'){
                    flip = false;
                }
                else if(temp[back] != '9'){

                    flip = false;
                }
            }
            else if(temp[i] == '9'){
                if(temp[back] == '9'){

                    flip = false;
                }
                else if(temp[back] != '6'){
                    flip = false;
                }
            }
            else{
                if(temp[i] != temp[back]){
                    flip = false;
                }
            }
            back--;
        }
        if(temp.length%2 == 1 && temp.length/2 < temp.length-1){
            if(temp[temp.length/2] == '6' || temp[temp.length/2] == '9'){
                flip = false;
            }
        }
        return flip;
    }
    private static boolean isDigit(int x){
        int temp = x;
        boolean count = false;
        while(x > 0){
            if((x%10 == 2 || x%10 == 3 || x%10 == 4 || x%10 == 5 || x%10 == 7) || !isPalindrome(temp)){
                count = true;
                break;
            }
            x /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int numberCounter = 0;
        for(int i = n; i <= m;i++){
         if(!isDigit(i) && i != 6 && i != 9){
              numberCounter++;
           }
        }
        System.out.println(numberCounter);

    }
}
