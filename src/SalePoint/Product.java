
package SalePoint;

/**
 * billy
 * @author lb19000961
 */
public class Product {
    //product class instances
     String productCode;
     String productName;
     String expiryDate;
     int stockQuantity;
     double productCost;
     double productPrice; //the selling price;
     double expectedReturn; // quantity*price
     
    //product class constructor
     
     //default constructor
     public Product(){
         this.productCode = "null";
         this.productName = "null";
         this.expiryDate = "none";
         this.stockQuantity = 0;
         this.productCost = 0.0;
         this.productPrice = 0.0;
         this.expectedReturn = 0.0;
     }
     
     //parameterised
     public Product( String code, String name, String date, int quantity, double cost, double price, double eReturn){
         this.productCode = code;
         this.productName = name;
         this.expiryDate = date;
         this.stockQuantity = quantity;
         this.productCost = cost;
         this.productPrice = price;
         this.expectedReturn = eReturn;
     
     }
    
    //product set methods
    
     public void setProductCode ( String newProductCode){
         this.productCode = newProductCode;
     } 
     
     public void setProductName ( String newProductName){
         this.productName = newProductName;
     }
     
     public  void setExpiryDate ( String newExpiryDate){
         this.expiryDate = newExpiryDate;
     }
    
     public  void setStockQuantity ( int newStockQuantity){
         this.stockQuantity = newStockQuantity;
     }
     
     public  void setProductCost ( double newProductCost){
         this.productCost = newProductCost;
     }
     
     public  void setProductPrice ( double newProductPrice){
         this.productPrice = newProductPrice;
     }
     
     public  void setExpectedReturn ( double newExpectedReturn){
         this.expectedReturn = newExpectedReturn;
     }
     
     
    //product get methods
     
     public String getProductCode(){
         return this.productCode;
     }
     
     public String getProductName(){
         return this.productName;
     }
     
     public String getExpiryDate(){
         return this.expiryDate;
     }
     
     public int getStockQuantity(){
         return this.stockQuantity;
     }
     
     public double getProductCost(){
         return this.productCost;
     }
     
     public double getProductPrice(){
         return this.productPrice;
     }
     
     public double getExpectedReturn(){
         return this.expectedReturn;
     }
     
    
    //product toString method
     
     public String toString(){
         return this.productCode +" |"+ this.productName +" |"+ this.expiryDate +" |"+ this.stockQuantity +" |"+ this.productCost +" |"+ this.productPrice +" |"+ this.expectedReturn;
         
     }

    
}
