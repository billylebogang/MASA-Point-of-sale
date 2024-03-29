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
public class MasaDB {
  


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
    MasaDB(){
        this.db_url = "jdbc:mysql://localhost:3306/masadb1?zeroDateTimeBehavior=CONVERT_TO_NULL"; //initialize if my url
        //this.JDBC_DRIVER = ; // my driver
        this.USER = "root"; //root
        this.PASS = ""; //Biust@2021

       

    }
    //method to connect database
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
                String code = rs.getString("ProductCode");
                String name = rs.getString("productName");
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
   
    // tthis meethod will return product for selling from the stock table
     public SellingProduct getSellProduct(String inputCode) {

        //creating a product object to return
        SellingProduct sellProduct= new SellingProduct();

        try {

            //Execute a query
            query =  "select productCode,productName,unitPrice from stock where productCode = ?";
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

        //return sell product onbject to caller, may be empty if error occurred
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
    
    public  boolean decreaseProduct(String productCode, int quantity){
        boolean comfirmation = false; //will be use to check if method wa successfull

        try{
            //Execute a query
            
            // a qury to update the product quantity
            query =   "UPDATE `stock` SET `quantity`='`quantity -?`' WHERE `productCode` = ?;";

            //insert missing values in their positions, using a prepared statement
            ps = conn.prepareStatement(query);
            ps.setInt(1, quantity);
            ps.setString(2, productCode);
           

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
     
    public  int checkQuantity(String productCode){
        int quantity = 0; //will be use to check if method wa successfull

        try{
            //Execute a query
            
            // a qury to update the product quantity
            query =   "SELECT quantity FROM stock WHERE productCode = ?";

            //insert missing values in their positions, using a prepared statement
            ps = conn.prepareStatement(query);
            ps.setString(1, productCode);
            
            rs = ps.executeQuery(); // set the result set to the out of prepared statemnet
            
            while(rs.next()){
                quantity = rs.getInt("quantity");
            
            }
           

            //close up
            ps.close();
            conn.close();
            
            

        }catch(SQLException se){
            se.printStackTrace();
        }

        return quantity;
    }

    //this method will be called to add the user to db
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
            query =  "select password,userType from users where username=?";
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
     //method to check user login details -- takes input username and password
    public String checkUserType(String inputUsername){
        String user = ""; // to return a true if user exist and user input a correct password
        
        try {
            //check usertype of matching user
            query =  "select userType from users where username=?";
            ps = conn.prepareStatement(query);

            //insert missing values
            ps.setString(1, inputUsername);
            
            
            rs = ps.executeQuery();

            String usertype =""; //to set to the user type that will be returned
            //loop through and get results
            while (rs.next()){
                //get usertype string
               
                usertype = rs.getString("userType");
            }
            //if user does not exist, it will return blank
            if(usertype.equals("staff")){//username does not exist
                
                user  = "staff";
            }
            else{//check if password matches
                
                
                user = "admin";
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

        return user;
    }
    
    //this method will be used to delete the stock items..
    public boolean deleteStock(String productCode){
        boolean check = false;
        
         try {

            //Execute a query
            query =  "delete  from stock where productCode = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1,productCode);
            ps.execute();

       
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
    
    
    public  boolean addToSoldStock(SoldProducts sold){
        boolean comfirmation = false; //will be use to check if method wa successfull

        try{
            
            
            // create an query statement to insert into stocksold
            query =  "Insert into stocksold (productCode, quantity, totalPrice, saleDate) values (?,?,?,?)";

            //insert missing values in their positions, using a prepared statement
            ps = conn.prepareStatement(query);
            
            ps.setString(1, sold.getSoldProductCode());          
            ps.setInt(2, sold.getSoldQuantity());            
            ps.setDouble(3,sold.getSoldTotalPrice());
            ps.setString(4, sold.getSaleDate());

            //execute the prepared statement
            ps.executeUpdate();

            //close up
            ps.close();
            conn.close();
            
            comfirmation=true;

        }catch(SQLException se){
            se.printStackTrace();
        }

        return comfirmation; //return the confirmation of insert
    }
    
    
    public ArrayList<SoldProducts> getSoldProducts() { // this method gets the sold stock from the db

        //create array list to store sold product objects from db
        ArrayList<SoldProducts> soldList= new ArrayList<SoldProducts>();

        try {

            //the select query
            query =  "SELECT * FROM `stocksold`";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery(); //execution here

            //loop through and get results store in variables to later creata na arraylist
            while (rs.next()){
                String code = rs.getString("ProductCode");
                int quantity = rs.getInt("quantity");
                double price = rs.getInt("totalPrice");
                String date = rs.getString("saleDate");
                
                //add a new sold product object with the values above
                soldList.add(new SoldProducts(code,  quantity,  price,  date));
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

        //return  lists of sold product object to the caller, may be empty if error occurred
        return soldList;
    }
     
     
      public ArrayList<SoldProducts> getSoldProductsByMonth(String beginDate, String endDate) { //this method retrives sold product by dates

        //create array list to store sold product objects from db
        ArrayList<SoldProducts> soldList = new ArrayList<>();

        try {

            
            //Execute a query
            query =  "SELECT * FROM `stocksold` WHERE saleDate BETWEEN ? AND ?";
            ps = conn.prepareStatement(query);
            //setting unknowm parameters
            ps.setString(1, beginDate);
            ps.setString(2, endDate);
            //executing the query
            rs = ps.executeQuery();

            //loop through and get results store in variables to later creata na arraylist
            while (rs.next()){
                String code = rs.getString("ProductCode");
                int quantity = rs.getInt("quantity");
                double price = rs.getInt("totalPrice");
                String date = rs.getString("saleDate");
                

                //add a new sold product object with the values above
                soldList.add(new SoldProducts(code,  quantity,  price,  date));
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

        //return  lists of sold product object to the caller, may be empty if error occurred
        return soldList;
    }
    
     public ArrayList<Product> getExpiredStock(String expDate) { //this method retrives sold product by dates

        //create array list to store sold product objects from db
        ArrayList<Product> expiredList = new ArrayList<>();

        try {

            
            //Execute a query
            query =  "SELECT * FROM `stock` WHERE expiryDate <?";
            ps = conn.prepareStatement(query);
            //setting unknowm parameters
            ps.setString(1, expDate);
           
            //executing the query
            rs = ps.executeQuery();

            //loop through and get results store in variables to later creata na arraylist
            while (rs.next()){
                String code = rs.getString("ProductCode");
                String name = rs.getString("productName");
                String date = rs.getString("expiryDate");
                int quantity = rs.getInt("quantity");
                double price = rs.getInt("unitPrice");
                double profit = rs.getInt("expectedReturn");
                double cost = rs.getInt("cost");

                //add a new product object with the values above
                expiredList.add(new Product(code, name, date, quantity, cost ,price,profit));
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

        //return  lists of sold product object to the caller, may be empty if error occurred
        return expiredList;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    

