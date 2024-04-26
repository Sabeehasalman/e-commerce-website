package SHOPPING_CART;

import javax.swing.event.TableModelListener;
import java.util.ArrayList;


public class ProductTableModel extends AbstractProductTableModel implements MyProductTable{
    private String [] ColumnNames = {"Product Id","Name","Category","price","info"};
    private ArrayList<Product>productList;
    private WestminsterShoppingManager westminsterShoppingManager;




    public ProductTableModel(String[]ColumnNames,ArrayList<Product>productList){
        this.productList=productList;
        //this.westminsterShoppingManager = new WestminsterShoppingManager(productList);

        this.ColumnNames = ColumnNames;

    }

    public int getRowCount(){
        return this.productList.size();
    }
    public int getColumnCount(){
        return ColumnNames.length;
    }

    public Object getValueAt(int rowIndex,int ColumnIndex) {
        Object temp = null;
        Product product = this.productList.get(rowIndex);

        if (product != null) {
            if (ColumnIndex == 0) {
                temp = this.productList.get(rowIndex).getId();
            } else if (ColumnIndex == 1) {
                temp = this.productList.get(rowIndex).getProductName();
            }
            else if (ColumnIndex==2){
                temp = this.productList.get(rowIndex).getCategory();
            }
            else if (ColumnIndex == 3) {
                temp = this.productList.get(rowIndex).getPrice();
            } else if (ColumnIndex == 4) {
                temp = this.productList.get(rowIndex).toString();
            }
        }
            return temp;


    }

    @Override
    public void setValueAt(Object Value, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }


    @Override
    public void setData(ArrayList<Product>data) {
        this.productList = data;


    }

    public String getColumnName(int ColumnIndex){
        return ColumnNames[ColumnIndex];

    }
    public Class getColumnClass(int ColumnIndex){
        if (ColumnIndex==4){
            return Double.class;
        }
        else {
            return String.class;
        }
    }
    public Product getProductAt(int rowIndex) {
        return productList.get(rowIndex);
    }



    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }





}
