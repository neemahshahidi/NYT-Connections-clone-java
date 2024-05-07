import java.util.*;

class WordCategory {
    private List<String> words;

    public WordCategory(String... words) {
        this.words = new ArrayList<>(Arrays.asList(words));
    }

    public boolean contains(String word) {
        return words.contains(word.toLowerCase());
    }

    public List<String> getWords() {
        return words;
    }
}

public class Connections3 {
    static class Game {
        private WordCategory[] categories = new WordCategory[20];
        private boolean[] guessedCategories = new boolean[20];
        private int categoriesGuessed = 0;
        private List<String> allWords;
        private int remainingAttempts = 4;

        public Game() {
            categories[0] = new WordCategory("Car", "Boat", "Bike", "Plane");
            categories[1] = new WordCategory("Red", "Green", "Yellow", "Blue");
            categories[2] = new WordCategory("Raspberry", "Blueberry", "Banana", "Apple");
            categories[3] = new WordCategory("Draymond", "Lebron", "Curry", "Kobe");
            categories[4] = new WordCategory("Football", "Basketball", "Soccer", "Baseball");
            categories[5] = new WordCategory("USA", "Canada", "Mexico", "Brazil");
            categories[6] = new WordCategory("Denver", "Detroit", "Chicago", "Miami");
            categories[7] = new WordCategory("Earth", "Mars", "Venus", "Jupiter");
            categories[8] = new WordCategory("English", "Spanish", "French", "Chinese");
            categories[9] = new WordCategory("Circle", "Square", "Triangle", "Rectangle");
            categories[10] = new WordCategory("Math", "Science", "History", "English");
            categories[11] = new WordCategory("Guitar", "Piano", "Drums", "Violin");
            categories[12] = new WordCategory("Cake", "Ice Cream", "Pie", "Cookies");
            categories[13] = new WordCategory("Carrot", "Broccoli", "Lettuce", "Tomato");
            categories[14] = new WordCategory("Shirt", "Pants", "Shoes", "Hat");
            categories[15] = new WordCategory("Sunny", "Rainy", "Cloudy", "Snowy");
            categories[16] = new WordCategory("January", "February", "March", "April");
            categories[17] = new WordCategory("Monday", "Tuesday", "Wednesday", "Thursday");
            categories[18] = new WordCategory("Spring", "Summer", "Fall", "Winter");
            categories[19] = new WordCategory("Christmas", "Halloween", "Thanksgiving", "Easter");

            // Shuffle categories array
            List<WordCategory> categoryList = Arrays.asList(categories);
            Collections.shuffle(categoryList);
            categoryList.toArray(categories);

            // Select the first four categories for display
            categories = Arrays.copyOf(categories, 4);

            allWords = new ArrayList<>();
            for (WordCategory category : categories) {
                allWords.addAll(category.getWords());
            }
            Collections.shuffle(allWords);
        }

        public void displayWords() {
            Iterator<String> iterator = allWords.iterator();
            int count = 0;
            while (iterator.hasNext()) {
                System.out.print(padString(iterator.next(), 10));
                count++;
                if (count % 4 == 0) {
                    System.out.println();
                }
            }
        }

public boolean checkGuess(String[] guess) {
    if (guess.length != 4) {
        System.out.println("Invalid input! You must enter exactly four words.");
        return false;
    }

    Set<String> guessSet = new HashSet<>(Arrays.asList(guess));
    for (WordCategory category : categories) {
        List<String> categoryWords = category.getWords();
        if (guessSet.containsAll(categoryWords)) {
            int categoryIndex = Arrays.asList(categories).indexOf(category);
            if (!guessedCategories[categoryIndex]) {
                guessedCategories[categoryIndex] = true;
                categoriesGuessed++;
                if (categoriesGuessed == 4) {
                    System.out.println("Congratulations! You guessed all categories correctly!");
                    return true;
                } else {
                    System.out.println("Congratulations! You guessed the category correctly!\n");
                    System.out.println("Here are the remaining words:");
                    updateGuessedWords(guess);
                    displayWords();
                    return false;
                }
            } else {
                System.out.println("You already guessed this category. Try another one.");
                return false;
            }
        }
    }
    remainingAttempts--;
    if (remainingAttempts <= 0) {
        System.out.println("Game over! You have exceeded the maximum number of attempts.");
        System.out.println("Answers:");
        for (int i = 0; i < 4; i++) {
            System.out.println("Category " + (i + 1) + ": " + Arrays.toString(categories[i].getWords().toArray()));
        }
        return true;
    }
    System.out.println("Incorrect guess. Try again. You have " + remainingAttempts + " attempts remaining.");
    return false;
}

        private void updateGuessedWords(String[] guess) {
            for (String word : guess) {
                allWords.remove(word);
            }
        }

        private String padString(String str, int length) {
            return String.format("%-" + length + "s", str);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        System.out.println("Welcome to the game! You have 4 total attempts. Here are the words:");

        game.displayWords();

        System.out.println("\nEnter four words per guess, separated by spaces.");

        while (true) {
            System.out.print("Enter your guess (case-sensitive): ");
            String[] guess = scanner.nextLine().trim().split("\\s+");
            if (game.checkGuess(guess)) {
                break;
            }
        }

        scanner.close();
    }
}
