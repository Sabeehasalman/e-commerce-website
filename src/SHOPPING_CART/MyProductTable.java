package SHOPPING_CART;

import javax.swing.table.TableModel;
import java.util.ArrayList;

public interface MyProductTable extends TableModel {
    void setData(ArrayList<Product>data);

}
