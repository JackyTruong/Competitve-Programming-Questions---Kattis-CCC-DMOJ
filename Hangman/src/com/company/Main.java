package com.company;
import java.util.Scanner;
import java.util.Random;
public class Main {

    //Declaring a new character array
    public static char[] blank;



    public static void main (String args[])  {
        Scanner input = new Scanner(System.in);

        //Creating a new random variable
        Random r = new Random();

        //Declaring a new String Array with the words
        String[] arr = { "GODZILLA", "ROBOCOP", "JAWS", "TITANIC", "ROCKY", "TERMINATOR", "JUMANJI", "ALIEN", "PREDATOR", "SCREAM"};

        String word = arr[r.nextInt(arr.length)];
        char[] CharArr =word.toCharArray();
        char[] blank = word.toCharArray();
        String[]bank = { "A", "B", "C", "D", "E", "F", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

        //Printing out the title of the game
        System.out.println("Welcome to Hangman, the random word is a popular movie from the 1990s. (Play with Caps-Lock On)");
        System.out.println("");

        //For loop that prints out the "-" for as many letters are in the random word
        for(int i=0;i<blank.length;i++)
        {
            blank[i] = '-';
            System.out.print(blank[i]);
        }

        System.out.println("");

        //A for loop that will run 7 times
        int i = 1;
        while(i <= 7)
        {
            boolean change = false;
            System.out.print("Guess a letter: ");
            char letter = input.next().charAt(0);
            System.out.println("");

            for (int j=0;j<CharArr.length; j++)
            {

                if(letter == blank[j])
                {
                    System.out.println("this letter already exist");
                    i--;
                }
                else
                {
                    if(letter==CharArr[j])
                    {
                        blank[j]=letter;
                        change = true;


                    }

                }

            }
            if(change == true){
                System.out.println("Correct guess!");
                System.out.println();
                System.out.println(blank);
                System.out.println();
                i--;
            }

            switch(i)
            {

                case 1:
                    System.out.println("");
                    System.out.println("________");
                    System.out.println("   O   |");
                    System.out.println("       |");
                    System.out.println("       |");
                    System.out.println("       |");
                    System.out.println("       ^");
                    System.out.println("");
                    System.out.println("");
                    System.out.println(blank);
                    break;

                case 2:
                    System.out.println("");
                    System.out.println("__");
                    System.out.println("   O   |");
                    System.out.println("   |   |");
                    System.out.println("       |");
                    System.out.println("       |");
                    System.out.println("       ^");
                    System.out.println("");
                    System.out.println(blank);
                    break;

                case 3:
                    System.out.println("");
                    System.out.println("___");
                    System.out.println("   O   |");
                    System.out.println("  -|   |");
                    System.out.println("       |");
                    System.out.println("       |");
                    System.out.println("       ^");
                    System.out.println("");
                    System.out.println(blank);
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("__");
                    System.out.println("   O   |");
                    System.out.println("  -|-  |");
                    System.out.println("       |");
                    System.out.println("       |");
                    System.out.println("       ^");
                    System.out.println("");
                    System.out.println(blank);
                    break;

                case 5:
                    System.out.println("");
                    System.out.println("__");
                    System.out.println("   O   |");
                    System.out.println("  -|-  |");
                    System.out.println("   ^   |");
                    System.out.println("       |");
                    System.out.println("       ^");
                    System.out.println("");
                    System.out.println(blank);
                    break;

                case 6:
                    System.out.println("");
                    System.out.println("__");
                    System.out.println("   O   |");
                    System.out.println("  -|-  |");
                    System.out.println("   ^   |");
                    System.out.println("  |    |");
                    System.out.println("       ^");
                    System.out.println("");
                    System.out.println(blank);
                    break;

                case 7:
                    System.out.println("");
                    System.out.println("__");
                    System.out.println("   O   |");
                    System.out.println("  -|-  |");
                    System.out.println("   ^   |");
                    System.out.println("  | |  |");
                    System.out.println("       ^");
                    System.out.println("");
                    System.out.println("You lost. Try again");
                    break;
            }

            if(((word)).equals(new String(blank)))
            {
                System.out.println("");
                System.out.println("You guessed the correct word!");
                break;
            }
            i++;
        }
        input.close();
    }

}
