package SHOPPING_CART;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {

    private GUI gui;
    private ArrayList<Product> productList;
    private WestminsterShoppingCentre westminsterShoppingCentre;
    private WestminsterShoppingManager westminsterShoppingManager;
    private ProductTableModel productTableModel;
    private Product product;
    private JTable table1;

    private ProductDetailsPanel detailsPanel;
    private ShoppingCart shoppingCart;
    private JButton addToCartButton;
    private JButton viewCartButton;
    private CartTableModel cartTableModel;
    private JTable table2;
    private JTextArea showShoppingCartDialog;
    private ArrayList<Product> selectedProducts = new ArrayList<>();
    String[] ColumnNames = {"Product Id", "Name", "price","Category", "info"};
    String[] ColumnNames1 = {"Product Id", "Quantity", "price"};


        public GUI(ArrayList<Product> productList) {
            this.shoppingCart = new ShoppingCart(cartTableModel);
            this.productList = productList;
            this.productTableModel = new ProductTableModel(this.ColumnNames, this.productList);

            this.table1 = new JTable(productTableModel);
            JScrollPane scrollPane = new JScrollPane(table1);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JFrame frame = new JFrame("Person Table Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setSize(400, 300);
            frame.setVisible(true);


            // adding colors for rows according to number of rows
            if (table1.getColumnCount()> 4) {
                table1.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {

                    Color originalColor = null;

                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                                   boolean hasFocus, int row, int column) {
                        Component renderer =
                                super.getTableCellRendererComponent(table, value,
                                        isSelected, hasFocus, row, column);

                        if (row< 3) {
                            renderer.setBackground(Color.RED);
                        }
                        else {
                            renderer.setBackground(Color.WHITE);
                        }

                        return renderer;
                    }
                });
            }


            table1.getSelectionModel().addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table1.getSelectedRow();
                    if (selectedRow != -1) {
                        // Get the selected product from the table model
                        Product selectedProduct = this.productTableModel.getProductAt(selectedRow);

                        // Update the product details panel with the selected product information
                        detailsPanel.updateProductDetails(selectedProduct);
                    }
                }
            });


            // Create the product details panel
            detailsPanel = new ProductDetailsPanel();


            // Add the product details panel below the product table
            frame.add(detailsPanel, BorderLayout.SOUTH);

            JButton addToCartButton = new JButton("Add to Cart");

            addToCartButton.addActionListener(e -> {
                int selectedRow = table1.getSelectedRow();
                if (selectedRow != -1) {
                    Product selectedProduct = productTableModel.getProductAt(selectedRow);
                    shoppingCart.addProduct(selectedProduct);
                    cartTableModel.updateCartTable();
                    shoppingCart.showShoppingCartDialog();
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a product to add to the cart.");
                }
            });
            this.shoppingCart = new ShoppingCart(cartTableModel);
            JButton viewCartButton = new JButton("View Shopping Cart");

            viewCartButton.addActionListener(e -> {
                cartTableModel.updateCartTable();
                shoppingCart.showShoppingCartDialog();
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(addToCartButton);
            buttonPanel.add(viewCartButton);
            frame.add(buttonPanel, BorderLayout.NORTH);

        cartTableModel = new CartTableModel(ColumnNames1,selectedProducts,shoppingCart);
        table2 = new JTable(cartTableModel);
        shoppingCart.showShoppingCartDialog();
        showShoppingCartDialog = new JTextArea();



        JScrollPane scrollPane1 = new JScrollPane(table2);


        scrollPane1.setPreferredSize(new Dimension(400, 300));
        JFrame frame1 = new JFrame("Shopping cart");
        frame1.setLayout(new BorderLayout());
        frame1.add(scrollPane1, BorderLayout.CENTER);
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setContentPane(scrollPane1);
        frame1.setSize(300, 200);
        frame1.setLocationRelativeTo(this);
        frame1.setVisible(true);


    }


}
