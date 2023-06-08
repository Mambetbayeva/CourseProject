package university.epam.data;

import university.epam.entity.Product;

import java.util.ArrayList;
import java.util.List;

public final class ProductData {
    public static final List<Product> products = new ArrayList<>();

    static {
        products.addAll(
                List.of(
                        new Product(1, "WashBurn", "Guitars", 299, 2),
                        new Product(2, "Yamaha", "Guitars", 499, 1),
                        new Product(3, "Vintage", "Guitars", 499, 7),
                        new Product(4, "Fender", "Basses", 799, 5),
                        new Product(5, "Robin", "Basses", 399, 1),
                        new Product(6, "Ludwig", "Drums", 699, 4),
                        new Product(7, "Faust", "Pianos", 999, 1)
                )
        );
    }
}
