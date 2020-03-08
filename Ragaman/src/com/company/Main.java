package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();
        char[] firstch = first.toCharArray();
        char[] secondch = second.toCharArray();
        int counter = 0;
        for(int o = 0; o < first.length(); o++){
            for(int a = 0; a < second.length();a++){
                if(secondch[a] == firstch[o]){
                    secondch[a] = ' ';
                    firstch[o] = '/';

                    counter++;
                }
                else if(secondch[a] == '*'){
                    secondch[a] = ' ';
                    counter++;

                }
            }
        }
        if(counter == first.length())
            System.out.println("A");
        else
            System.out.println("N");
    }
}
