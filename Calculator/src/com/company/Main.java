package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String i = sc.nextLine();
		int o = 0;
	    while(!i.equals("Q")){
	    	String front = i.substring(0, 1);
			String back = i.substring(1, i.length());
	        if(!i.equals("C")){
	        	if(front.equals("/")){
	        		o /= Integer.parseInt(back);
					System.out.println("Total: " + o);
				}
	        	else if(front.equals("*")){
	        		o *= Integer.parseInt(back);
					System.out.println("Total: " + o);
				}
	        	else{
					o += Integer.parseInt(i);
					System.out.println("Total: " + o);
				}
            }
	        else{
	            o = 0;
	            System.out.println("Total: " + o);
            }
	        i = sc.nextLine();
        }
    }
}


