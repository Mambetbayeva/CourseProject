package university.epam.service.impl;

import university.epam.entity.Product;
import university.epam.exception.ProductNotFoundException;
import university.epam.service.ProductService;
import university.epam.util.ProductUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private final List<Product> products;

    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    // Search Product By Id
    @Override
    public Product getById(int id){

        if(!ProductUtil.isDigitGreaterThanZero(id)){
            try {
                throw new IllegalStateException("id should be greater than 0");
            } catch (IllegalStateException e){
                System.out.println(e.getMessage());
                return null;
            }
        }

        String errorMessage = String.format("product with id: %s not found", id);

        try {
            return products.stream()
                    .filter(product -> product.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new ProductNotFoundException(errorMessage));
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    // Search Products By Category
    @Override
    public List<Product> getProductsByCategory(String category){


        if(!ProductUtil.isStringNotEmptyAndNotBlank(category)){
            try {
                throw new IllegalStateException("category should not be an empty or blank");
            } catch (IllegalStateException e){
                System.out.println(e.getMessage());
                return null;
            }
        }

        String errorMessage = String.format("products with category: %s not found", category);


        List<Product> productList = products.stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());


        if(productList.size() == 0){
            try {
                throw new ProductNotFoundException(errorMessage);
            } catch (ProductNotFoundException e) {
                return null;
            }
        } else {
            return productList;
        }

    }

    // Search Product By Name
    @Override
    public Product getByName(String name){

        if(!ProductUtil.isStringNotEmptyAndNotBlank(name)){
            try {
                throw new IllegalStateException("name should not be an empty or blank");
            } catch (IllegalStateException e){
                System.out.println(e.getMessage());
                return null;
            }
        }

        String errorMessage = String.format("product with name: %s not found", name);

        try {
            return products.stream()
                    .filter(product -> product.getName().equals(name))
                    .findFirst()
                    .orElseThrow(() -> new ProductNotFoundException(errorMessage));
        } catch (ProductNotFoundException e) {
            return null;
        }

    }


    // Get All Products
    @Override
    public List<Product> getAll(){
        return products;
    }



}

