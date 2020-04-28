/**

 @author Brian Tran
 @author Allen Andrews
 */
package sample;

import java.util.ArrayList;

public abstract class Pizza {
    protected String style;
    protected String size;
    protected ArrayList<String> toppings;

    public Pizza(String style, String size, ArrayList<String> toppings) {
        this.style = style;
        this.size = size;
        this.toppings = toppings;
    }

    public Pizza(String style, String size) {
        this.style = style;
        this.size = size;
    }

    public abstract int pizzaPrice();


    public String toString() {
        String s = style + ":" + size + "\n" + "Toppings:\n";
        if (toppings != null) {
            Object[] arr = toppings.toArray();
            for (int i = 0; i < arr.length ; i++) {
                String temp = (String) arr[i];
                s = s + temp + "\n";
            }
            return s + "$" + Integer.toString(pizzaPrice()) + "\n";
        } else {
            return null;
        }
    }
}
