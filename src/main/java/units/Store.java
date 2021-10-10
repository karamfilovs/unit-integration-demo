package units;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private Map<Product, Integer> inventory = new HashMap<>();

    public int getInventory(Product product){
        if(inventory.get(product) == null){
            return 0;
        }
       return inventory.get(product);
    }

    public boolean removeInventory(Product product, int quantity) {
        if(inventory.get(product) == null){ //if trying to remove inventory for non-existing product
            return false;
        }
        if(inventory.get(product) >= quantity){ //If current inventory is sufficient
            System.out.println("Removing:" + product + "|" + quantity );
            inventory.put(product, inventory.get(product) - quantity);
            System.out.println("Inventory:" + product + "|" + inventory.get(product));
            return true;
        } else { //if not sufficient inventory
            return false;
        }

    }

    public void addInventory(Product product, int quantity){
        System.out.println("Adding:" + product + "|" + quantity );
        if(inventory.get(product) == null){ //if it's null, just put it in map
            inventory.put(product, quantity);
        } else {
            inventory.put(product, inventory.get(product) + quantity); //Increase current inventory with qty
        }
        System.out.println("Inventory:" + product + "|" + inventory.get(product)); //print current inventory

    }





}
