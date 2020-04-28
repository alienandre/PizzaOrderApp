/**

 @author Brian Tran
 @author Allen Andrews
 */
package sample;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class pizzaPriceTest {

    @Test
    void test() {
        ArrayList<String> toppings=new ArrayList<String>();

        //Testing Small Pizza with 1 topping (Mushroom) for price of $7
        toppings.add("Mushroom");
        BuildYourOwn test = new BuildYourOwn("Build Your Own", "Small", toppings);
        int price = test.pizzaPrice();
        assertEquals(7, price);

        //Testing Small Pizza with 2 toppings (Mushroom, Pepperoni) for price of $9
        toppings.add("Pepperoni");
        test = new BuildYourOwn("Build Your Own", "Small", toppings);
        price = test.pizzaPrice();
        assertEquals(9, price);

        //Testing Small Pizza with 6 toppings (Mushroom, Pepperoni, Sausage, Ham, Pineapple, Onion) for price of $17
        toppings.add("Sausage");
        toppings.add("Ham");
        toppings.add("Pineapple");
        toppings.add("Onion");
        test = new BuildYourOwn("Build Your Own", "Small", toppings);
        price = test.pizzaPrice();
        assertEquals(17, price);

        //Testing Medium Pizza with 1 topping (Mushroom) for price of $9
        toppings.clear();
        toppings.add("Mushroom");
        test = new BuildYourOwn("Build Your Own", "Medium", toppings);
        price = test.pizzaPrice();
        assertEquals(9, price);

        //Testing Medium Pizza with 2 toppings (Mushroom, Pepperoni) for price of $11
        toppings.add("Pepperoni");
        test = new BuildYourOwn("Build Your Own", "Medium", toppings);
        price = test.pizzaPrice();
        assertEquals(11, price);

        //Testing Medium Pizza with 6 toppings (Mushroom, Pepperoni, Sausage, Ham, Pineapple, Onion) for price of $19
        toppings.add("Sausage");
        toppings.add("Ham");
        toppings.add("Pineapple");
        toppings.add("Onion");
        test = new BuildYourOwn("Build Your Own", "Medium", toppings);
        price = test.pizzaPrice();
        assertEquals(19, price);

        //Testing Large Pizza with 1 topping (Mushroom) for price of $11
        toppings.clear();
        toppings.add("Mushroom");
        test = new BuildYourOwn("Build Your Own", "Large", toppings);
        price = test.pizzaPrice();
        assertEquals(11, price);

        //Testing Large Pizza with 2 toppings (Mushroom, Pepperoni) for price of $13
        toppings.add("Pepperoni");
        test = new BuildYourOwn("Build Your Own", "Large", toppings);
        price = test.pizzaPrice();
        assertEquals(13, price);

        //Testing Large Pizza with 6 toppings (Mushroom, Pepperoni, Sausage, Ham, Pineapple, Onion) for price of $21
        toppings.add("Sausage");
        toppings.add("Ham");
        toppings.add("Pineapple");
        toppings.add("Onion");
        test = new BuildYourOwn("Build Your Own", "Large", toppings);
        price = test.pizzaPrice();
        assertEquals(21, price);

        //Testing with empty string for size with expected output of -1
        test = new BuildYourOwn("Build Your Own", "", toppings);
        price = test.pizzaPrice();
        assertEquals(-1, price);
    }

}
