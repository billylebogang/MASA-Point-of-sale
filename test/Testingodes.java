/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lebog
 */
public class Testingodes { 
    
        public enum Months{
          january(1),february(2),march(3),april(4);
          
          private int value;
          private Months(int value){
              this.value = value;
          }
        
        };
    
    public static void main(String[] args) {
        
        System.out.println(Months.march.value);
       
    }
    
}
