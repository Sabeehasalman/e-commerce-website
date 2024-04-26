package SHOPPING_CART;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class WestminsterShoppingManager implements ShoppingManager{
    private final ArrayList<Product> productList= new ArrayList<>();
    private final Scanner scanner= new Scanner(System.in);
    private int numOfProduct;
    private  Product product;
    private GUI gui;

    public WestminsterShoppingManager(int list){
        this.numOfProduct =list;
    }

    public void menuConsole() {
        int choice;

        do {
            System.out.println("1. Add a new product");
            System.out.println("2. Delete a product");
            System.out.println("3. Print the list of products");
            System.out.println("4. Save in a file");
            System.out.println("5. Exit");
            System.out.println("6. GUI");
            System.out.println("Enter your choice");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNewProduct(product);

                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    printListOfProduct();
                    break;
                case 4:
                    save();
                    break;
                case 5:
                    exit();
                    break;
                case 6:
                    gui = new GUI(this.productList);


                    break;
            }


        } while (choice == 5);
    }
    public void addNewProduct(Product product) {


            System.out.println("1. Add a electronic product");
            System.out.println("2. Add a clothing product");

            int option = scanner.nextInt();
            scanner.nextLine();
        String pId;
        do {
            System.out.println("Enter product id");
            pId = scanner.nextLine().trim();  // Trim to remove leading/trailing spaces
        } while (pId.isEmpty());  // Repeat until a non-empty string is provided

        // Validation loop for Product Name (assuming it should be a non-empty string)
        String pn;
        do {
            System.out.println("Enter product name");
            pn = scanner.nextLine().trim();
        } while (pn.isEmpty());

        // Validation loop for Number of Products Available (assuming it should be a positive integer)
        int noPA;
        do {
            System.out.println("Enter number of products available");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();  // Consume the invalid input
            }
            noPA = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
        } while (noPA <= 0);  // Repeat until a positive integer is provided

        // Validation loop for Product Price (assuming it should be a positive integer)
        int pric;
        do {
            System.out.println("Enter product price");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();  // Consume the invalid input
            }
            pric = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
        } while (pric <= 0);  // Repeat until a positive integer is provided

        // Validation loop for Category (assuming it should be a non-empty string)
        String ct;
        do {
            System.out.println("Enter category");
            ct= scanner.nextLine().trim();
        } while (ct.isEmpty());





        switch (option) {
                case 1:
                    System.out.println("Product brand");
                    String br = scanner.next();
                    System.out.println("Product warranty periods");
                    int wp = scanner.nextInt();
                    Product p1  = new Electronics(pId, pn, noPA, pric,ct, br, wp);
                    //this.addNewProduct(e);
                    productList.add(p1);



                    break;
                case 2:
                    System.out.println("Product size");
                    int sz = scanner.nextInt();
                    System.out.println("Product color");
                    String clr = scanner.next();
                    Product p2 = new Clothing(pId, pn, noPA, pric, ct, sz, clr);
                    //this.addNewProduct(c);
                    productList.add(p2);

                    break;

            }

            System.out.println("do you need to add a new book(Y/N)");
            String isNewProduct = scanner.next();
            scanner.nextLine();
            boolean newProduct = false;


            if (isNewProduct.equals("Y")) {
                newProduct = true;
                addNewProduct(product);

            } else if (isNewProduct.equals("N")) {
                newProduct = false;
                menuConsole();
            } else {
                System.out.println("Invalid option");
            }


            if (productList.size()<numOfProduct){
                productList.add(product);
        }
        else {
            System.out.println("No more space in product list");
        }




    }



    public void deleteProduct(){
        System.out.println("Enter product Id number");
        String  ID = scanner.next();
        for (Product product:productList) {

            if (product.getId().equals(ID)) {
                productList.remove(product);
                menuConsole();
            } else {
                System.out.println("provided id is not in product list");
                menuConsole();
            }
        }


    }
    public void  printListOfProduct(){
        System.out.println("List of product sorted by id");
        Id i = new Id();
        Collections.sort(productList,i);
        for(Product p: productList){
           p.printInfo();
        }
        menuConsole();


    }

    public void save(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("products.txt"))) {
            for (Product product : productList) {
                String productInfo = String.format("%s,%s,%d,%d,%s",
                        product.getId(), product.getProductName(),
                        product.getQuantity(), product.getPrice(),
                        product.getCategory());

                if (product instanceof Electronics electronics) {
                    // Add additional information for electronics
                    productInfo += String.format(",%s,%d", electronics.getBrand(), electronics.getWarrantyPeriod());
                } else if (product instanceof Clothing clothing) {
                    // Add additional information for clothing
                    productInfo += String.format(",%d,%s", clothing.getSize(), clothing.getColor());
                }

                writer.write(productInfo);
                writer.newLine();
            }

            System.out.println("Product list saved to ");
        } catch (IOException e) {
            System.out.println("Error saving product list to file: " + e.getMessage());
        }
        menuConsole();
    }



    public void exit(){

    }


}
