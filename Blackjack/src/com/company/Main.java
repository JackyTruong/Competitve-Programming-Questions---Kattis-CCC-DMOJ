package com.company;

import sun.awt.image.BufferedImageDevice;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;



public class Main extends JPanel{

    private static int randomSuit(){
        int suit = (int)(Math.random() *2) + 1;
        return suit;
    }

    private static int randomCard(){
        int card = (int)(Math.random() * 11);
        return card;
    }

    Image Cards, dealer;

    public Main() throws Exception
    {

        // Java supports PNG, JPEG, and GIF (but not animated GIFs). It does not support BMP.

        Cards = ImageIO.read(Main.class.getResource("/resources/images/a.png"));

    }

    public void paint( Graphics g )
    {
        //
        Color table = new Color(74, 179, 0);
        String title = "casino boyyyzzzz";
        g.setColor(table);
        g.fillRect(0,0,10000,10000);

        g.drawImage(Cards,50,50,this);

        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        g.drawString(title, 400, 100);


    }

    public static void main(String[] args)throws Exception {
	    System.out.println(randomSuit());
        System.out.println(randomCard());
        int suit = randomSuit();
        int card = randomCard();
        switch (suit){
            case 1: switch(card){
                case 1: ;
                case 2: ;
                case 3: ;
                case 4: ;
                case 5: ;
                case 6: ;
                case 7: ;
                case 8: ;
                case 9: ;
                case 10: ;
                case 11: ;
                case 12: ;
                case 13: ;
            };
            case 2:switch(card){
                case 1: ;
                case 2: ;
                case 3: ;
                case 4: ;
                case 5: ;
                case 6: ;
                case 7: ;
                case 8: ;
                case 9: ;
                case 10: ;
                case 11: ;
                case 12: ;
                case 13: ;
            }; ;
            case 3:switch(card){
                case 1: ;
                case 2: ;
                case 3: ;
                case 4: ;
                case 5: ;
                case 6: ;
                case 7: ;
                case 8: ;
                case 9: ;
                case 10: ;
                case 11: ;
                case 12: ;
                case 13: ;
            }; ;
            case 4: switch(card){
                case 1: ;
                case 2: ;
                case 3: ;
                case 4: ;
                case 5: ;
                case 6: ;
                case 7: ;
                case 8: ;
                case 9: ;
                case 10: ;
                case 11: ;
                case 12: ;
                case 13: ;
            };;
        }

        JFrame win = new JFrame("casino boy");
        win.setSize(1366,745);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.add( new Main() );
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
