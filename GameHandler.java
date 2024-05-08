
import java.util.*;

class GameHandler {

    Category[] categories;
    Category[] table = new Category[4];
    int attempts;

    public GameHandler() {
        this.categories = new Category[20];
        this.attempts = 4;
    }

    public void fillCategories() {
        this.categories[0] = new Category("NBA", new String[]{"lebron", "curry", "kobe", "shaq"});
        this.categories[1] = new Category("animals", new String[]{"dog", "cat", "bird", "fish"});
        this.categories[2] = new Category("fruits", new String[]{"apple", "banana", "orange", "grape"});
        this.categories[3] = new Category("colors", new String[]{"red", "blue", "green", "yellow"});
        this.categories[4] = new Category("countries", new String[]{"usa", "canada", "mexico", "brazil"});
        this.categories[5] = new Category("cities", new String[]{"newyork", "losangeles", "chicago", "miami"});
        this.categories[6] = new Category("planets", new String[]{"earth", "mars", "venus", "jupiter"});
        this.categories[7] = new Category("languages", new String[]{"english", "spanish", "french", "chinese"});
        this.categories[8] = new Category("shapes", new String[]{"circle", "square", "triangle", "rectangle"});
        this.categories[9] = new Category("school subjects", new String[]{"math", "science", "history", "english"});
        this.categories[10] = new Category("musical instruments", new String[]{"guitar", "piano", "drums", "violin"});
        this.categories[11] = new Category("desserts", new String[]{"cake", "ice cream", "pie", "cookies"});
        this.categories[12] = new Category("vegetables", new String[]{"carrot", "broccoli", "lettuce", "tomato"});
        this.categories[13] = new Category("clothing", new String[]{"shirt", "pants", "shoes", "hat"});
        this.categories[14] = new Category("weather", new String[]{"sunny", "rainy", "cloudy", "snowy"});
        this.categories[15] = new Category("months", new String[]{"january", "february", "march", "april"});
        this.categories[16] = new Category("days of the week", new String[]{"monday", "tuesday", "wednesday", "thursday"});
        this.categories[17] = new Category("seasons", new String[]{"spring", "summer", "fall", "winter"});
        this.categories[18] = new Category("holidays", new String[]{"christmas", "halloween", "thanksgiving", "easter"});
        this.categories[19] = new Category("sports", new String[]{"football", "basketball", "soccer", "baseball"});
    }

    public void makeTable() {
        ArrayList<Category> selectedCategories = new ArrayList<>();
        while (selectedCategories.size() < 4) {
            Category randomCategory = categories[(int) (Math.random() * categories.length)];
            if (!selectedCategories.contains(randomCategory)) {
                selectedCategories.add(randomCategory);
            }
        }
        this.table = selectedCategories.toArray(new Category[0]);

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
        int numRows = table[0].values.length;
        for (int i = 0; i < numRows; i++) {
            for (Category category : table) {
                System.out.printf("%-" + (calculateMaxWidth(table) + 2) + "s", allValues.remove(0));
            }
            System.out.println();
        }
    }

// Helper method to calculate the maximum width of all values in the table
    private int calculateMaxWidth(Category[] table) {
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
        for (int j = 0; j < table.length; j++) {
            for (int k = 0; k < guessArray.length; k++) {
                for (int i = 0; i < table[j].values.length; i++) {
                    if (guessArray[k].equals(table[j].values[i])) {
                        correct++; 
                    }
                }
            }
            if (correct == 4) {
                return "You guessed the " + table[j].category + " category correctly";
                
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
