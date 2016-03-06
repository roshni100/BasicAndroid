/**
 * Created by cehsonu on 3/3/2016.
 */
package com.cehsonu.spinner1;

public class Price {
    String getPrice(String food_item)
    {
        if(food_item.equals("Pasta"))
            return "59";
        else if(food_item.equals("Samosa"))
            return "10";
        else
            return "Plz choose";
    }
}
