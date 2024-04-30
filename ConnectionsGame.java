import java.util.*;

public class ConnectionsGame {
    private static final String[] WORDS = {
        "Apple", "Banana", "Orange", "Grape",
        "Car", "Bicycle", "Train", "Plane",
        "Dog", "Cat", "Bird", "Fish",
        "Red", "Green", "Blue", "Yellow"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> wordList = new ArrayList<>(Arrays.asList(WORDS));
        List<List<String>> groups = new ArrayList<>();

        System.out.println("Welcome to the Connections Game!");
        System.out.println("You have 16 words. Group them into 4 groups of 4 based on their connections.");

        // Shuffle the words
        Collections.shuffle(wordList);

        // Display the shuffled words
        System.out.println("Shuffled words:");
        for (int i = 0; i < WORDS.length; i++) {
            System.out.print(wordList.get(i) + "\t");
            if ((i + 1) % 4 == 0)
                System.out.println();
        }

        // Prompt the user to form groups
        for (int i = 0; i < 4; i++) {
            System.out.println("Group " + (i + 1) + ": Enter 4 words separated by spaces:");
            String input = scanner.nextLine();
            String[] words = input.split(" ");

            // Check if input is valid
            if (words.length != 4) {
                System.out.println("Invalid input. Please enter exactly 4 words.");
                i--;
                continue;
            }

            // Add the group to the list of groups
            groups.add(Arrays.asList(words));
        }

        // Display the groups
        System.out.println("\nGroups:");
        for (int i = 0; i < groups.size(); i++) {
            System.out.println("Group " + (i + 1) + ": " + groups.get(i));
        }

        scanner.close();
    }
}
