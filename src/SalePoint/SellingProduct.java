package SalePoint;

/**
 *
 * @author lb19000961
 */
public class SellingProduct { //class for a product to sell, it works with the reciet it goes in the array of products
    
    String productCode, productName;
    double productPrice;
    int quantity;
    
    //decfault contructor
    
    SellingProduct(){
        this.productCode = "null";
        this.productName = "null";
        this.productPrice = 0;
        this.quantity = 0;
    }
    
    SellingProduct(String code, String name, double price, int quan){
        this.productCode = code;
        this.productName = name;
        this.productPrice = price;
        this.quantity = quan;

    }
    
    //set methods
    
    public void setProductCode(String c){
        this.productCode = c;
    }
    public void setProductName(String n){
        this.productName = n;
    }
    
    public void setProductPrice(double p){
        this.productPrice = p;
    }
    public void setQuntity(int q){
        this.quantity = q;
    }
    
    //get methods
    
     public String getProductCode(){
        return this.productCode;
    }
    public String getProductName(){
        return this.productName;
    }
    
    public double getProductPrice(){
        return this.productPrice;
    }
    public int getQuantity(){
        return this.quantity;
    }
    
    
    public String toString(){
        return this.productCode+ " |" +this.productName+" |" + this.productPrice+" |" +this.quantity;
    
    }
    
    
}
