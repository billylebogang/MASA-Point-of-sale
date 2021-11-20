/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalePoint;

import java.util.ArrayList;

/**
 *
 * @author lebog
 */
public class Tester {
    public static void main(String[] args) {
        MasaDBClass ob = new MasaDBClass();
        ob.connectDB();
        System.out.println(ob.connectDB());
        
        
        //ArrayList <Product> prods = ob.getProducts();
        
//        for(Product prod: prods){
//            System.out.println(prod.toString());
//        
//        }
        
        
        //System.out.println("results id : " +qunt);
        
        //testing the adding to sold stock
       // SoldProducts prod = new SoldProducts("bw122",20,25.0,"21-02-12");
        
       // System.out.println(ob.addToSoldStock(prod));
    }
    
}
