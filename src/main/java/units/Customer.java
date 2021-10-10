package units;

public class Customer {
    private double wallet;



    public boolean purchase(Store store, Product product, int quantity) {
        return store.removeInventory(product,  quantity);
    }


}
