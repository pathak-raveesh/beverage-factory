package com.tavisca.testapp;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void calculatePriceTest() throws InvalidInputException{
        App teviscaTestApp = new App();
        assertEquals(teviscaTestApp.calculatePrice("Chai"),4,0);
        assertEquals(teviscaTestApp.calculatePrice("Chai,-sugar"),3.5,0);
        assertEquals(teviscaTestApp.calculatePrice("Chai,-sugar,-water"),3,0);
    }

    @Test
    public void emptyInputcalculatePriceTest() throws InvalidInputException{
        exception.expect(InvalidInputException.class);
        exception.expectMessage("Null or Empty input");
        App teviscaTestApp = new App();
        teviscaTestApp.calculatePrice("");
    }

    @Test
    public void nullInputcalculatePriceTest() throws InvalidInputException{
        exception.expect(InvalidInputException.class);
        exception.expectMessage("Null or Empty input");
        App teviscaTestApp = new App();
        teviscaTestApp.calculatePrice(null);
    }

    @Test
    public void nonExitingMenuInputcalculatePriceTest() throws InvalidInputException{
        exception.expect(InvalidInputException.class);
        exception.expectMessage("No Menu Item Found Invalid Input:ABC");
        App teviscaTestApp = new App();
        teviscaTestApp.calculatePrice("ABC");
    }

    @Test
    public void invalidMenuWithIngredientInputcalculatePriceTest() throws InvalidInputException{
        exception.expect(InvalidInputException.class);
        exception.expectMessage("No Menu Item Found Invalid Input:ABC");
        App teviscaTestApp = new App();
        teviscaTestApp.calculatePrice("ABC,-pppp");
    }

    @Test
    public void removingAllIngredientsFromMenuCalculatePriceTest() throws InvalidInputException{
        exception.expect(InvalidInputException.class);
        exception.expectMessage("You cannot remove all ingredient :Coffee,-coffee,-milk,-sugar,-water");
        App teviscaTestApp = new App();
        teviscaTestApp.calculatePrice("Coffee,-coffee,-milk,-sugar,-water");
    }

    @Test
    public void invalidIngredientsFromMenuCalculatePriceTest() throws InvalidInputException{
        exception.expect(InvalidInputException.class);
        exception.expectMessage("Ingredient:-lemon getting subtracted more than once or not a part of menu");
        App teviscaTestApp = new App();
        teviscaTestApp.calculatePrice("Coffee,-coffee,-lemon,-water");
    }
}
