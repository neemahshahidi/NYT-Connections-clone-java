
import java.util.*;

class GameHandler {

    ArrayList<Category> categories;
    ArrayList<Category> table;
    int attempts;

    public GameHandler() {
        this.categories = new ArrayList<>();
        this.table = new ArrayList<>();
        this.attempts = 4;
    }

    public void fillCategories() {
        this.categories.add(new Category("NBA", new String[]{"lebron", "curry", "kobe", "shaq"}));
        this.categories.add(new Category("animals", new String[]{"dog", "cat", "bird", "fish"}));
        this.categories.add(new Category("fruits", new String[]{"apple", "banana", "orange", "grape"}));
        this.categories.add(new Category("colors", new String[]{"red", "blue", "green", "yellow"}));
        this.categories.add(new Category("countries", new String[]{"usa", "canada", "mexico", "brazil"}));
        this.categories.add(new Category("cities", new String[]{"new-york", "los-angeles", "chicago", "miami"}));       
        this.categories.add(new Category("cars", new String[]{"toyota", "honda", "ford", "chevy"}));
        this.categories.add(new Category("movies", new String[]{"titanic", "avatar", "inception", "joker"}));
        this.categories.add(new Category("sports", new String[]{"soccer", "basketball", "football", "baseball"}));
        this.categories.add(new Category("food", new String[]{"pizza", "burger", "pasta", "salad"}));
        this.categories.add(new Category("music", new String[]{"pop", "rock", "rap", "jazz"}));
        this.categories.add(new Category("books", new String[]{"harry-potter", "lord-of-the-rings", "game-of-thrones", "the-hobbit"}));
        this.categories.add(new Category("games", new String[]{"minecraft", "fortnite", "roblox", "among us"}));
        this.categories.add(new Category("clothes", new String[]{"shirt", "pants", "shoes", "hat"}));
        this.categories.add(new Category("weather", new String[]{"sunny", "rainy", "cloudy", "snowy"}));
        this.categories.add(new Category("seasons", new String[]{"summer", "fall", "winter", "spring"}));

    }

    public void makeTable() {
        ArrayList<Category> selectedCategories = new ArrayList<>();
        while (selectedCategories.size() < 4) {
            Category randomCategory = categories.get((int) (Math.random() * categories.size()));
            if (!selectedCategories.contains(randomCategory)) {
                selectedCategories.add(randomCategory);
            }
        }
        this.table = selectedCategories;

    }

    public void printTable() {
        // Collect all values from all categories into a single list
        ArrayList<String> allValues = new ArrayList<>();
        for (Category category : table) {
            Collections.addAll(allValues, category.values);
        }

        // Shuffle the list of all values
        Collections.shuffle(allValues);

        // Print the shuffled values in the table format
        int numRows = table.get(0).values.length;
        for (int i = 0; i < 4; i++) {
            for (Category category : table) {
                System.out.printf("%-" + (calculateMaxWidth(table) + 2) + "s", allValues.remove(0));
            }
            System.out.println();
        }
    }

// Helper method to calculate the maximum width of all values in the table
    private int calculateMaxWidth(ArrayList<Category> table) {
        int maxWidth = 0;
        for (Category category : table) {
            for (String value : category.values) {
                maxWidth = Math.max(maxWidth, value.length());
            }
        }
        return maxWidth;
    }

    public String check(String[] guessArray) {
        int correct = 0;
        for (int j = 0; j < table.size(); j++) {
            for (int k = 0; k < guessArray.length; k++) {
                for (int i = 0; i < table.get(j).values.length; i++) {
                    if (guessArray[k].equals(table.get(j).values[i])) {
                        correct++; 
                    }
                }
            }
            if (correct == 4) {
                String word = "You guessed the " + table.get(j).category + " category correctly";
                table.remove(j);
                return word;
                
            }
            correct = 0;
            
        }
        attempts--;
        if (attempts > 0) {
            return "You did not guess the category correctly, Try again";
        } else {
            return "You have no more attempts left.  game over";
        }
    }
}
