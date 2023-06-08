package university.epam.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import university.epam.entity.Product;
import university.epam.service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductServiceImplTest {

    private ProductServiceImpl productServiceImpl;
    private List<Product> products;


    @BeforeEach
    void setup(){
        products = new ArrayList<>(List.of(
                new Product(1, "WashBurn D10S", "Guitars", 299, 2),
                new Product(2, "Yamaha FG700S", "Guitars", 499, 1),
                new Product(3, "Vintage Guitar", "Guitars", 499, 7),
                new Product(4, "Fender Precision", "Basses", 799, 5),
                new Product(5, "Robin Basses", "Basses", 399, 1),
                new Product(6, "Ludwig 5-Piece Drum", "Drums", 699, 4),
                new Product(7, "Faust Harrison Pianos", "Pianos", 999, 1)
        ));
        productServiceImpl = new ProductServiceImpl(products);
    }


    @Test
    void getById_shouldReturnProductWhenFound() {

        Product expectedProduct = products.get(0);
        Product product = productServiceImpl.getById(1);

        assertEquals(expectedProduct, product);
    }

    @Test
    void getById_shouldReturnNullWhenProductNotFound() {

        int nonExistentId = 8;
        Product product = productServiceImpl.getById(nonExistentId);

        assertNull(product);
    }

    @Test
    void getById_shouldReturnNullWhenIdIsInvalid() {

        int invalidId = -1;
        Product product = productServiceImpl.getById(invalidId);

        assertNull(product);
    }


    @Test
    void getProductsByCategory_shouldReturnProductsWhenFound() {

        String category = "Guitars";
        int expectedProductsSize = 3;

        List<Product> products = productServiceImpl.getProductsByCategory(category);

        assertEquals(products.size(), expectedProductsSize);
    }

    @Test
    void getProductsByCategory_shouldReturnNullWhenProductsNotFound() {

        String nonExistentCategory = "non-existent category";
        List<Product> products = productServiceImpl.getProductsByCategory(nonExistentCategory);

        assertNull(products);
    }

    @Test
    void getProductsByCategory_shouldReturnNullWhenCategoryIsInvalid() {
        String firstInValidName = "";
        String secondInValidName2 = " ";

        List<Product> fistProduct = productServiceImpl.getProductsByCategory(firstInValidName);
        List<Product> secondProducts = productServiceImpl.getProductsByCategory(secondInValidName2);

        assertNull(fistProduct);
        assertNull(secondProducts);

    }


    @Test
    void getName_shouldReturnProductWhenFound() {
        String name = "WashBurn D10S";

        Product product = productServiceImpl.getByName(name);

        assertNotNull(product);
        assertEquals(product.getPrice(), 299);
    }

    @Test
    void getName_shouldReturnNullWhenProductNotFound() {
        String nonExistentName = "non-existent name";
        Product product = productServiceImpl.getByName(nonExistentName);

        assertNull(product);
    }

    @Test
    void getName_shouldReturnNullWhenNameIsInvalid() {
        String firstInValidName = "";
        String secondInValidName2 = " ";

        Product firstProduct = productServiceImpl.getByName(firstInValidName);
        Product secondProduct = productServiceImpl.getByName(secondInValidName2);

        assertNull(firstProduct);
        assertNull(secondProduct);

    }


    @Test
    void getAll_shouldReturnProductList(){
        List<Product> products = productServiceImpl.getAll();

        int actualSize = 7;

        assertNotNull(products);
        assertEquals(products.size(), actualSize);
    }


}