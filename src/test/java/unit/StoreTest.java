package unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import units.Product;
import units.Store;

public class StoreTest {
    @Test
    public void addingProductWithValidQuantitySucceeds(){
        //Arrange
        Store sut = new Store(); //SUT(System Under Test)
        //Act
        sut.addInventory(Product.BREAD, 1);
        //Assert
        Assertions.assertEquals(1, sut.getInventory(Product.BREAD), "units.Product inventory is incorrect!");
    }

    @Test
    public void zeroInventoryIsReturnedForNonExistingProduct(){
        //Arrange
        Store sut = new Store();
        //Act
        int appleInventory = sut.getInventory(Product.APPLES);
        //Assert
        Assertions.assertEquals(0, appleInventory, "Incorrect inventory");
    }

    @Test
    public void removingInventoryForExistingProductSucceeds(){
        //Arrange
        Store sut = new Store();
        sut.addInventory(Product.BREAD, 5);
        //Act
        boolean success = sut.removeInventory(Product.BREAD, 2);
        //Assert
        Assertions.assertEquals(3, sut.getInventory(Product.BREAD));
        Assertions.assertEquals(true, success);
    }

    @Test
    public void removingInventoryFailsIfInventoryIsExceeded(){
        //Arrange
        Store sut = new Store();
        sut.addInventory(Product.APPLES, 10);
        //Act
        boolean success = sut.removeInventory(Product.APPLES, 20);
        Assertions.assertEquals(false, success);
    }


}
