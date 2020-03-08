package com.company;

import java.util.Scanner;

import static java.util.Arrays.sort;

public class Main {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int ans = 0;
	    int q  = sc.nextInt();
	    int p = sc.nextInt();
	    Integer[] dmoj = new Integer[p];
        Integer[] peg = new Integer[p];
        for(int o = 0; o < p; o++){
            dmoj[o] = sc.nextInt();
        }
        for(int o = 0; o < p; o++){
            peg[o] = sc.nextInt();
        }
        sort(dmoj);
        sort(peg);
        for(int o = 0; o < p; o++){
            if(q == 1){
                ans += Math.max(dmoj[o], peg[o]);
            }
            else{
                ans += Math.max(dmoj[o], peg[p-o - 1]);
            }
        }
        System.out.println(ans);
    }
}
