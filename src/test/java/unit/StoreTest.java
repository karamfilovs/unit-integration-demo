package unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import units.Product;
import units.Store;

public class StoreTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) //Parameters
    public void addingProductWithValidQuantitySucceeds(int quantity){
        //Arrange
        Store sut = new Store(); //SUT(System Under Test)
        //Act
        sut.addInventory(Product.BREAD, quantity);
        //Assert
        Assertions.assertEquals(quantity, sut.getInventory(Product.BREAD), "units.Product inventory is incorrect!");
    }

    @ParameterizedTest
    @EnumSource(Product.class) //Passing all products from the product list
    public void addingValidProductSucceeds(Product product){
        //Arrange
        Store sut = new Store(); //SUT(System Under Test)
        //Act
        sut.addInventory(product, 1);
        //Assert
        Assertions.assertEquals(1, sut.getInventory(product), "units.Product inventory is incorrect!");
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
        Assertions.assertTrue(success);
    }

    @Test
    public void removingInventoryFailsIfInventoryIsExceeded(){
        //Arrange
        Store sut = new Store();
        sut.addInventory(Product.APPLES, 10);
        //Act
        boolean success = sut.removeInventory(Product.APPLES, 20);
        Assertions.assertFalse(success);
    }


}
