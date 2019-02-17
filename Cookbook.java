package BBBLcuhacking;

public class Cookbook{

    public Cookbook(){};

    private Recipe[] recipes = new Recipe[0];

    public Recipe[] getRecipes(){
        return this.recipes;
    }

    public void readIngredients(){

    }

    public Cookbook addRecipe(Recipe recipes){
        //create new array of size+1 and add existing recipes and new recipe to it
        Recipe[] newRecipes = new Recipe[this.recipes.length + 1];
        for(int i = 0; i < newRecipes.length; i++){
            if(i == newRecipes.length - 1){ //if we're now at the last index position in the array, we add the new recipe
                newRecipes[i] = recipes;
            } 
            else{ //otherwise, we're busy adding the old recipes from recipes array
                newRecipes[i] = this.recipes[i];
            }
        }
        this.recipes = newRecipes;
        return this;
    }

    public boolean removeRecipe(String name){
        if(this.recipes.length > 0){
            int removedIndex = 0; //keep track of the index position of the removed recipe
            boolean removed = false; //keep track of whether we've successfully removed a recipe
            for(int i = 0; i < this.recipes.length; i++){ //look through every recipe
                if(this.recipes[i].getName() == name){ //if the name of the current recipe matches, we will 'target it for removal'
                    removedIndex = i;
                    removed = true;
                }
            }
            //copy array with 'removed' index into new array of appropriate size if we have found an item to remove
            if(removed == true){
                //if the removed item wasn't at the end of the list, we will rearrange our recipe array to 'mend' the break. this makes the last index contain a duplicate object.
                if(removedIndex + 1 != getRecipes().length){ //if the removed item wasn't at the end of the list, we will rearrange our recipe array to 'mend' the break. this makes the last index contain a duplicate object.
                    for(int i = removedIndex; i < recipes.length - 1; i++){
                        this.recipes[i] = this.recipes[i+1];
                    }
                }
                Recipe[] newRecipes = new Recipe[this.recipes.length-1];
                for(int i = 0; i < newRecipes.length; i++){
                    newRecipes[i] = this.recipes[i];
                }
                this.recipes = newRecipes;
                return removed;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public Cookbook sortByCalories(){
        for(int i = 0; i < recipes.length - 1; i++){
            if(recipes[i+1].getCalories()<recipes[i].getCalories()){
                int temp = recipes[i].getCalories();
                recipes[i] = recipes[i+1];
                recipes[i+1].setCalories(temp);
            }
        }
        return this;
    }

    public Recipe[] searchByTag(String tag){
        int categorySize = 0;
        int nextAvailIndex = 0;
        for(int i = 0; i < this.recipes.length; i++){
            for(int j = 0; j < this.recipes[i].getTags().length; j+=1){
                if(this.recipes[i].getTags()[j].equals(tag)){
                    categorySize +=1;
                }
            }
        }

        Recipe[] recipesWithTag = new Recipe[categorySize];

        for(int i=0; i<this.recipes.length; i+=1){
            for(int j=0; j<this.recipes[i].getTags().length; j+=1){
                if(this.recipes[i].getTags()[j].equals(tag)){
                    recipesWithTag[nextAvailIndex] = this.recipes[i];
                    nextAvailIndex+=1;
                }
            }
        }
        return recipesWithTag;
    }

    public void showRecipesNow(Pantry pantry){
    	for(int i = 0; i < this.recipes.length; i+=1){ //make sure can make score is 0 before we start computing
    		this.recipes[i].setCanMakeScore(0);
    		this.recipes[i].resetIngredientsAreInPantry();
    	}

    	int matchedRecipes = 0;
    	boolean matchedRecipe = false;
        //go through all recipes
        for(int i = 0; i < this.recipes.length; i+=1){
        	for(int j = 0; j < this.recipes[i].getIngredients().length; j+=1){
        		for(int k = 0; k < pantry.getIngredients().length; k+=1){
        			if(this.recipes[i].getIngredients()[j].getName().equals(pantry.getIngredients()[k].getName())){
        				this.recipes[i].setCanMakeScore(this.recipes[i].getCanMakeScore()+1);
        				this.recipes[i].addIngredientIsInPantry(pantry.getIngredients()[k]);
        				matchedRecipe = true;
        			}
        		}
        	}
        	if(matchedRecipe == true){
        		matchedRecipes +=1;
        	}
        }
        Recipe[] recipesWithMatchedIngredients = new Recipe[matchedRecipes];
        int nextAvailIndex = 0;
        //populate array of matched recipes
        for(int i=0; i < this.recipes.length; i+=1){
        	if(this.recipes[i].getIngredientsAreInPantry().length>0){
        		recipesWithMatchedIngredients[nextAvailIndex] = this.recipes[i];
        	}
        }

        //sort the items in array in order of matched ingredients

        for(int i=0; i < recipesWithMatchedIngredients.length; i+=1){
        	if(recipesWithMatchedIngredients[i+1].getCanMakeScore()>recipesWithMatchedIngredients[i].getCanMakeScore()){
        		Recipe temp = recipesWithMatchedIngredients[i];
        		recipesWithMatchedIngredients[i] = recipesWithMatchedIngredients[i+1];
        		recipesWithMatchedIngredients[i+1] = temp;
        	}
        }
    }
}