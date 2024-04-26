package SHOPPING_CART;

public abstract class Product {
    protected String productId;
    private String productName;
    private int numberOfProductAvailable;
    private int price;
    private int quantity;
    private String Category;


    public Product(String pId , String pn, int noPA,int pric,String cat){
        this.productId=pId;
        this.productName=pn;
        this.numberOfProductAvailable=noPA;
        this.price=pric;
        this.Category= cat;

    }
    public Product(){

    }


    public String getId() {
        return this.productId;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public String getCategory(){
        return this.Category;
    }
    public void setCategory(String ct){
        this.Category=ct;
    }

    public void setId(String pId) {
        this.productId = pId;
    }
    public int getNumberOfProduct(){
        return this.numberOfProductAvailable;
    }
    public void setNumberOfProduct(int nopA){
        this.numberOfProductAvailable=nopA;
    }
    public String getProductName(){
        return this.productName;
    }
    public void setProductName(String pn){
        this.productName=pn;
    }
    public int getPrice(){
        return this.price;
    }
    public void setPrice(int pric){
        this.price=pric;
    }
    public abstract void printInfo();
}
