package SHOPPING_CART;

public class User {
    private String userName;
    private int password;
    public User(String un,int psw){
        this.userName=un;
        this.password=psw;

    }
    public String getUserName(){
        return this.userName;
    }
    public int getPassword(){
        return this.password;
    }
    public void setUserName(String un){
        this.userName=un;
    }
    public void setPassword(int psw){
        this.password=psw;

    }


}
