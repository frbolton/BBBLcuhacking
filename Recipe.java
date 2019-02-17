package BBBLcuhacking;

public class Recipe{

    private String name;
    private Ingredient[] ingredients;
    private int calories;
    private int canMakeScore = 0;
    private Ingredient[] ingredientsAreInPantry = new Ingredient[0];

    private String[] tags = new String[0];

    // CONSTRUCTORS

    public Recipe(String name, Ingredient[] ings, int cal){
        this.name = name;
        this.ingredients = ings;
        if (cal<0){
            cal = 0;
        }
        this.calories = cal;
    }
    public Recipe(String name, int cal, Ingredient[] ings){
        this.name = name;
        this.ingredients = ings;
        if (cal<0){
            cal = 0;
        }
        this.calories = cal;
    }

    // SETTERS

    public void addIngredientIsInPantry(Ingredient ingredient){
        Ingredient[] newIngredientsAreInPantry = new Ingredient[this.ingredientsAreInPantry.length+1];
        for(int i=0; i < this.ingredientsAreInPantry.length; i+=1){
            newIngredientsAreInPantry[i] = this.ingredientsAreInPantry[i];
        }
        newIngredientsAreInPantry[newIngredientsAreInPantry.length-1] = ingredient;
        this.ingredientsAreInPantry = newIngredientsAreInPantry;
    }

    public void resetIngredientsAreInPantry(){
        this.ingredientsAreInPantry = new Ingredient[0];
    }

    public Recipe setName(String name){
        this.name = name;
        return this;
    }

    public Recipe addTag(String tag){
        if (tag.length()==0){
            return this;
        }
        String[] temp = new String[this.tags.length+1];
        for (int i = 0; i<this.tags.length; i++){
            temp[i] = this.tags[i];
        }
        temp[temp.length-1] = tag;
        this.tags = temp;
        return this;
    }

    public Recipe setTags(String[] tags){
        this.tags = tags;
        return this;
    }

    public Recipe setCalories(int cal){
        if (cal<0){
            this.calories = 0;
            return this;
        }
        this.calories = cal;
        return this;
    }

    public Recipe setCanMakeScore(int score){
        this.canMakeScore = score;
        return this;
    }

    public Recipe addIngredient(Ingredient ing){
        Ingredient[] temp = new Ingredient[this.ingredients.length-1];
        for (int i = 0; i<this.ingredients.length; i++){
            temp[i] = this.ingredients[i];
        }
        temp[temp.length-1] = ing;
        this.ingredients = temp;
        return this;
    }

    public Recipe setIngredients(Ingredient[] ings){
        this.ingredients = ings;
        return this;
    }

    // GETTERS

    public String getName(){
        return this.name;
    }

    public Ingredient[] getIngredients(){
        return this.ingredients;
    }

    public int getCalories(){
        return this.calories;
    }

    public String[] getTags(){
        return this.tags;
    }

    public int getCanMakeScore(){
        return this.canMakeScore;
    }

    public Ingredient[] getIngredientsAreInPantry(){
        return ingredientsAreInPantry;
    }
}