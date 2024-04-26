package SHOPPING_CART;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;


public class WestminsterShoppingCentre {
    private ArrayList<Product>productList;


    public WestminsterShoppingCentre(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public static void main(String[] args) {

        String[] ColumnNames = {"Product Id", "Name","price","Info"};
        ArrayList<Product> productList = new ArrayList<>();
        WestminsterShoppingManager w1 = new WestminsterShoppingManager(50);
        ProductTableModel productTableModel = new ProductTableModel(ColumnNames,productList);
        JTable table1 = new JTable(productTableModel);
        if (table1.getColumnCount() > 4) {
            table1.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {

                Color originalColor = null;

                @Override
                public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected,
                                                               boolean hasFocus, int row, int column) {
                    Component renderer =
                            super.getTableCellRendererComponent(table, value,
                                    isSelected, hasFocus, row, column);

                    if (row<3) {
                        renderer.setBackground(Color.GREEN);
                    } else {
                        renderer.setBackground(Color.BLUE);

                    }

                    return renderer;
                }
            });


            JScrollPane scrollPane = new JScrollPane(table1);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JFrame frame = new JFrame("Person Table Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(scrollPane);
            frame.setSize(400, 300);
            //frame.setLocationRelativeTo(null);
            frame.setVisible(true);






        }
}

    }

