package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt(), cost = sc.nextInt(), r = sc.nextInt();
	    int temp = r/cost;
	    if(temp >= n){
	        System.out.println(n);
        }
	    else{
	        System.out.println(temp);
        }
    }
}
