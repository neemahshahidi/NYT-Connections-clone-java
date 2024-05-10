
import java.util.*;

class GameHandler {

    //declares instance variables 
    ArrayList<Category> categories; //ArrayList of type Category
    ArrayList<Category> table; //ArrayList of type Category
    int attempts; //declare integer variable attempts

    //constructor for the GameHandler class that initializes the categories, table, and attempts
    public GameHandler() {
        this.categories = new ArrayList<>();
        this.table = new ArrayList<>();
        this.attempts = 4;
    }

    //method that fills the categories ArrayList with Category objects
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
        this.categories.add(new Category("games", new String[]{"minecraft", "fortnite", "roblox", "among-us"}));
        this.categories.add(new Category("clothes", new String[]{"shirt", "pants", "shoes", "hat"}));
        this.categories.add(new Category("weather", new String[]{"sunny", "rainy", "cloudy", "snowy"}));
        this.categories.add(new Category("seasons", new String[]{"summer", "fall", "winter", "spring"}));

    }

    //method that selects 4 random categories from the categories ArrayList and assigns them to the table ArrayList
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

    //method that prints the table in a formatted way
    public void printTable() {
        // Collect all values from all categories into a single list
        ArrayList<String> allValues = new ArrayList<>();
        for (Category category : table) {  
            Collections.addAll(allValues, category.values); //iterates through the table and adds all the values(words) to the allValues list
        }

        // Shuffle the list of all values
        Collections.shuffle(allValues); //method from Collections class that shuffles the allValues Arraylist

        // Print the shuffled values in the table format
        int numRows = table.get(0).values.length;
        for (int i = 0; i < 4; i++) {
            for (Category category : table) {
                System.out.printf("%-" + (calculateMaxWidth(table) + 2) + "s", allValues.remove(0)); //prints out a formatted column of the shuffled values based on the categories left
            }
            System.out.println();
        }
    }

    //method that calculates the maximum width of the table
    private int calculateMaxWidth(ArrayList<Category> table) {
        int maxWidth = 0;
        for (Category category : table) {
            for (String value : category.values) { //iterates through the values array of each category in the table
                maxWidth = Math.max(maxWidth, value.length()); //finds the maximum length of the values to determine the max width of the table rows
            }
        }
        return maxWidth;
    }
    //method that checks if the user's guess is correct

    public String check(String[] guessArray) {
        if (guessArray.length != 4) {
            return "You must guess 4 categories. Try again.\n";
        }
        int correct = 0;
        for (int j = 0; j < table.size(); j++) { //iterates through table 
            for (int k = 0; k < guessArray.length; k++) { //iterates through the user's guess
                for (int i = 0; i < table.get(j).values.length; i++) { //iterates through the values array of each category in the table
                    if (guessArray[k].equalsIgnoreCase(table.get(j).values[i])) {   //checks if the user's guess matches any of the values in the category
                        correct++; //increments the correct variable if the user's guess matches a value in the category
                    }
                }
            }
            if (correct == 4) { //if the user's guess matches all the values in the category 
                String word = "Congrats! You guessed the " + table.get(j).category + " category correctly\n";
                table.remove(j);
                if (table.size() != 0) { //Removes the category from the table if the user guesses it correctly
                    return word + "\nRemaining words:";
                } else {
                    return word + "\nYou have guessed all the categories correctly. You win!"; //if the user guesses all the categories correctly
                }
            }
            correct = 0;

        }
        attempts--; //decrements the attempts variable if the user's guess is incorrect
        if (attempts > 0) { //if the user has more attempts left
            return "You did not guess the category correctly, you have " + attempts + " attempts left. Try again.\n";
        } else { //if the user has no more attempts left
            return "Wrong Again. You have no more attempts left. Game over! :( \n";
        }
    }
}
