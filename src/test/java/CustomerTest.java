import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    private Store store = null;
    private Customer sut = null;

    @Test
    @DisplayName("Purchase succeeds if inventory is more than purchased qty")
    public void purchaseSucceedsIfInventoryIsMoreThanQty(){
        //Arrange
        store = new Store();
        sut = new Customer();
        store.addInventory(Product.BEER, 10);
        //Act
        sut.purchase(store, Product.BEER, 5);
        //Assert
        Assertions.assertEquals(5, store.getInventory(Product.BEER));
    }

    @Test
    @DisplayName("Purchase succeeds if inventory is equal to quantity")
    public void purchaseSucceedsWhenInventoryIsEqualToQuantity(){
        //Arrange
        store = new Store();
        sut = new Customer();
        store.addInventory(Product.SHAMPOO, 10);
        //Act
        boolean result = sut.purchase(store, Product.SHAMPOO, 10);
        //Assert
        Assertions.assertEquals(true, result);
    }

    @Test
    @DisplayName("Purchase fails if inventory is less than quantity")
    public void purchaseFailsIfInventoryIsLessThanQuantity(){
        //Arrange
        store = new Store();
        sut = new Customer();
        store.addInventory(Product.SHAMPOO, 10);
        //Act
        boolean result = sut.purchase(store, Product.SHAMPOO, 20);
        //Assert
       Assertions.assertEquals(false, result);
    }

    @Test
    @DisplayName("Purchase fails when product not available")
    public void purchaseFailsIfProductNotAvailable(){
        //Arrange
        store = new Store(); //The store if fixture. Something with fixed state
        sut = new Customer();
        //Act
        boolean result = sut.purchase(store, Product.SHAMPOO, 20);
        //Assert
        Assertions.assertEquals(false, result);
    }


}
