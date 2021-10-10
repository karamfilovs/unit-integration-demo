package unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;
import units.Customer;
import units.Product;
import units.Store;

@ExtendWith(MockitoExtension.class)
public class MockedTest {

    @Mock
    private Store mockedStore;
    private Customer sut;

    @BeforeEach
    void setUp() {
        sut = new Customer();
    }

    @Test
    @DisplayName("Purchase succeeds when remove inventory is true")
    public void purchaseSucceedsWhenRemoveInventoryIsTrue() {
        Mockito.when(mockedStore.removeInventory(Product.APPLES, 10)).thenReturn(true);
        Assertions.assertTrue(sut.purchase(mockedStore, Product.APPLES, 10));
    }


}

