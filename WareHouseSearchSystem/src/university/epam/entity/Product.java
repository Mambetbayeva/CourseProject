package university.epam.entity;

import university.epam.util.ProductUtil;

public class Product {
    private int id;
    private String name;
    private String category;
    private int price;
    private int amount;


    public Product(int id, String name, String category, int price, int amount) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.amount = amount;
    }

    public Product(String name, String category, int price, int amount) {
        this.id = ProductUtil.idCounter++;
        this.name = name;
        this.category = category;
        this.price = price;
        this.amount = amount;
    }



    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getCategory() {
        return category;
    }


    public int getPrice() {
        return price;
    }


    public int getAmount() {
        return amount;
    }

}
