package edu.ncsu.csc326.coffeemaker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

public class RecipeBookTest {

    private RecipeBook recipeBook;
    private Recipe recipe;
    @Before
    public void setUp() throws Exception {

        recipeBook = new RecipeBook();
        // Set up a recipe to be used in testing
        recipe = new Recipe();
        recipe.setName("ChocoLatte");
        recipe.setAmtChocolate("1");
        recipe.setAmtCoffee("2");
        recipe.setAmtMilk("2");
        recipe.setAmtSugar("1");
        recipe.setPrice("30");

    // Add recipe to the recipe book
        recipeBook.addRecipe(recipe);
}
    @Test
    public void testDeleteRecipe_Normal() {
        String recipeName = recipeBook.deleteRecipe(0);
        // The name of the deleted recipe should be "ChocoLatte"
        assertEquals("ChocoLatte", recipeName);
        // The recipe at index 0 should now be null
        assertNull(recipeBook.getRecipes()[0]);

    }

    @Test
    public void testDeleteRecipeException() {
        // delete a recipe at an index that doesn't exist in recipe book
        String deletedRecipe = recipeBook.deleteRecipe(0);
        // name of the deleted recipe is null
        assertNull(deletedRecipe);
        // The recipe book should remain the same
        assertTrue(recipeBook.getRecipes()[0].equals(recipe));
    }
}
