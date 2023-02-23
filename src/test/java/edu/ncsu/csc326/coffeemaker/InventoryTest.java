package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import static junit.framework.TestCase.assertTrue;


public class InventoryTest {

    private Inventory inventory;
    private Recipe recipe;

    // Set up
    @Before
    public void setUp() throws Exception {

        inventory = new Inventory();
        recipe = new Recipe();
        recipe.setAmtChocolate("2");
        recipe.setAmtCoffee("2");
        recipe.setAmtMilk("2");
        recipe.setAmtSugar("2");
    }

    //   Unit tests:
    @Test
    public void testGetChocolate() {

        assertEquals(15, inventory.getChocolate());
    }

    @Test
    public void testSetChocolate() {
        inventory.setChocolate(10);
        assertEquals(10, inventory.getChocolate());
    }

    @Test(expected = InventoryException.class)
    public void testAddChocolateException() throws InventoryException {
        inventory.addChocolate("-5");
    }


    @Test
    public void testAddChocolate_Normal() throws InventoryException {
        inventory.addChocolate("5");
        assertEquals(20, inventory.getChocolate());
    }

    @Test
    public void testGetCoffee() {

        assertEquals(15, inventory.getCoffee());
    }

    @Test
    public void testSetCoffee() {
        inventory.setCoffee(10);
        assertEquals(10, inventory.getCoffee());
    }

    @Test(expected = InventoryException.class)
    public void testAddCoffeeException() throws InventoryException {
        inventory.addCoffee("-5");
    }


    @Test
    public void testAddCoffee_Normal() throws InventoryException {
        inventory.addCoffee("5");
        assertEquals(20, inventory.getCoffee());
    }

    @Test
    public void testGetMilk() throws InventoryException {
        assertEquals(15, inventory.getMilk());
    }

    @Test
    public void testSetMilk() {
        inventory.setMilk(10);
        assertEquals(10, inventory.getMilk());
    }


    @Test
     (expected = InventoryException.class)
    public void testAddMilkException() throws InventoryException {
        inventory.addMilk("-5");
    }

    @Test
    public void testAddMilk_Normal() throws InventoryException {
        inventory.addMilk("5");
        assertEquals(20, inventory.getMilk());
    }

    @Test
    public void testGetSugar() {

        assertEquals(15, inventory.getSugar());
    }

    @Test
    public void testSetSugar() {
        inventory.setSugar(10);
        assertEquals(10, inventory.getSugar());
    }

    @Test(expected = InventoryException.class)   // failed test , change method to > 0 to pass it
    public void testAddSugarException() throws InventoryException {
        inventory.addSugar("-5");
    }

    @Test                                       // failed test , change method to > 0 to pass it
    public void testAddSugar_Normal() throws InventoryException {
        inventory.addSugar("5");
        assertEquals(20, inventory.getSugar());
    }

    @Test
    public void testEnoughIngredients() throws RecipeException {
        // checks if it returns true
        assertTrue(inventory.enoughIngredients(recipe));
    }
    @Test
    public void testEnoughIngredientsFalse() throws RecipeException{
        recipe.setAmtChocolate("20");
        assertFalse(inventory.enoughIngredients(recipe));
    }


    // after branch and line coverage, new added tests

    @Test
    public void testUseIngredients_EnoughIngredients() throws RecipeException {
        assertTrue(inventory.useIngredients(recipe));
        assertEquals(17, inventory.getCoffee());
        assertEquals(13, inventory.getMilk());
        assertEquals(13, inventory.getSugar());
        assertEquals(13, inventory.getChocolate());
    }
    @Test
    public void testUseIngredients_NotEnoughIngredients() throws RecipeException {
        recipe.setAmtChocolate("20");
        recipe.setAmtCoffee("20");
        recipe.setAmtMilk("20");
        recipe.setAmtSugar("20");
        assertFalse(inventory.useIngredients(recipe));
        assertEquals(15, inventory.getCoffee());
        assertEquals(15, inventory.getMilk());
        assertEquals(15, inventory.getSugar());
        assertEquals(15, inventory.getChocolate());
    }

    @Test
    public void testToString() {
        String expected = "Coffee: 15\n" +
                "Milk: 15\n" +
                "Sugar: 15\n" +
                "Chocolate: 15\n";
        assertEquals(expected, inventory.toString());
    }

    @Test
    public void testAddChocolateNotInteger() {
        try {
            inventory.addChocolate("abcd");
            fail("Expected InventoryException was not thrown");
        } catch (InventoryException e) {
            assertEquals("Units of chocolate must be a positive integer", e.getMessage());
        }
        assertEquals(15, inventory.getChocolate());
    }


    @Test
    public void testAddCoffeeNotInteger() {
        // Test if not a positive integer is passed
        try {
            inventory.addCoffee("abcd");
            fail("Expected InventoryException was not thrown");
        } catch (InventoryException e) {
            assertEquals("Units of coffee must be a positive integer", e.getMessage());
        }
        assertEquals(15, inventory.getCoffee());
    }

    @Test
    public void testAddSugarNotInteger() {
        // Test if not a positive integer is passed
        try {
            inventory.addSugar("abcd");
            fail("Expected InventoryException was not thrown");
        } catch (InventoryException e) {
            assertEquals("Units of sugar must be a positive integer", e.getMessage());
        }
        assertEquals(15, inventory.getSugar());
    }

    @Test
    public void testAddMilkNotInteger() {
        // Test if not a positive integer is passed
        try {
            inventory.addMilk("abcd");
            fail("Expected InventoryException was not thrown");
        } catch (InventoryException e) {
            assertEquals("Units of milk must be a positive integer", e.getMessage());
        }
        assertEquals(15, inventory.getMilk());
    }

}

