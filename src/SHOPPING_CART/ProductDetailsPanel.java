package SHOPPING_CART;

import javax.swing.*;
import java.awt.*;

public class ProductDetailsPanel extends JPanel {
    private JTextArea detailsTextArea;

    public ProductDetailsPanel() {
        setLayout(new BorderLayout());

        // Create the details text area
        detailsTextArea = new JTextArea();
        detailsTextArea.setEditable(false);

        // Add the details text area to the panel
        add(new JScrollPane(detailsTextArea), BorderLayout.CENTER);
    }

    public void updateProductDetails(Product product) {
        // Update the details text area with the selected product information
        String details = "Product Id: " + product.getId() + "\n"
                + "Name: " + product.getProductName() + "\n"
                + "Price: " + product.getPrice() + "\n";
        detailsTextArea.setText(details);
    }

}
