
import java.util.*;

class Game {

    public static void main(String[] args) {
        System.out.println("\n\nWelcome to Neemah's Connections game! "
                + "You have been given 16 words and your goal is to group the words into 4 groups of categories"
                + " that have a relationship with each other. You have 4 attempts to guess the correct categories. "
                + "Enter each word followed by a space (not case sensistive) Good luck!\n");
        System.out.println("Here are the words: \n");
        GameHandler gameHandler = new GameHandler(); //creates a new instance of the GameHandler class

        gameHandler.fillCategories(); //calls the fillCategories method to fill the categories with words
        gameHandler.makeTable();    //calls the makeTable method to select 4 random categories and assign them to the table
        

        while (gameHandler.attempts > 0 && gameHandler.table.size() > 0){ //while the user has attempts left and there are still categories left in the table
            gameHandler.printTable(); //prints the table
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nEnter your guess for the categories: ");
            String guess = scanner.nextLine();
            String[] guessArray = guess.split(" "); //converts the user's guess into an array of strings
            System.out.println("\nYour guess: " + Arrays.toString(guessArray));
            System.out.println(gameHandler.check(guessArray)); //calls the check method to check if the user's guess is correct
        }

}
}
