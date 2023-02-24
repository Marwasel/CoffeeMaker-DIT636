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

    private Recipe r1;

    private Recipe r2;

    private Recipe r3;
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
        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("1");
        r1.setAmtSugar("1");
        r1.setPrice("50");

        r2 = new Recipe();
        r2.setName("Hot chocolate");
        r2.setAmtChocolate("1");
        r2.setAmtCoffee("5");

        r3 = new Recipe();
        r3.setName("Coffee");
        r3.setAmtChocolate("1");
        r3.setAmtCoffee("5");
        r3.setAmtMilk("2");



        @Test
        public void testGetRecipes() {
            Recipe[] recipes = RecipeBook.getRecipes();
            assertNotNull(recipes);
            assertEquals(4, recipes.length);


            for (int i = 0; i < recipes.length; i++) {
                assertNull(recipes[i]);
            }
        }
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

    @Test
    public void addTest() throws Exception {
        assertTrue(RecipeBook.addRecipe(r2));
        assertTrue(RecipeBook.addRecipe(r1));

        try {
            RecipeBook.addRecipe(r3);
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            assertEquals("The array is already full!", e.getMessage());
        }
    }

}
