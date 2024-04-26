package SHOPPING_CART;

import java.util.ArrayList;

public abstract class AbstractProductTableModel {
    public abstract int getRowCount();
    public abstract int getColumnCount();
    public abstract Object getValueAt(int rowIndex,int columnIndex);
    public abstract String getColumnName(int ColumnIndex);

    public abstract void setData(ArrayList<Product> data);






}
