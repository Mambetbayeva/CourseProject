package university.epam.view;

import university.epam.controller.ProductController;
import university.epam.data.ProductData;
import university.epam.service.impl.ProductServiceImpl;

import java.util.Scanner;

public class WareHouseSearchSystemView {

    private final static String MENU = """
            ________________________________________        
                    Menu:
            1) Show all products
            2) Search product(s)           
            3) Exit
            select one of the following (enter a number):""";
    private final static String GO_BACK = """
                    
            enter 0 to go back.
            """;
    private final static String SEARCH_PRODUCT = """
            ________________________________________
               
               Search Product:
            1) Search by Id
            2) Search by Name
            3) Search by Category
                    
            enter 0 to go back.
            select one of the following (enter a number):
            """;
    private final static String ENTER_THE_NAME = """
            
            ________________________________________
            Enter the Name:       
            """;
    private final static String ENTER_THE_ID = """
            
            ________________________________________
            Enter the ID:       
            """;
    private final static String ENTER_THE_CATEGORY = """
            
            ________________________________________
            Enter the Category:       
            """;

    private final static String ENTER_ONLY_FROM_THE_ABOVE = """
            
            Please enter only from the above
            """;
    private final static String SORT_BY = """
            
            Sort by:
            1) Id
            2) Name
            3) Category
            """;

    private final Scanner intScanner = new Scanner(System.in);
    private final Scanner lineScanner = new Scanner(System.in);
    private final ProductServiceImpl productServiceImpl = new ProductServiceImpl(ProductData.products);
    private final ProductController productController = new ProductController(productServiceImpl);



    public void start(){
        menu();
    }

    public void menu(){
        System.out.println(MENU);

        int nextInt = intScanner.nextInt();

        if(nextInt == 1){
            showProducts();
        }

        else if(nextInt == 2){
            searchProducts();
        } else if (nextInt == 3){
            System.exit(1);
        }

        else {
            System.out.println(ENTER_ONLY_FROM_THE_ABOVE);
            start();
        }

    }


    public void showProducts(){
        System.out.println(SORT_BY);


        int afterMenu = intScanner.nextInt();


        // SORT BY
        if (afterMenu == 1){
            System.out.println(productController.getAllProducts(1));
        } else if (afterMenu == 2){
            System.out.println(productController.getAllProducts(2));
        } else if( afterMenu == 3){
            System.out.println(productController.getAllProducts(3));
        }

        System.out.println(GO_BACK);
        int afterFetchData = intScanner.nextInt();

        if(afterFetchData == 0){
            start();
        }
    }


    // When User Selected Search Products
    public void searchProducts(){
        System.out.println(SEARCH_PRODUCT);
        int searchByInt = intScanner.nextInt();

        // When User Selected Search By ID
        if(searchByInt == 1){
            System.out.println(ENTER_THE_ID);

            int id = intScanner.nextInt();
            System.out.println(productController.getProductById(id));
            System.out.println(GO_BACK);

            getBackInSearchProduct();

        }

        // When User Selected Search By Name
        else if(searchByInt == 2){
            System.out.println(ENTER_THE_NAME);

            String name = lineScanner.nextLine();
            System.out.println(productController.getProductByName(name));
            System.out.println(GO_BACK);

            getBackInSearchProduct();
        }

        // When User Selected Search By Category
        else if (searchByInt == 3){
            System.out.println(ENTER_THE_CATEGORY);

            String category = lineScanner.nextLine();
            System.out.println(productController.getProductByCategory(category));
            System.out.println(GO_BACK);

            getBackInSearchProduct();
        }

        // Back To Menu
        else if (searchByInt == 0){
            start();
        }
        else {
            searchProducts();
            System.out.println(ENTER_ONLY_FROM_THE_ABOVE);
        }

    }

    private void getBackInSearchProduct(){
        int menu = intScanner.nextInt();

        if(menu == 0){
            searchProducts();
        }
    }


}
