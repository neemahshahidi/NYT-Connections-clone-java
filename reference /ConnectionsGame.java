import java.util.*;
public class ConnectionsGame {
    private static final String[] WORDS = {
        "Apple", "Banana", "Orange", "Grape",
        "Car", "Bicycle", "Train", "Plane",
        "Dog", "Cat", "Bird", "Fish",
        "Red", "Green", "Blue", "Yellow"
    };
    public static void main(String[] args) {
        System.out.println("Hello! - Welcome to Neemah's Connections Game");
        Scanner scanner = new Scanner(System.in);
        List<String> wordList = new ArrayList<>(Arrays.asList(WORDS));
        List<List<String>> groups = new ArrayList<>();

        System.out.println("You have 16 words. Group them into 4 groups of 4 based on their unknown connections that you must figure out.");

        // Shuffle the words
        Collections.shuffle(wordList);

        // Display the shuffled words
        System.out.println("Words:");
        for (int i = 0; i < WORDS.length; i++) {
            System.out.print(wordList.get(i) + "\t");
            if ((i + 1) % 4 == 0)
                System.out.println();
        }
    int correctGuesses = 0;
        while (groups.size() < 4) {
            System.out.print("\nEnter your guess for group " + (groups.size() + 1) + ": ");
            String guessInput = scanner.nextLine();
            String[] guessWords = guessInput.split(" ");

            if (guessWords.length != 4) {
                System.out.println("Invalid input. Please enter exactly 4 words.");
                continue;
            }

            List<String> guess = Arrays.asList(guessWords);
            if (isCorrectGuess(guess, groups, wordList)) {
                groups.add(guess);
                correctGuesses++;
                System.out.println("Correct guess! Group " + groups.size() + " eliminated.");
            } else {
                System.out.println("Incorrect guess. Try again.");
            }
        }

        System.out.println("\nCongratulations! You've successfully guessed all groups.");
        scanner.close();
    }

    // Method to check if the user's guess is correct
    private static boolean isCorrectGuess(List<String> guess, List<List<String>> groups, List<String> wordList) {
        for (List<String> group : groups) {
            if (group.containsAll(guess)) {
                return false;
            }
        }
        return wordList.containsAll(guess);
    }
}
