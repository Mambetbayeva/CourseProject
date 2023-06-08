package university.epam.util;

import university.epam.entity.Product;

public final class ProductUtil {

    public static int idCounter = 1;

    public static boolean isDigitGreaterThanZero(int digit){
        return digit > 0;
    }

    public static boolean isStringNotEmptyAndNotBlank(String string){
        return !string.isEmpty() && !string.isBlank();
    }

    public static boolean isValidProduct(Product product) {

        return isDigitGreaterThanZero(product.getId()) &&
                isStringNotEmptyAndNotBlank(product.getName()) &&
                isStringNotEmptyAndNotBlank(product.getCategory()) &&
                isDigitGreaterThanZero(product.getPrice()) &&
                isDigitGreaterThanZero(product.getAmount());
    }
}
