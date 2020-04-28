/**

 @author Brian Tran
 @author Allen Andrews
 */
package sample;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza{
    private int numToppings;
    private int smallPrice = 5;
    private int medPrice = smallPrice + 2 ;
    private int largePrice = smallPrice + 4 ;
    private ArrayList<String> toppings;

    public BuildYourOwn(String style, String size, ArrayList<String> toppings){
        super(style, size, toppings);
        this.numToppings = toppings.size();
    }

    @Override
    public int pizzaPrice() {
        int price;
        if(size.equals("Small")){
            return smallPrice + (2*numToppings);
        }
        else if(size.equals("Medium")){
            return medPrice + (2*numToppings);
        }
        else if(size.equals("Large")){
            return largePrice + (2*numToppings);
        }
        return -1;
    }
}

