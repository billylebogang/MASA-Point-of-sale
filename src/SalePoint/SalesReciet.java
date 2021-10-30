package SalePoint;

import java.io.FileWriter;
import java.io.IOException;

/**
 * billy
 * @author lb19000961
 */
public class SalesReciet {
    //instances
    double totalAmount,amountRecieved, change;
    String staffName,date,time;
    int recietNumber,count; //number of products
    SellingProduct[] products; 
    
    SalesReciet(){
        this.totalAmount = 0;
        this.amountRecieved = 0;
        this.change = 0;
        this.staffName = "null";
        this.date = "null";
        this.time = "null";
        this.products = new SellingProduct[count +1];
    }
    
    SalesReciet(double total, double amount, double change, String name, String date, String time, SellingProduct[] prod ){
        this.totalAmount = total;
        this.amountRecieved = amount;
        this.change = change;
        this.staffName = name;
        this.date = date;
        this.time = time;
        this.products = prod;
    
    }
    
    //set methods
    
    public void setTotalamount(double t){
        this.totalAmount = t;
    }
    
    public void setAmountRecieved(double r){
        this.amountRecieved = r;
    }
    public void setChange(double c){
        this.change = c;
    }
    
    public void setStaffName(String s){
        this.staffName = s;
    }
    public void setDate(String d){
        this.date = d;
    }
    public void setTime(String t){
        this.time = t;
    }
    
    public void setProducts(SellingProduct[] p){
        this.products = p;
    }
    
    //get methods
    public double getTotalamount(){
        return this.totalAmount;
    }
    
    public double getAmountRecieved(){
        return this.amountRecieved;
    }
    public double getChange(){
        return this.change;
    }
    
    public String getStaffName(){
        return this.staffName;
    }
    public String getDate(){
        return this.date;
    }
    public String getTime(){
        return this.time;
    }
    
    public SellingProduct[] getProducts(){
        return this.products;
    }
    
    //toString method 
    
    public String toString(){
     return this.totalAmount +
            this.amountRecieved +
            this.change  +
            this.staffName +
            this.date  +
            this.time +
            this.products;
    }
    
    public void printReciet(){
     try{
         
         FileWriter fw = new FileWriter("reciet.txt");
         
         fw.write("details of the reciet");
         
         fw.close();
         
     
     }
     catch(IOException e){
         System.out.println("there is a problem writing");
         
     }
    
    }
    
}
