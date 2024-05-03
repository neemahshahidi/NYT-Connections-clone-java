public class Group{
    
    String category;
    String word1;
    String word2;
    String word3;
    String word4;

    public Group(String category, String word1, String word2, String word3, String word4) {
        this.category = category;
        this.word1 = word1;
        this.word2 = word2; 
        this.word3 = word3;
        this.word4 = word4;
    }

    public static Group[] buildGroups(){
        Group[] allGroups = new Group[20];
        allGroups[0] = new Group("Cars", "Honda", "Toyota" , "Ford", "Ram");
        allGroups[1] = new Group("Animals","Dog", "Cat", "Bird", "Fish");
        allGroups[2] = new Group("Colors", "Blue", "Green", "Yellow", "Purple");
        allGroups[3] = new Group("Fruits", "Apple", "Banana", "Orange", "Grape");
        return allGroups;
}

}