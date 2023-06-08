package university.epam.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import university.epam.entity.Product;
import university.epam.service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductControllerTest {

    private ProductController productController;

    @BeforeEach
    public void setup() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", "Electronics", 1000, 5));
        products.add(new Product(2, "Smartphone", "Electronics", 800, 10));
        ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
        productController = new ProductController(productServiceImpl);
    }

    @Test
    public void testGetProductByCategory() {
        String category = "Electronics";
        String result = productController.getProductByCategory(category);

        String expected = """
                ID NAME CATEGORY PRICE AMOUNT
                1 Laptop Electronics 1000 5
                2 Smartphone Electronics 800 10
                """;

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetProductByName() {
        String name = "Laptop";
        String result = productController.getProductByName(name);

        String expected = "ID NAME CATEGORY PRICE AMOUNT\n" +
                "1 Laptop Electronics 1000 5";

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetProductById() {
        int id = 1;
        String result = productController.getProductById(id);

        String expected = "ID NAME CATEGORY PRICE AMOUNT\n" +
                "1 Laptop Electronics 1000 5";

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetAllProducts_SortById() {
        String result = productController.getAllProducts(1);

        String expected = """
                ID NAME CATEGORY PRICE AMOUNT
                1 Laptop Electronics 1000 5
                2 Smartphone Electronics 800 10
                """;

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetAllProducts_SortByName() {
        String result = productController.getAllProducts(2);

        String expected = """
                ID NAME CATEGORY PRICE AMOUNT
                1 Laptop Electronics 1000 5
                2 Smartphone Electronics 800 10
                """;

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetAllProducts_SortByCategory() {
        String result = productController.getAllProducts(3);

        String expected = """
                ID NAME CATEGORY PRICE AMOUNT
                1 Laptop Electronics 1000 5
                2 Smartphone Electronics 800 10
                """;

        Assertions.assertEquals(expected, result);
    }
}
