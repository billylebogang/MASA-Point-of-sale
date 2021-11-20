/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalePoint;

/**
 *
 * @author lebog
 */
public class SoldProducts {
    private String soldProductCode;
    private int soldQuantity;
    private double soldTotalPrice;
    private String saleDate;
    
    
    public SoldProducts(){
        this.soldProductCode= "";
        this.soldQuantity = 0;
        this.soldTotalPrice = 0.0;
        this.saleDate = "";
    
    
    }
    
    public SoldProducts(String code, int quantity, double price, String date){
        this.soldProductCode= code;
        this.soldQuantity = quantity;
        this.soldTotalPrice = price;
        this.saleDate = date;
    
    
    }
    
    public void setSoldProductCode(String code){this.soldProductCode= code; }
    public void setSoldQuantity(int quantity){this.soldQuantity = quantity;}
    public void setSoldTotalPrice(double price){this.soldTotalPrice = price;}
    public void setSaleDate(String date){this.saleDate = date;}
    
    public String getSoldProductCode(){ return this.soldProductCode; }
    public int getSoldQuantity(){ return this.soldQuantity;}
    public double getSoldTotalPrice(){return this.soldTotalPrice;}
    public String getSaleDate(){return this.saleDate;}
    
    
    public String toString(){
        
        return this.soldProductCode + " |"+this.soldQuantity +" |"+ this.soldTotalPrice +" |"+ this.saleDate;
    }
    
    
}
