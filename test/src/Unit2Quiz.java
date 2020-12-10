/**
 * Diplays inheritance, polymorphism, abstraction and encapsulation.
 *
 * date         20201019
 * @filename	Unit2Quiz.java
 * @author      jtruong
 * @version     1.0
 * @see         Unit 2 Quiz Part B
 */

public class Unit2Quiz {

    public static void main(String[] args) {
        Encapsulation temp = new Encapsulation("Test", 4);
        System.out.println(temp.getName() + " " + temp.getNum());

        System.out.println();

        Animal test = new Animal();
        test.sound();

        System.out.println();

        GoldenRetriever dog = new GoldenRetriever(20, "yellow", 5);
        System.out.println(dog.height + " " + dog.color + " " + dog.tailLength);
        dog.sound();
    }
}

// Encapsulation

class Encapsulation{

    private int num;
    private String name;

    public Encapsulation(String name, int num){

        this.num = num;
        this.name = name;

    }

    public int getNum(){

        return num;

    }

    public String getName(){

        return name;

    }

}


// Polymorphism - changing the animal sound method

class Animal{

    public void sound(){

        System.out.println("The sound an animal would make.");

    }

}

// Abstraction - Taking out key features for a dog

class Dog extends Animal{

    String color;
    int height;

    public Dog(int height, String color){

        this.color = color;
        this.height = height;

    }

    public void sound(){
        System.out.println("Woof");
    }

}

// Inheritance - from the dog class

class GoldenRetriever extends Dog{

    int tailLength;

    public GoldenRetriever(int height, String color, int tailLength){

        super(height, color);
        this.tailLength = tailLength;

    }

}


