package BBBLcuhacking;

public class Cookbook{
	public Cookbook(){};

	private Recipe[] recipes = new Recipe[0];

	public Recipe[] getRecipes(){
		return recipes;
	}

	public void readIngredients(){

	}

	public Recipe addRecipe(Recipe recipe){
		//create new array of size+1 and add existing recipes and new recipe to it
		Recipe[] newRecipes = new Recipe[this.recipes.length+1];
		for(int i = 0; i < newRecipes.length; i+=1){
			if(i == newRecipes.length-1){ //if we're now at the last index position in the array, we add the new recipe
				newRecipes[i] = recipe;
			} else{ //otherwise, we're busy adding the old recipes from recipes array
				newRecipes[i] = this.recipes[i];
			}
		}
		this.recipes = newRecipes;
		return this;
	}

	public boolean removeRecipe(String name){
		if(this.getRecipes().length > 0){ 
			int removedIndex = 0; //keep track of the index position of the removed recipe
			boolean removed = false; //keep track of whether we've successfully removed a recipe
			for(int i = 0; i < this.getRecipes().length; i+=1){ //look through every recipe
				if(this.getRecipes()[i].getName() == name){ //if the name of the current recipe matches, we will 'target it for removal'
					removedIndex = i;
					removed = true;
				}
			}
			//copy array with 'removed' index into new array of appropriate size if we have found an item to remove
			if(removed == true){
				if(removedIndex+1 != getRecipes().length){ //if the removed item wasn't at the end of the list, we will rearrange our recipe array to 'mend' the break. this makes the last index contain a duplicate object.
					for(int i = removedIndex; i < recipes.length-1; i+=1){
						this.getRecipes()[i] = this.getRecipes()[i+1];
					}
				}
				Recipe[] newRecipes = new Recipe[this.getRecipes().length-1];
				for(int i =0; i < newRecipes.length; i+=1){
					newRecipes[i] = this.getRecipes()[i];
				}
				this.recipes = newRecipes;
				return removed;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public Recipes sortByCalories(){
		for(int i = 0; i < recipes.length-1; i+=1){
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
		for(int i = 0; i < this.recipes.length; i+=1){ //check every recipe
			for(int j=0; j < this.recipes[i].getTags().length; j+=1){ //check tags for each recipe
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

	/*public void showRecipesNow(){
		//go through all recipes
		for(Recipe recipe : recipes){
			//
		}
	}*/
}