package SHOPPING_CART;



public class Electronics extends Product {
    private String brand;
    private int warrantyPeriod;

    public Electronics(String pId,String pn,int noPA,int pric,String cat,String br,int wp){
        super(pId,pn,noPA,pric,cat);
        this.brand=br;
        this.warrantyPeriod=wp;

    }
    public Electronics(){

    }

    @Override
    public String toString() {
        return "Electronics{" +
                "brand='" + brand + '\'' +
                ", warrantyPeriod=" + warrantyPeriod +
                ", productId='" + productId + '\'' +
                '}';
    }

    public String getBrand(){
        return this.brand;

    }
    public int getWarrantyPeriod(){
        return this.warrantyPeriod;
    }
    public void setBrand(String br){
        this.brand=br;
    }
    public void setWarrantyPeriod(int wp){
        this.warrantyPeriod=wp;
    }
    public void printInfo(){
        System.out.println("ID: "+productId+", Product Name:  "+getProductName()+", Number Of Product: "+getNumberOfProduct()+", Brand Name: "+getBrand()+", Warranty Period: "+getWarrantyPeriod());
    }


}
