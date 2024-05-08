
import java.util.*;

class Game {

    public static void main(String[] args) {
        System.out.println("Welcome to Neemah's Connections game!"
                + "You have been given 16 words and your goal is to group the words into 4 groups of categories"
                + "that have a relationship with each other. You have 4 attempts to guess the correct categories. Good luck!\n");
        System.out.println("Here are the words: \n");
        GameHandler gameHandler = new GameHandler();

        gameHandler.fillCategories();
        gameHandler.makeTable();

        while (gameHandler.attempts > 0) {
            gameHandler.printTable();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your guess for the categories: ");
            String guess = scanner.nextLine();
            String[] guessArray = guess.split(" ");
            System.out.println("Your guess: " + Arrays.toString(guessArray));
            System.out.println(gameHandler.check(guessArray));
        }

}
}
