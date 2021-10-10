package unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import units.Customer;
import units.Product;
import units.Store;

public class CustomerTest {
    private Store store = null;
    private Customer sut = null;

    @BeforeEach
    public void beforeEachTest(){
        //Arrange
        store = new Store();
        sut = new Customer();
    }

    @Test
    @DisplayName("Purchase succeeds if inventory is more than purchased qty")
    public void purchaseSucceedsIfInventoryIsMoreThanQty(){
        //Arrange
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
        store.addInventory(Product.SHAMPOO, 10);
        //Act
        boolean result = sut.purchase(store, Product.SHAMPOO, 10);
        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Purchase fails if inventory is not enough")
    public void purchaseFailsIfInventoryIsNotEnough(){
        //Arrange
        store.addInventory(Product.CUCUMBER, 10);
        //Act
        boolean result = sut.purchase(store, Product.CUCUMBER, 20);
        //Assert
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Purchase fails when product not available")
    public void purchaseFailsIfProductNotAvailable(){
        //Act
        boolean result = sut.purchase(store, Product.SHAMPOO, 20);
        //Assert
        Assertions.assertFalse(result);
    }


}
