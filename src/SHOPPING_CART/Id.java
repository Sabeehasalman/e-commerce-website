package SHOPPING_CART;

import java.util.Comparator;

public class Id implements Comparator<Product> {


    @Override
    public int compare(Product p1, Product p2) {
        return p1.getId().compareTo(p2.getId());
    }
}
