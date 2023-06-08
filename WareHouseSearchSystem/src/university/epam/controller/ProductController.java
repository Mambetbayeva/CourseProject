package university.epam.controller;

import university.epam.entity.Product;
import university.epam.service.impl.ProductServiceImpl;

import java.util.Comparator;
import java.util.List;

public class ProductController {
    private final ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    public String getProductByCategory(String category){
        List<Product> productsByCategory = productServiceImpl.getProductsByCategory(category);
        if(productsByCategory == null){
            return "";
        } else {
            return printAllProducts(productsByCategory);
        }
    }
    public String getProductByName(String name){
        Product product = productServiceImpl.getByName(name);
        if(product == null){
            return "";
        } else {
            return printProduct(product);
        }
    }
    public String getProductById(int id){
        Product product = productServiceImpl.getById(id);
        if(product == null){
            return "";
        } else {
            return printProduct(product);
        }
    }


    public String getAllProducts(int sortNumber){

        List<Product> all = productServiceImpl.getAll();
        if(all == null){
            return "";
        } else {

            if (sortNumber == 1) {
                all.sort(Comparator.comparingInt(Product::getId));
            } else if (sortNumber == 2) {
                all.sort(Comparator.comparing(Product::getName));
            } else if (sortNumber == 3) {
                all.sort((Comparator.comparing(Product::getCategory)));
            }
            return printAllProducts(all);
        }

    }


    private String printAllProducts(List<Product> products){
        StringBuilder sb = new StringBuilder();
        sb.append("ID NAME CATEGORY PRICE AMOUNT\n");
        products.forEach(
                product -> sb.append(product.getId())
                        .append(" ").append(product.getName())
                        .append(" ").append(product.getCategory())
                        .append(" ").append(product.getPrice())
                        .append(" ").append(product.getAmount()).append("\n")
        );
        return sb.toString();
    }

    private String printProduct(Product product){

        return "ID NAME CATEGORY PRICE AMOUNT\n" +
                product.getId() + " " +
                product.getName() +
                " " + product.getCategory() +
                " " + product.getPrice() +
                " " + product.getAmount();
    }
}
