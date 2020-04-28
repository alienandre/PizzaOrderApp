package sample;

import java.util.ArrayList;

public class Deluxe extends Pizza {
    private int smallPrice = 14;
    private int medPrice = smallPrice + 2;
    private int largePrice = smallPrice + 4;
    private ArrayList<String> toppings;

    public Deluxe(String style, String size, ArrayList<String> toppings){
        super(style, size, toppings);
    }

    @Override
    public int pizzaPrice() {
        int price;
        if(size.equals("Small")){
            return smallPrice;
        }
        else if(size.equals("Medium")){
            return medPrice;
        }
        else if(size.equals("Large")){
            return largePrice;
        }
        return -1;
    }
}
