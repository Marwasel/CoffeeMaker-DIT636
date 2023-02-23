package edu.ncsu.csc326.coffeemaker;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;


import static junit.framework.Assert.*;
import static org.junit.Assert.assertThrows;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;



public class CoffeeMakerTest {

    //Declare our coffeeMaker currentCoffeeMaker
    private CoffeeMaker currentCoffeeMaker;

    //Declare four different recipes that we can add to the recipeBook of the coffeeMaker
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;
    private Recipe recipe4;
    private Recipe recipe5;




    @Before
    public void setUp() throws Exception {
        currentCoffeeMaker = new CoffeeMaker();


        //Set values for our first recipe
        //Set up for recipe1
        recipe1 = new Recipe();
        recipe1.setName("Black Coffee");
        recipe1.setAmtChocolate("0");
        recipe1.setAmtCoffee("3");
        recipe1.setAmtMilk("0");
        recipe1.setAmtSugar("1");
        recipe1.setPrice("25");


        //Set values for our second recipe
        //Set up for recipe2
        recipe2 = new Recipe();
        recipe2.setName("Espresso");
        recipe2.setAmtChocolate("10");
        recipe2.setAmtCoffee("3");
        recipe2.setAmtMilk("5");
        recipe2.setAmtSugar("2");
        recipe2.setPrice("50");


        //Set values for our third recipe
        //Set up for recipe3
        recipe3 = new Recipe();
        recipe3.setName("Capicinno");
        recipe3.setAmtChocolate("0");
        recipe3.setAmtCoffee("3");
        recipe3.setAmtMilk("5");
        recipe3.setAmtSugar("2");
        recipe3.setPrice("75");


        //Set values for our forth recipe
        //Set up for recipe4
        recipe4 = new Recipe();
        recipe4.setName("Hott Chocolata");
        recipe4.setAmtChocolate("4");
        recipe4.setAmtCoffee("0");
        recipe4.setAmtMilk("1");
        recipe4.setAmtSugar("1");
        recipe4.setPrice("55");

        recipe5 = new Recipe();
        recipe5.setName("Mocha");
        recipe5.setAmtChocolate("2");
        recipe5.setAmtCoffee("0");
        recipe5.setAmtMilk("2");
        recipe5.setAmtSugar("1");
        recipe5.setPrice("65");
    }

    //==================================================================================================================

    //Test if adding a recipe to the recipeBook of the coffeemaker works fine
    @Test
    public void testAddRecipe() {
        // Add the recipe to the recipe book
        boolean result1 = currentCoffeeMaker.addRecipe(recipe1);
        assertTrue(result1);

        boolean results2 = currentCoffeeMaker.addRecipe(recipe2);
        assertTrue(results2);

        Recipe recipeResult = currentCoffeeMaker.getRecipes()[0];
        assertEquals(recipe1, recipeResult);

        // Check that the recipe was added to the recipe book
        //Recipe[] recipes = currentCoffeeMaker.getRecipes();
        //assertEquals(currentCoffeeMaker., recipes[0]);

    }

    @Test
    public void testAddingSameRecipeTwice() {
        // Add recipe1 to the recipeBook
        boolean result1 = currentCoffeeMaker.addRecipe(recipe1);
        //Assert true to confirm that it was successfully added
        assertTrue(result1);

        //Try to add recipe1 again to the recipeBook then assertFalse since we expect it to fail
        //Since the function should not allow us to add the same recipe more than once
        boolean results2 = currentCoffeeMaker.addRecipe(recipe1);
        assertFalse(results2);

    }

    @Test
    public void testAddingRecipeWithMalformedValue() {

        Throwable exception = assertThrows(
                RecipeException.class, () -> {
                    Recipe recipe6;

                    recipe6 = new Recipe();
                    recipe6.setName("");
                    recipe6.setAmtChocolate("-5");
                    recipe6.setAmtCoffee("0");
                    recipe6.setAmtMilk("two");
                    recipe6.setAmtSugar("1");
                    recipe6.setPrice("65");


                    boolean result = currentCoffeeMaker.addRecipe(recipe6);
                    assertFalse(result);
                }
        );

    }

    //Test that the recipebook can only contain 4 recipes and no more
    @Test
    public void testAddingMoreThanFourRecipes() {

        boolean result1 = currentCoffeeMaker.addRecipe(recipe1);
        assertTrue(result1);

        boolean results2 = currentCoffeeMaker.addRecipe(recipe2);
        assertTrue(results2);

        boolean results3 = currentCoffeeMaker.addRecipe(recipe3);
        assertTrue(results3);

        boolean results4 = currentCoffeeMaker.addRecipe(recipe4);
        assertTrue(results4);

        boolean results5 = currentCoffeeMaker.addRecipe(recipe5);
        assertFalse(results5);
    }


    //Test if deleting a recipe in the recipeBook of the CoffeeMaker works fine
    @Test
    public void testDeleteRecipe() {
        currentCoffeeMaker.addRecipe(recipe2);

        String result = currentCoffeeMaker.deleteRecipe(0);

        assertEquals("Espresso", result);

    }



    @Test
    public void testDeletingNonExistingRecipe() {
        String result = currentCoffeeMaker.deleteRecipe(0);
        assertEquals(null, result);
    }




    //Test if editing a specific recipe in the recipeBook of the CoffeeMaker works perfect
    //Note: returns the name of the recipe edited
    @Test
    public void testEditRecipe() throws RecipeException {


        //Set values for our third recipe
        //Set up for recipe3
        recipe3 = new Recipe();
        recipe3.setName("Cappuccino");
        recipe3.setAmtChocolate("0");
        recipe3.setAmtCoffee("3");
        recipe3.setAmtMilk("5");
        recipe3.setAmtSugar("2");
        recipe3.setPrice("75");

        currentCoffeeMaker.addRecipe(recipe3);


        //Set values for our forth recipe
        //Set up for recipe4
        recipe4 = new Recipe();
        recipe4.setName("Hott Chocolata");
        recipe4.setAmtChocolate("4");
        recipe4.setAmtCoffee("0");
        recipe4.setAmtMilk("1");
        recipe4.setAmtSugar("1");
        recipe4.setPrice("55");

        String result = currentCoffeeMaker.editRecipe(0, recipe4);

        //Since editRecipe returns the name of the edited recipe instead of the name of the name recipe
        //We assert the expected with to the name of the old recipe that we removed
        assertEquals("Cappuccino", result);

        //To check if the now existing recipe in the array is the same as the new one(recipe4)
        //We get the recipe in index 0 of the array then compare it with recipe 4 by asserting equals
        Recipe recipeResult = currentCoffeeMaker.getRecipes()[0];
        assertEquals(recipe4, recipeResult);
    }

    //==================================================================================================================


    @Test
    public void testEditRecipeWithMalformedValues() {

        Throwable exception = assertThrows(
                RecipeException.class, () -> {
                    //Set values for our third recipe
                    //Set up for recipe3
                    recipe3 = new Recipe();
                    recipe3.setName("Cappuccino");
                    recipe3.setAmtChocolate("0");
                    recipe3.setAmtCoffee("3");
                    recipe3.setAmtMilk("5");
                    recipe3.setAmtSugar("2");
                    recipe3.setPrice("75");

                    currentCoffeeMaker.addRecipe(recipe3);


                    //Set values for our forth recipe
                    //Set up for recipe4
                    recipe4 = new Recipe();
                    recipe4.setName("");
                    recipe4.setAmtChocolate("4");
                    recipe4.setAmtCoffee("0");
                    recipe4.setAmtMilk("One");
                    recipe4.setAmtSugar("1");
                    recipe4.setPrice("55");

                    String result = currentCoffeeMaker.editRecipe(0, recipe4);

                    //Since editRecipe returns the name of the edited recipe instead of the name of the name recipe
                    //We assert the expected with to the name of the old recipe that we removed
                    assertEquals("Cappuccino", result);

                    //To check if the now existing recipe in the array is the same as the new one(recipe4)
                    //We get the recipe in index 0 of the array then compare it with recipe 4 by asserting equals
                    Recipe recipeResult = currentCoffeeMaker.getRecipes()[0];
                    assertEquals(recipe4, recipeResult);
                }
        );
    }


    //This test fails with the initial implementation of adding sugar since it will always throw an exception that
    //the value amount of sugar must be positive integer due to a bug in line 182 (amtSugar <= 0 instead of amtSugar >= 0)
    @Test
    public void testAddInventory() throws InventoryException {

        currentCoffeeMaker.addInventory("2","2","2","2"); //Coffee, Milk, Sugar, Chocolate

        String result = currentCoffeeMaker.checkInventory();
        String expected = "Coffee: 17\nMilk: 17\nSugar: 17\nChocolate: 17\n";
        // The expected is the value of 15(The initial in the inventory and the added value amount for each
        assertEquals(expected, result);
    }

    @Test
    public void testAddInventoryException() {
        Throwable exception = assertThrows(
                InventoryException.class, () -> {
                    currentCoffeeMaker.addInventory("four", "-6", "3", "3"); // Should throw an InventoryException
                }
        );
    }

    //Test if checking the inventory works well
    @Test
    public void testCheckInventory() {
        String result = currentCoffeeMaker.checkInventory();

        String expected = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
        assertEquals(expected, result);
    }


    //Test if MakeCoffee methods works as supposed
    @Test
    public void testMakeCoffee_Normal() {
        currentCoffeeMaker.addRecipe(recipe1); //price 25
        currentCoffeeMaker.addRecipe(recipe2); //price 50
        currentCoffeeMaker.addRecipe(recipe3); //price 75

        int result = currentCoffeeMaker.makeCoffee(2, 75);

        assertEquals(0, result);
    }


    //Test get the list of all recipes in the RecipeBook
    @Test
    public void testGetRecipes() {
        //Add two recipes to the array to get the first 2 index occupied
        currentCoffeeMaker.addRecipe(recipe3);
        currentCoffeeMaker.addRecipe(recipe4);
        currentCoffeeMaker.addRecipe(recipe5);

        //Since we added only 2 recipes, we only expect a count of 2 from the array
        int expectedCount = 3;

        //Declare an actual count of zero
        int actualCount = 0;

        //get the recipeArray with getRecipes and pass it to a new array pointer recipesResult
        Recipe[] recipesResult = currentCoffeeMaker.getRecipes();

        //Iterate through our recipesResults array and each time we find a recipe in each index
        //We increase the actual count by 1
        for (int i = 0; i < recipesResult.length; i++) {
            if (recipesResult[i] != null) {
                actualCount = actualCount + 1;
            }
        }

        //Check if the count we got is equal to the actualCount
        assertEquals(expectedCount, actualCount);
    }



    //===========================COVERAGE TESTS FOR COFFEEMAKER: MAKECOFFEE=========================================


    //Test if MakeCoffee methods works as supposed
    //last else, line 240 for successful making of coffee
    @Test
    public void testMakeCoffee() {
        currentCoffeeMaker.addRecipe(recipe1);

        int result = currentCoffeeMaker.makeCoffee(0, 75);

        assertEquals(50, result);
    }

    @Test
    public void testMakeCoffeeMalformedInput() {
        currentCoffeeMaker.addRecipe(recipe2);

        int result = currentCoffeeMaker.makeCoffee(0, -50);

        assertEquals(-50, result);
    }

    @Test
    public void testMakeCoffeeNonExistingRecipe() {
        int result = currentCoffeeMaker.makeCoffee(0, 100);
        assertEquals(100, result);
    }

    @Test
    public void testMakeCoffeeMakerInventoryLow() throws RecipeException {

        recipe3 = new Recipe();
        recipe3.setName("Cappuccino");
        recipe3.setAmtChocolate("15");
        recipe3.setAmtCoffee("15");
        recipe3.setAmtMilk("15");
        recipe3.setAmtSugar("15");
        recipe3.setPrice("75");

        recipe4 = new Recipe();
        recipe4.setName("Hott Chocolata");
        recipe4.setAmtChocolate("4");
        recipe4.setAmtCoffee("0");
        recipe4.setAmtMilk("1");
        recipe4.setAmtSugar("1");
        recipe4.setPrice("55");

        currentCoffeeMaker.addRecipe(recipe3);
        currentCoffeeMaker.addRecipe(recipe4);

        int result1 = currentCoffeeMaker.makeCoffee(0, 200);
        assertEquals(125, result1);

        int result2 = currentCoffeeMaker.makeCoffee(0, 125);
        assertEquals(125, result2);
    }

}

