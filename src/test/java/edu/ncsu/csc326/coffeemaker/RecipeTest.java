package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeTest {
    private Recipe newRecipe;
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;

    @Before
    public void setUp() throws RecipeException {
        newRecipe = new Recipe();
        newRecipe.setName("Coffee");
        newRecipe.setAmtChocolate("1");
        newRecipe.setAmtCoffee("3");
        newRecipe.setAmtMilk("1");
        newRecipe.setAmtSugar("1");
        newRecipe.setPrice("50");

        recipe1 = new Recipe();
        recipe1.setName("Hot Chocolate");
        recipe1.setAmtChocolate("1");
        recipe1.setAmtCoffee("3");
        recipe1.setAmtMilk("3");
        recipe1.setAmtSugar("2");
        recipe1.setPrice("90");

        recipe2 = new Recipe();
        recipe2.setName("Milk Shake");
        recipe2.setAmtChocolate("1");
        recipe2.setAmtCoffee("7");
        recipe2.setAmtMilk("1");
        recipe2.setAmtSugar("5");
        recipe2.setPrice("50");


    }

    @Test
    public void testGetAmtChocolate() {
        assertEquals(1, newRecipe.getAmtChocolate());
    }

    @Test
    public void testSetAmtChocolate() {
        try {
            newRecipe.setAmtChocolate("1");
            assertEquals(1, newRecipe.getAmtChocolate());
        } catch (RecipeException e) {
            fail("RecipeException shouldn't be thrown!");
        }
        try {
            newRecipe.setAmtChocolate("-2");
            fail("Expected exception not thrown!");
        } catch (RecipeException e) {
            assertEquals("Units of chocolate must be a positive integer", e.getMessage());
        }
        try {
            newRecipe.setAmtChocolate("ABC");
            fail("Expected exception not thrown!");
        }catch(RecipeException e) {
            assertEquals("Units of chocolate must be a positive integer", e.getMessage());
        }
    }

    @Test
    public void testGetAmtCoffee() {
        int expectedAmt = 3;
        int actualAmt = newRecipe.getAmtCoffee();
        assertEquals(expectedAmt,actualAmt);
    }

    @Test
    public void testSetAmtCoffee() {
        try {
            newRecipe.setAmtCoffee("3");
            assertEquals(3, newRecipe.getAmtCoffee());
        } catch (RecipeException e) {
            fail("RecipeException shouldn't be thrown!");
        }
        try {
            newRecipe.setAmtCoffee("-2");
            fail("Expected exception not thrown!");
        } catch (RecipeException e) {
            assertEquals("Units of coffee must be a positive integer", e.getMessage());
        }
        try {
            newRecipe.setAmtCoffee("ABC");
            fail("Expected exception not thrown!");
        }catch(RecipeException e) {
            assertEquals("Units of coffee must be a positive integer", e.getMessage());
        }
    }

    @Test
    // public void testGetAmtMilk() {
    // assertEquals(1, newRecipe.getAmtMilk());
    // }
    public void testGetAmtMilk() {
        int expectedAmt = 1;
        int actualAmt = newRecipe.getAmtMilk();
        assertEquals(expectedAmt,actualAmt);
    }
    @Test
    public void testSetAmtMilk() {
        try {
            newRecipe.setAmtMilk("3");
            assertEquals(3, newRecipe.getAmtMilk());
        } catch (RecipeException e) {
            fail("RecipeException shouldn't be thrown!");
        }
        try {
            newRecipe.setAmtMilk("-2");
            fail("Expected exception not thrown!");
        } catch (RecipeException e) {
            assertEquals("Units of milk must be a positive integer", e.getMessage());
        }
        try {
            newRecipe.setAmtMilk("ABC");
            fail("Expected exception not thrown!");
        }catch(RecipeException e) {
            assertEquals("Units of milk must be a positive integer", e.getMessage());
        }
    }

    @Test
    // public void testGetSugar() {
    // assertEquals(1, newRecipe.getAmtSugar());
    //}
    public void testGetAmtSugar() {
        int expectedAmt = 1;
        int actualAmt = newRecipe.getAmtSugar();
        assertEquals(expectedAmt,actualAmt);
    }

    @Test
    public void testSetAmtSugar() {
        try {
            newRecipe.setAmtSugar("3");
            assertEquals(3, newRecipe.getAmtSugar());
        } catch (RecipeException e) {
            fail("RecipeException shouldn't be thrown!");
        }
        try {
            newRecipe.setAmtSugar("-2");
            fail("Expected exception not thrown!");
        } catch (RecipeException e) {
            assertEquals("Units of sugar must be a positive integer", e.getMessage());
        }
        try {
            newRecipe.setAmtSugar("ABC");
            fail("Expected exception not thrown!");
        }catch(RecipeException e) {
            assertEquals("Units of sugar must be a positive integer", e.getMessage());
        }
    }

    @Test
    // public void testGetName() {
    // assertEquals("Coffee", newRecipe.getName());
    //}
    public void testGetName() {
        String expected = "Coffee";
        String actual = newRecipe.getName();
        assertEquals(expected,actual);
    }

    @Test
    public void testSetName() {
        try {
            newRecipe.setName("Hot chocolate");
            assertEquals("Hot chocolate", newRecipe.getName());
        } catch (RecipeException e) {
            fail("RecipeException shouldn't be thrown!");
        }
        try {
            newRecipe.setName(null);
            fail("Expected exception not thrown!");
        } catch (RecipeException e) {
            assertEquals("Name cannot be null", e.getMessage());
        }
    }

    @Test
    // public void testGetPrice() {
    // assertEquals(50, newRecipe.getPrice());
    //}
    public void testGetPrice() {
        int expectedAmt = 50;
        int actualAmt = newRecipe.getPrice();
        assertEquals(expectedAmt,actualAmt);
    }

    @Test
    public void testSetPrice() {
        try {
            newRecipe.setPrice("40");
            assertEquals(40, newRecipe.getPrice());
        } catch (RecipeException e) {
            fail("RecipeException shouldn't be thrown!");
        }
        try {
            newRecipe.setPrice("-40");
            fail("Expected exception not thrown!");
        } catch (RecipeException e) {
            assertEquals("Price must be a positive integer", e.getMessage());
        }
        try {
            newRecipe.setPrice("ABC");
            fail("Expected exception not thrown!");
        }catch(RecipeException e) {
            assertEquals("Price must be a positive integer", e.getMessage());
        }
    }
    @Test
    public void testToString() throws RecipeException {
        Recipe recipe1 = new Recipe();
        recipe1.setName("Hot Chocolate");
        String expected = "Hot Chocolate";
        String actual = recipe1.toString();
        assertEquals(expected, actual);
    }
    @Test
    public void testHashCode() throws RecipeException {
        recipe1.setName("Vanilla cake");
        recipe2.setName("Vanilla cake");
        //newRecipe.setName("Milk shake");
        assertEquals(recipe1.hashCode(), recipe2.hashCode());
        // assertNotEquals(recipe1.hashCode(), newRecipe.hashCode());
    }
    @Test
    public void testEquals_NullComparison() {
        Recipe r1 = new Recipe();

        boolean check = r1.equals(null);

        assertFalse(check);
    }

    @Test
    public void testEquals_OtherClassComparison() {
        Recipe r1 = new Recipe();
        RecipeBook cm = new RecipeBook();

        boolean check = r1.equals(cm);

        assertFalse(check);
    }

    @Test
    public void testEquals_SameObjReference() {
        Recipe r1 = new Recipe();
        Recipe r2 = r1;

        boolean check = r1.equals(r2);

        assertTrue(check);
    }

    @Test
    public void testEquals_SameObj() {
        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe();

        boolean check = r1.equals(r2);

        assertTrue(check);
    }

    @Test
    public void testEquals_DiffName() throws RecipeException {
        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe();

        r2.setName("Cookie");

        boolean check = r1.equals(r2);

        assertFalse(check);
    }
}



