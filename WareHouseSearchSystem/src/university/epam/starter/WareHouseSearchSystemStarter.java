package university.epam.starter;

import university.epam.view.WareHouseSearchSystemView;

public class WareHouseSearchSystemStarter {
    public static final WareHouseSearchSystemView view = new WareHouseSearchSystemView();

    public static void run(){
        System.out.println("05-06-2023");
        System.out.println("Used: Java 16, JUnit5");
        System.out.println("application name: Warehouse Search System\n\n");
        System.out.println("student|dev : Aynura Mambetbayeva\nAynura_Mambetbayeva@student.itpu.uz\n\n");
        view.start();
    }
}
