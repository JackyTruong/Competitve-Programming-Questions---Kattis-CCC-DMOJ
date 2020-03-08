package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String letter(int i){
        if(i > 10){
            if(i == 10){
                return "A";
            }
            if(i == 11){
                return "B";
            }
            if(i == 12){
                return "C";
            }
            if(i == 13){
                return "D";
            }
            if(i == 14){
                return "E";
            }
            if(i == 15){
                return "F";
            }
        }
        return String.valueOf(i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = n/16;
        n -= f*16;
        int t = f/16;
        f -= t*16;
        int s = t/16;
        t -= s*16;
        int i = s/16;
        s -= i*16;
        String[] digits = new String[4];
        digits[3] = letter(n);
        digits[2] = letter(f);
        digits[1] = letter(t);
        digits[0] = letter(s);
        System.out.println(digits[0] + digits[1] + digits[2] + digits[3]);
    }
}
