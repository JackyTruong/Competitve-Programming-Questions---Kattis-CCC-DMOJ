import java.util.Scanner;

public class Main {

    static String output, temp;

    private static void decrypt(){
        for(int i = 0 ; i < temp.length(); i++){
            if(temp.charAt(i) == '0'){
                output += '9';
            } else if (temp.charAt(i) == '1') {
                output += 'A';
            } else if (temp.charAt(i) == '2') {
                output += 'B';
            } else if (temp.charAt(i) == '3') {
                output += 'C';
            } else if (temp.charAt(i) == '4') {
                output += 'D';
            } else if (temp.charAt(i) == '5') {
                output += 'E';
            } else if (temp.charAt(i) == '6') {
                output += 'F';
            } else if (temp.charAt(i) == '7') {
                output += 'G';
            } else if (temp.charAt(i) == '8') {
                output += 'H';
            } else if (temp.charAt(i) == '9') {
                output += 'I';
            } else if (temp.charAt(i) == 'A') {
                output += 'J';
            } else if (temp.charAt(i) == 'B') {
                output += 'K';
            } else if (temp.charAt(i) == 'C') {
                output += 'L';
            } else if (temp.charAt(i) == 'D') {
                output += 'M';
            } else if (temp.charAt(i) == 'E') {
                output += 'N';
            } else if (temp.charAt(i) == 'F') {
                output += 'O';
            } else if (temp.charAt(i) == 'G') {
                output += 'P';
            } else if (temp.charAt(i) == 'H') {
                output += 'Q';
            } else if (temp.charAt(i) == 'I') {
                output += 'R';
            } else if (temp.charAt(i) == 'J') {
                output += 'S';
            } else if (temp.charAt(i) == 'K') {
                output += 'T';
            } else if (temp.charAt(i) == 'L') {
                output += 'U';
            } else if (temp.charAt(i) == 'M') {
                output += 'V';
            } else if (temp.charAt(i) == 'N') {
                output += 'W';
            } else if (temp.charAt(i) == 'O') {
                output += 'X';
            } else if (temp.charAt(i) == 'P') {
                output += 'Y';
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        temp = sc.nextLine();
        output = "";
        decrypt();
        System.out.println(output);
    }
}
