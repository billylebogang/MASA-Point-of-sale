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
        MasaDB ob = new MasaDB();
        ob.connectDB();
        System.out.println(ob.connectDB());
        
     ArrayList<SoldProducts> sList = ob.getSoldProductsByMonth("2021-11-19","2021-11-21");
     
     for(SoldProducts pro: sList){
         System.out.println(pro.toString());
     }
    }
    
}
