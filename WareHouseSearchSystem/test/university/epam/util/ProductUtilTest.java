package university.epam.util;

import org.junit.jupiter.api.Test;
import university.epam.entity.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductUtilTest {

    @Test
    void isDigitGreaterThanZero() {
        boolean bool1 = ProductUtil.isDigitGreaterThanZero(-1);
        boolean bool2 = ProductUtil.isDigitGreaterThanZero(1);

        assertFalse(bool1);
        assertTrue(bool2);
    }

    @Test
    void isStringNotEmptyAndNotBlank() {
        String emptyString = "";
        String blankString = " ";
        String validString = "valid string";

        boolean bool1 = ProductUtil.isStringNotEmptyAndNotBlank(emptyString);
        boolean bool2 = ProductUtil.isStringNotEmptyAndNotBlank(blankString);
        boolean bool3 = ProductUtil.isStringNotEmptyAndNotBlank(validString);

        assertFalse(bool1);
        assertFalse(bool2);
        assertTrue(bool3);

    }

    @Test
    void isValidProduct() {
        Product product1 = new Product("", "category", 99, 9);
        Product product2 = new Product("name", "", 99, 9);
        Product product3 = new Product("name", "category", -1, 9);
        Product product4 = new Product("name", "category", 99, -1);

        boolean bool1 = ProductUtil.isValidProduct(product1);
        boolean bool2 = ProductUtil.isValidProduct(product2);
        boolean bool3 = ProductUtil.isValidProduct(product3);
        boolean bool4 = ProductUtil.isValidProduct(product4);

        assertFalse(bool1);
        assertFalse(bool2);
        assertFalse(bool3);
        assertFalse(bool4);

    }
}