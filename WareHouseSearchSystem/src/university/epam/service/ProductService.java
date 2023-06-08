package university.epam.service;

import university.epam.entity.Product;

import java.util.List;

public interface ProductService {

    Product getById(int id);

    List<Product> getProductsByCategory(String category);

    Product getByName(String name);

    List<Product> getAll();
}
