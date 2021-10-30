package SalePoint;
import java.util.*;

/**
 *
 * @author lb19000961
 */
public class MakingSale {
    public static void gettingProducts(){
        Scanner sn = new Scanner(System.in);
        
        double totalPrice =0; // declaring total
        
        int counter = 2; //number of products
        SellingProduct[] pr = new SellingProduct[counter]; // creating the array to store the roducts
        
        for(int i=0; i<counter; i++){
            SellingProduct si = new SellingProduct(); // declaring a product
            
            System.out.println("prouduxt number: " + (i+1));
            
            //product code
            System.out.println("enter code");
            String code = sn.next();
            si.setProductCode(code);
            
            //product name
            System.out.println("enter name");
            String name = sn.next();
            si.setProductName(name); //assigni the product name
            
            //price
            System.out.println("enter price");
            double price = sn.nextDouble();
            si.setProductPrice(price);
            
            
            //quantity
            System.out.println("enter quantity");
            int quan = sn.nextInt();
            si.setQuntity(quan);  
            
            
            pr[i] = si; // adding the object in the array of objects
            totalPrice = (pr[i].productPrice*pr[i].quantity) + totalPrice; //formula for total price
            
        }
        System.out.println("****************************************\n PRODUCTS NAMES");
         System.out.println(pr[0].productName +" "+ pr[1].productName);
         System.out.println(" total price: "+ totalPrice);
        
    }// note: find if you can also include a method for canculation bo di changi 
    
    
    public static void main(String[] args) {
        
        //registering a product
//        SellingProduct s1 = new SellingProduct("bkrs123","koo beans",13.00,2);
//        
//        SellingProduct s2 = new SellingProduct("bds133","fish",18.00,1);
//        
//        SellingProduct s3 = new SellingProduct("ors654","oros",27.50,3);
//        
//        SellingProduct s4 = new SellingProduct("654t","kellogs",40.96,1);
//        
//        
//        SellingProduct[] pr = new SellingProduct[10];
//        pr[1] = s1;
//        pr[0] = s2;
//        
//        System.out.println(pr[1].productPrice+pr[0].productPrice);
        
        gettingProducts();
        
    }
    
}
