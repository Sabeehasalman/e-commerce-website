package SHOPPING_CART;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {


    private ArrayList<Product> productList = new ArrayList<>();

    private ProductDetailsPanel productDetailsPanel;
    private JTable table2;
    private Map<Product, Integer> cartItems;
    private Product selectedProduct;
   private CartTableModel cartTableModel;
    private ProductTableModel productTableModel;
    private ArrayList<Product> selectedProducts;
    private ShoppingCart shoppingCart;

    private int selectedRow;


    public ShoppingCart(CartTableModel cartTableModel) {
        this.cartTableModel=cartTableModel;
        selectedProducts= new ArrayList<>();
        cartItems=new HashMap<>();

    }

    public Product getSelectedProduct(){
        return selectedProduct;
    }



    public void addProduct(Product product) {
        productList.add(product);
        cartItems.put(product, cartItems.getOrDefault(product, 0) + 1);
        selectedProduct = product;  // Set the selected product when adding to the cart



        if (selectedRow >= 0 && selectedRow < productList.size()) {
            Product selectedProduct = productList.get(selectedRow);
            // Update the cart table with the selected product
            //shoppingCart.addProduct(selectedProduct);
            cartTableModel.setData(new ArrayList<>(this.cartItems.keySet()));
            cartTableModel.setModel(cartItems);
            cartTableModel.fireTableDataChanged();





        }

    }

    public Map<Product, Integer> getCartItems() {
        return this.cartItems;
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }

    public double calculateTotal() {

        double total = 0;
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            //quantity = entry.getValue();
            total += product.getPrice() * product.getQuantity();
        }
        // Apply discounts if needed
        // For simplicity, let's assume a 10% discount
        total *= 0.9;
        return total;
    }


    public ArrayList<Product> getProductList() {
        return this.productList;
    }


    public void showShoppingCartDialog() {

        StringBuilder cartDetails = new StringBuilder();
        cartDetails.append("Shopping Cart Details:\n");

        for (Map.Entry<Product, Integer> entry : getCartItems().entrySet()) {
            Product product = entry.getKey();
            //int quantity = entry.getValue();
            cartDetails.append(product.getProductName()).append(" (").append(product.getQuantity()).append(") - $").append(product.getPrice() * product.getQuantity()).append("\n");


        }

            cartDetails.append("\nTotal Price: $").append(calculateTotal());


    }





    }











