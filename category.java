class Category{
    String category;
    String [] values;

    public Category(String category, String [] values){ //arg constructor
        this.category = category;
        this.values = values;
    }

    public Category getCategory(){ //getter for category
        return new Category(category, values);
    }

    public void printValues() {
        System.out.println(values[0] + "\t" + values[1] + "\t" + values[2] + "\t" + values[3] + "\t");
    }


}
