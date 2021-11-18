/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalePoint;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author lb19000961
 */
public class MasaDBClass {
  


    // JDBC driver name and database URL
    String JDBC_DRIVER;
    String db_url;

    //Database credentials
    String USER;  // sa in the school db
    String PASS;  //Biust@2021

    //db connection and query variables
    Connection conn;
    Statement stmt;
    PreparedStatement ps;
    String query;
    ResultSet rs;

     //constructor to initialise variables
    MasaDBClass(){
        this.db_url = "jdbc:mysql://localhost:3306/masadb1?zeroDateTimeBehavior=CONVERT_TO_NULL"; //initialize if my url
        //this.JDBC_DRIVER = ; // my driver
        this.USER = "root"; //root
        this.PASS = ""; //Biust@2021

       

    }
    
    public  boolean connectDB(){
            boolean connectionCheck  = false;
         //attempt to connect to database whenever constructor is called
        System.out.println("Establishing Connection to database...");

        try{
            //register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //open a connection using user credentials and the db url
            conn = DriverManager.getConnection(db_url, USER, PASS);
            
            connectionCheck  = true;

        }catch(ClassNotFoundException cnf){
            //if class isn't found, show exception details
            System.out.println(cnf.getMessage());
            cnf.printStackTrace();
            
            connectionCheck  = false;
        }catch(SQLException se){
            //if sql connection error occurs, show exception details
            System.out.println(se.getMessage());
            se.printStackTrace();
            
            connectionCheck = false;
        }finally {
            System.out.println("Database Connection has been Established.");
            connectionCheck = true;
        }
        return connectionCheck;
    }
    
    

    //method to get all product from db, returns ArrayList of objects of product
    public ArrayList<Product> getProducts() {

        //create array list to store car objects from db
        ArrayList<Product> productsList= new ArrayList<Product>();

        try {

            //Execute a query
            query =  "select * from stock order by productCode asc";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            //loop through and get results store in variables to later creata na arraylist
            while (rs.next()){
                String code = rs.getString("code");
                String name = rs.getString("name");
                String date = rs.getString("expiryDate");
                int quantity = rs.getInt("quantity");
                double price = rs.getInt("unitPrice");
                double profit = rs.getInt("expectedReturn");
                double cost = rs.getInt("cost");

                //add a new product object with the values above
                productsList.add(new Product(code, name, date, quantity, cost ,price,profit));
            }

            //Close up
            ps.close();
            conn.close();

        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();

        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();

        }

        //return cars list to caller, may be empty if error occurred
        return productsList;
    }
    
    //method to get all product from db, returns ArrayList of objects of product
    public boolean deleteProduct( String productCode) {
        
        boolean confirmation = false;
        
        try {

            //Execute a query
            query =  "delete * from stock where code = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, productCode);
            ps.executeQuery();


            //Close up
            ps.close();
            conn.close();
            confirmation = true;

        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();

        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();

        }

        //return cars list to caller, may be empty if error occurred
        return confirmation;
    }

    
    
    
    
    // tthis meethod will return product for selling from the stock table
     public SellingProduct getSellProduct(String inputCode) {

        //create array list to store car objects from db
        SellingProduct sellProduct= new SellingProduct();

        try {

            //Execute a query
            query =  "select productcode,productName,unitPrice from stock where productCode = '?'";
            ps = conn.prepareStatement(query);
            
             ps.setString(1,inputCode);
            rs = ps.executeQuery();
            int quantity=0;
            
            
            //loop through and get results store in variables to later creata na arraylist
            while (rs.next()){
                String code = rs.getString("productCode");
                String name = rs.getString("productName");
                double price = rs.getInt("unitPrice");
  
                //add a new seling product object with the values above
                sellProduct = new SellingProduct(code, name ,price,quantity);
            }

            //Close up
            ps.close();
            conn.close();

        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();

        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();

        }

        //return cars list to caller, may be empty if error occurred
        return sellProduct;
    }
     
     
     

    //method that will be use to get product details by searching for it by code
    public Product getProductsQuantity(String code) {

        //create a Product object
        Product prod = new Product();

        try {

            //Execute a query
            query =  "select * from stock where productCode = '?'";
            ps = conn.prepareStatement(query);
            ps.setString(1,code);
            rs = ps.executeQuery();

            //if result is returned, if not, do nothing...empty product object will be returned at the end
            if(rs.next()){
                prod.setProductCode(rs.getString("productCode") );
                prod.setProductName(rs.getString("productName") );
                prod.setExpiryDate(rs.getString("expiryDate"));
                prod.setStockQuantity(rs.getInt("quantity"));
                prod.setProductCost(rs.getDouble("cost"));
                prod.setProductPrice(rs.getDouble("unitPrice"));
                prod.setExpectedReturn(rs.getDouble("expectedReturn"));
            }

            //Closing connection
            ps.close();
            conn.close();

        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();

        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();

        }

        //return a product aboject  can be empty if no product or wrong code
        return prod;
    }

    //function to add a product to the stock table in database. 
    public  boolean addProduct(Product prod){
        boolean comfirmation = false; //will be use to check if method wa successfull

        try{
            //Execute a query
            
            // create an query statement with blanks in the order: code, name, expirydate, quantity, cost, price and expected return
            query =  "Insert into stock (productCode, productName, expiryDate, quantity, unitPrice, cost, expectedReturn) values (?,?,?,?,?,?,?)";

            //insert missing values in their positions, using a prepared statement
            ps = conn.prepareStatement(query);
            ps.setString(1, prod.getProductCode());
            ps.setString(2, prod.getProductName());
            ps.setString(3, prod.getExpiryDate());
            ps.setInt(4, prod.getStockQuantity());
            ps.setDouble(5, prod.getProductCost());
            ps.setDouble(6,prod.getProductPrice());
            ps.setDouble(7, prod.getExpectedReturn());

            //execute the prepared statement
            ps.executeUpdate();

            //close up
            ps.close();
            conn.close();
            comfirmation=true;

        }catch(SQLException se){
            se.printStackTrace();
        }

        return comfirmation;
    }

    
    public boolean addUser(Users user){ //takes in a user object
        
         boolean comfirmation = false; //will be use to check if method was successfull

        try{
            //Execute a query
            
           //my query command to iserto into the user table
            query =  "Insert into users(username, password, userType) values (?,?,?)";

            //insert missing values in their positions, using a prepared statement
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getUsername()); //get the detail of the object passed
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getUserType());
            

            //execute the prepared statement
            ps.executeUpdate();

            //closing connections
            ps.close();
            conn.close();
            comfirmation=true;

        }catch(SQLException se){
            se.printStackTrace();
        }

        return comfirmation;
    
    }
    
  
    //method to check user login details -- takes input username and password
    public boolean authenticateUser(String inputUsername, String inputPassword){
        boolean auth = false; // to return a true if user exist and user input a correct password
        
        try {
            //check password of matching user
            query =  "select password from users where username=?";
            ps = conn.prepareStatement(query);

            //insert missing values
            ps.setString(1, inputUsername);
            
            //get password string
            rs = ps.executeQuery();

            //store password from database
            String password = "";
            //loop through and get results
            while (rs.next()){
                //get password string
                password = rs.getString("password");
            }

            //if user does not exist, it will return blank
            if(password.equals("")){//username does not exist
                
                auth  = false;
            }
            else if (password.equals(inputPassword)){//check if password matches
                
                
                auth = true;
            }


            //Closing
            ps.close();
            conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

        return auth;
    }
    
    public boolean deleteStock(String productCode){
        boolean check = false;
        
         try {

            //Execute a query
            query =  "delete from stock where productCode = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1,productCode);
            rs = ps.executeQuery();

       
            //Closing connection
            ps.close();
            conn.close();
            check = true;

        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
           
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();

        }




        return check;
    }
}
    

