package unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import units.Calculator;

public class CalculatorTest {
    private Calculator sut = null;


    @BeforeEach
    public void beforeEach() {
        sut = new Calculator();
    }

    @Test
    @DisplayName("Can sum numbers")
    public void canSumNumbers() {
        //Arrange
        //Calculator sut = new Calculator();
        //Act
        double result = sut.sum(10, 20);
        //Assert
        Assertions.assertEquals(30, result, "Result is not correct");
    }

    @Test
    @DisplayName("Can divide numbers")
    public void canDivideDigits() {
        //Arrange
       // Calculator sut = new Calculator();
        //Act
        double result = sut.divide(10, 5);
        //Assert
        Assertions.assertEquals(2, result, "Result is incorrect!");
    }

    @Test
    @DisplayName("Dividing floating values by zero returns positive infinity")
    public void divisionByZeroReturnsInfinity() {
        //Arrange
       // Calculator sut = new Calculator();
        //Act
        double result = sut.divide(10, 0);
        //Assert
        Assertions.assertEquals(Double.POSITIVE_INFINITY, result, "Result is incorrect");
    }


}
