package SHOPPING_CART;

public class Clothing extends Product{
    private int size;
    private String color;

    public Clothing(String pId,String pn,int noPA,int pric,String cat,int sz,String clr){
        super(pId,pn,noPA,pric,cat);
        this.size=sz;
        this.color=clr;
    }
    public Clothing(){

    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "size=" + size +
                ", color='" + color + '\'' +
                ", productId='" + productId + '\''+
                '}';
    }

    public void setSize(int sz) {
        this.size = sz;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String clr) {
        this.color = clr;
    }
    public void printInfo(){
        System.out.println("Id: "+productId+", Product Name: "+getProductName()+", Number Of Products: "+getNumberOfProduct()+", Size: "+getSize()+", Color: "+getColor());
    }
}
