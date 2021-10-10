import java.util.HashMap;
import java.util.Map;

public class Store {
    private Map<Product, Integer> inventory = new HashMap<>();

    public int getInventory(Product product){
       return inventory.get(product);
    }

    public boolean removeInventory(Product product, int quantity) {
        if(inventory.get(product) == null){
            return false;
        }
        int currentInventory = inventory.get(product);
        if(currentInventory >= quantity){
            System.out.println("Removing:" + product + "|" + quantity );
            inventory.put(product, currentInventory - quantity);
            System.out.println("Inventory:" + product + "|" + inventory.get(product));
            return true;
        } else {
            return false;
        }

    }

    public void addInventory(Product product, int quantity){
        System.out.println("Adding:" + product + "|" + quantity );
        if(inventory.get(product) == null){
            inventory.putIfAbsent(product, quantity);
        } else {
            int currentQuantity = inventory.get(product);
            inventory.put(product, currentQuantity + quantity);
        }
        System.out.println("Inventory:" + product + "|" + inventory.get(product));

    }





}
