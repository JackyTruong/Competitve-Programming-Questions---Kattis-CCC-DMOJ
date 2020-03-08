package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static Integer[] createHistogram(Integer[] woodLengths){
		Integer histogram[] = new Integer[2001];
		Arrays.fill(histogram, 0);
		for(int numbers : woodLengths){
			histogram[numbers]++;
		}
		return histogram;
	}

	public static int maxLengthAtHeight(int a, Integer[] histogram){
		int board1 = Math.max(1, a-2000);
		int board2 = a - board1;

		Integer[] boards = new Integer[histogram.length];
		System.arraycopy(histogram, 0, boards, 0, histogram.length);

		int h1 = 0;
		int h2 = 0;
		int boardsMakeable = 0;
		int makeable = 0;
		while(board1 <= a/2){
			h1 = boards[board1];
			h2 = boards[board2];
			if(board1 == board2){
				boardsMakeable += h1/2;
				boards[board1] -= h1;
			}
			else{
				makeable = Math.min(h1, h2);
				boards[board1] -= makeable;
				boards[board2] -= makeable;
				boardsMakeable += makeable;
			}
			board1++;
			board2--;
		}
		return boardsMakeable;
	}

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("s3.21.IN");
	    Scanner sc = new Scanner(file);
	    int i = sc.nextInt();
	    Integer woodLengths[] = new Integer[i];
	    for(int o = 0; o < i; o++){
	        woodLengths[o] = sc.nextInt();
        }
	    Integer[] histogram = createHistogram(woodLengths);
	    int count = 0;
	    int testmaxLength = 0;
	    int maxLength = 0;
	    for(int b = 2; b <= 4000; b++){
			testmaxLength = maxLengthAtHeight(b, histogram);
			if(testmaxLength > maxLength){
				maxLength = testmaxLength;
				count = 1;
			}
			else if(testmaxLength == maxLength){
				count++;
			}
		}
	    System.out.println(maxLength + " " + count);
    }
}
