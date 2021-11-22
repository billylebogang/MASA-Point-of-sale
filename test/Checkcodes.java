
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lb19000961
 */
public class Checkcodes {
    public static void main(String[] args) {
        
          try{
            //creting a file write with file name
            
            
             BufferedWriter logfw = new BufferedWriter(new FileWriter("C:\\Users\\lebog\\OneDrive - biust.ac.bw\\Desktop\\login-regitser.txt", true)); //this will write to the cashier log
            
            String details1 = " MASA GENERAL DEALER \n     Fax:3314256 \n    Cell: 72187246 \n lebogangbilli@gmail.com \n \n"; //writing the store name

            logfw.append("\n ***************************************************");

            logfw.append("\n user Billy login! time :1900  date:21-10-21"); 
 
            logfw.close();
        
        }
        
        
        catch(IOException e){ //catching the errors if the it fails to update
            e.printStackTrace();
            System.out.println("Not able to write into the file");
        }
          
          
          
         try{
            //creting a file write with file name
            
            
             BufferedWriter logfw = new BufferedWriter(new FileWriter("C:\\Users\\lebog\\OneDrive - biust.ac.bw\\Desktop\\login-regitser.txt", true)); //this will write to the cashier log
            
            String details1 = " MASA GENERAL DEALER \n     Fax:3314256 \n    Cell: 72187246 \n lebogangbilli@gmail.com \n \n"; //writing the store name

            

            logfw.append("\n user Billy log out! time :1200  date:21-10-21"); 
            
            logfw.append("\n ***************************************************\n");
            logfw.close();
        
        }
        
        
        catch(IOException e){ //catching the errors if the it fails to update
            e.printStackTrace();
            System.out.println("Not able to write into the file");
        }
          
          
          
      
    }
    
}
