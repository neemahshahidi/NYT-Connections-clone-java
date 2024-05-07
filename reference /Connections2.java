
import java.util.*;

public class Connections2 {

    public static void main(String[] args) {
        System.out.println("Hello! - Welcome to Neemah's Connections Game");
        Scanner scanner = new Scanner(System.in);

        //creating Arraylist of display words
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange", "Grape",
                "Car", "Bicycle", "Train", "Plane",
                "Dog", "Cat", "Bird", "Fish",
                "Red", "Green", "Blue", "Yellow"));

        //creating the array's of the 4 groups
        
        String[] group1 = {"Apple", "Banana", "Orange", "Grape"};
        String[] group2 = {"Car", "Bicycle", "Train", "Plane"};
        String[] group3 = {"Dog", "Cat", "Bird", "Fish"};
        String[] group4 = {"Red", "Green", "Blue", "Yellow"};

        System.out.println("You have 16 words. Group them into 4 groups of 4 based on their unknown connections that you must figure out. Be smart though, You only have 4 guesses");

        //Shuffle the display words
        Collections.shuffle(wordList);

        System.out.println(" ");

        // Display the shuffled words
        System.out.println("Words:");
        for (int i = 0; i < wordList.size(); i++) {
            System.out.print(wordList.get(i) + "\t");
            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }
        
        System.out.println(" ");
        int guessNumber = 1;
        do { 
            System.out.println("Guess " + guessNumber + ":");
            String guess = scanner.nextLine();
            String[] guessArray = guess.split(" ");

            if (guessArray == group1 || guessArray == group2 || guessArray == group3 || guessArray == group4){
                System.out.println("Congrats you got that group right");
            } System.out.println("Try again"); 

            guessNumber++;
        } while (wordList.size() > 0 || guessNumber < 5);
        
    }
}
