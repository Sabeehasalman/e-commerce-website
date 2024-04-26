package SHOPPING_CART;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CartTableModel extends AbstractTableModel{
    private String[] ColumnNames1 = {"Product Id", "Quantity", "price"};

    private Map<Product, Integer> cartItems;
    private ShoppingCart shoppingCart;
    private ArrayList<Product> selectedProducts;
    private ArrayList<Product> productList;




    public CartTableModel(String[] ColumnNames1, ArrayList<Product>productList,ShoppingCart shoppingCart) {
        this.ColumnNames1 = ColumnNames1;
        this.productList = productList;
        cartItems = new HashMap<>();
        selectedProducts = new ArrayList<>();
        this.shoppingCart=shoppingCart;


    }
    public int getRowCount() {
        return this.selectedProducts.size();
    }


    public int getColumnCount() {
        return this.ColumnNames1.length;
    }


    public Object getValueAt(int rowIndex, int ColumnIndex) {
        Object temp = null;
        Product selectedProduct  = this.selectedProducts.get(rowIndex);
        if (selectedProduct!= null) {
            if (ColumnIndex == 0) {
                temp = this.selectedProducts.get(rowIndex).getId();
            } else if (ColumnIndex == 1) {
                temp = this.selectedProducts.get(rowIndex).getQuantity();
            } else if(ColumnIndex==2){
                temp = this.selectedProducts.get(rowIndex).getPrice();
            }
        }
        else {
            System.out.println("null value");
        }
        return temp;


    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int ColumnIndex) {
        fireTableCellUpdated(rowIndex, ColumnIndex);

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public String getColumnName(int ColumnIndex) {
        return ColumnNames1[ColumnIndex];
    }

    @Override
    public Class getColumnClass(int ColumnIndex) {
        if (ColumnIndex == 0) {
            return String.class;
        } else if(ColumnIndex==1){
            return Integer.class;
        }
        else {
            return Double.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int ColumnIndex) {
        return false;
    }

    public void setData(ArrayList<Product> data) {
        this.productList = data;
    }

    public void setModel(Map<Product, Integer> cartItems) {
        this.cartItems = cartItems;

    }

    public void updateCartTable() {
        setModel(shoppingCart.getCartItems());
        selectedProducts = new ArrayList<>(cartItems.keySet());
        fireTableDataChanged();



        }

    }

