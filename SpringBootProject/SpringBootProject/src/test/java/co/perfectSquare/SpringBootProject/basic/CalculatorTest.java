package co.perfectSquare.SpringBootProject.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {

    Calculator c = new Calculator();

    @Test
    public void testSum() {

        //expected result
        int result = 5;

        // actual result
        int i = c.addNum(2, 3);

        assertEquals(result, i);

    }

}
