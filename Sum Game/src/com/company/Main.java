package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int largest = 0;
	    Integer[] swift = new Integer[n];
	    Integer[] semp = new Integer[n];
	    for(int i = 0 ; i < n; i++){
	        swift[i] = sc.nextInt();
        }
		for(int i = 0 ; i < n; i++){
			semp[i] = sc.nextInt();
		}
		int swiftc = 0;
		int sempc = 0;
	    for(int i = 0; i < n; i++){
	        swiftc += swift[i];
	        sempc += semp[i];
	        if(sempc == swiftc){
	            largest = i + 1;
            }
        }
	    System.out.println(largest);
    }
}
