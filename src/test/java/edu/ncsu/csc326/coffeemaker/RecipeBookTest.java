package edu.ncsu.csc326.coffeemaker;

import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

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

    }

        @Test
        public void testGetRecipes() {
            Recipe[] recipes = recipeBook.getRecipes();
            assertNotNull(recipes);
            assertEquals(4, recipes.length);


            for (int i = 0; i < recipes.length; i++) {
                assertNull(recipes[i]);
            }
        }
    // Add recipe to the recipe book


    @Test
    public void testDeleteRecipe_Normal() {
        recipeBook.addRecipe(recipe);
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
    public void addRecipeTest() throws Exception {
        assertTrue(recipeBook.addRecipe(r2));
        assertTrue(recipeBook.addRecipe(r1));

        try {
            recipeBook.addRecipe(r3);
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            assertEquals("The array is already full!", e.getMessage());
        }
    }


    @Test
    public void testEditRecipe_Normal() throws RecipeException {

        recipeBook.addRecipe(r1); //r1 ==Coffee

        Recipe newRecipe;

        newRecipe = new Recipe();
        newRecipe.setName("ChocoLatte");
        newRecipe.setAmtChocolate("1");
        newRecipe.setAmtCoffee("2");
        newRecipe.setAmtMilk("2");
        newRecipe.setAmtSugar("1");
        newRecipe.setPrice("30");


        String result = recipeBook.editRecipe(0, newRecipe);

        //Since editRecipe returns the name of the edited recipe instead of the name of the name recipe
        //We assert the expected with to the name of the old recipe that we removed
        assertEquals("Coffee", result);

        Recipe recipeResult = recipeBook.getRecipes()[0];
        assertEquals(newRecipe, recipeResult);
    }


    @Test
    public void testEditRecipeWithMalformedValues() {

        Throwable exception = assertThrows(
                RecipeException.class, () -> {
                    //Set values for our third recipe
                    //Set up for recipe3
                    r1 = new Recipe();
                    r1.setName("Cappuccino");
                    r1.setAmtChocolate("0");
                    r1.setAmtCoffee("3");
                    r1.setAmtMilk("5");
                    r1.setAmtSugar("2");
                    r1.setPrice("75");

                    recipeBook.addRecipe(r1);


                    //Set values for our forth recipe
                    //Set up for recipe4
                    r2 = new Recipe();
                    r2.setName("");
                    r2.setAmtChocolate("4");
                    r2.setAmtCoffee("0");
                    r2.setAmtMilk("One");
                    r2.setAmtSugar("1");
                    r2.setPrice("55");

                    String result = recipeBook.editRecipe(0, r2);

                    //Since editRecipe returns the name of the edited recipe instead of the name of the name recipe
                    //We assert the expected with to the name of the old recipe that we removed
                    assertEquals("Cappuccino", result);

                    //To check if the now existing recipe in the array is the same as the new one(recipe4)
                    //We get the recipe in index 0 of the array then compare it with recipe 4 by asserting equals
                    Recipe recipeResult = recipeBook.getRecipes()[0];
                    assertNotEquals(r2, recipeResult);
                }
        );
    }

    @Test
    public void testEditingNonExistingRecipe() throws RecipeException {

        Recipe newRecipe;

        newRecipe = new Recipe();
        newRecipe.setName("ChocoLatte");
        newRecipe.setAmtChocolate("1");
        newRecipe.setAmtCoffee("2");
        newRecipe.setAmtMilk("2");
        newRecipe.setAmtSugar("1");
        newRecipe.setPrice("30");

        //Since we have not added any recipe to our recipe book at this point, it means therefore that its empty
        //hence if we try to edit the recipe at index 0 of the recipe array, it should be null
        String result = recipeBook.editRecipe(0, newRecipe);
        assertEquals(null, result);
    }

}
