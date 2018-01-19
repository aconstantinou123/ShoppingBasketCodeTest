package Discounts;

import Items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Bogof implements IDiscount {


    public ArrayList<Item> applyDiscount(ArrayList<Item> items) {
        ArrayList<String> uniqueItems = new ArrayList<>();
        int bogofCounter = 0;
        for (Item item : items) {
            if (!uniqueItems.contains(item.getName())) {
                uniqueItems.add(item.getName());
            }
        }
        for (String item : uniqueItems) {
            String itemToCompare = item;
            for (Item item1 : items) {
                if (itemToCompare.equals(item1.getName())) {
                    bogofCounter += 1;
                }
                if (bogofCounter == 2) {
                    item1.setPrice(0);
                    bogofCounter = 0;
                }
            }
            bogofCounter = 0;
        }
        return items;
    }


}