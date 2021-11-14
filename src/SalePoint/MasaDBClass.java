/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalePoint;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author lb19000961
 */
public class MasaDBClass {
  


    // JDBC driver name and database URL
    String JDBC_DRIVER;
    String DB_URL;

    //Database credentials
    String USER;
    String PASS;

    //db connection and query variables
    Connection conn;
    Statement stmt;
    PreparedStatement ps;
    String sql;
    ResultSet rs;

     //constructor to initialise variables
    MasaDBClass(){
        this.DB_URL = "jdbc:h2:~/carsdb";
        this.JDBC_DRIVER = "org.h2.Driver";
        this.USER = "";
        this.PASS = "";

        //attempt to connect to database whenever constructor is called
        System.out.println("Establishing Connection to database...");

        try{
            //register the driver
            Class.forName(JDBC_DRIVER);

            //open a connection using user credentials and the db url
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

        }catch(ClassNotFoundException cnf){
            //if class isn't found, show exception details
            System.out.println(cnf.getMessage());
            cnf.printStackTrace();
        }catch(SQLException se){
            //if sql connection error occurs, show exception details
            System.out.println(se.getMessage());
            se.printStackTrace();
        }finally {
            System.out.println("Database Connection has been Established.");
        }

    }

    //method to get all cars, returns ArrayList of objects of Car type
    public ArrayList<Product> getProducts() {

        //create array list to store car objects from db
        ArrayList<Product> productsList= new ArrayList<Product>();

        try {

            //Execute a query
            sql =  "select * from stock order by code asc";
            ps = conn.prepareStatement(sql);
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

    //method that will be use to get product details by searching for it by code
    public Product getProductsQuantity(String code) {

        //create a Product object
        Product prod = new Product();

        try {

            //Execute a query
            sql =  "select * from stock where code = '?'";
            ps = conn.prepareStatement(sql);
            ps.setString(1,code);
            rs = ps.executeQuery();

            //if result is returned, if not, do nothing...empty car object will be returned at the end
            if(rs.next()){
                prod.setProductCode(rs.getString("code") );
                prod.setProductName(rs.getString("name") );
                prod.setExpiryDate(rs.getString("expiryDate"));
                prod.setStockQuantity(rs.getInt("quantity"));
                prod.setProductCost(rs.getDouble("cost"));
                prod.setProductPrice(rs.getDouble("unitPrice"));
                prod.setExpectedReturn(rs.getDouble("expectedReturn"));
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

        //return a product aboject  can be empty if no product or wrong code
        return prod;
    }

    //function to add a car to the cars database. Called by the GUIAddProduct
    public  boolean addProduct(Product prod){
        boolean success = false;

        try{
            //Execute a query
            
            // create an sql statement with blanks in the order: code, name, expirydate, quantity, cost, price and expected return
            sql =  "Insert into stock (productCode, productName, expiryDate, quantity, cost, unitPrice, expectedReturn) values (?,?,?,?,?,?,?)";

            //insert missing values in their positions, using a prepared statement
            ps = conn.prepareStatement(sql);
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
            success=true;

        }catch(SQLException se){
            se.printStackTrace();
        }

        return success;
    }

    //method called when a car is reserved -- changes: availability to NO, reservations table adding person id, regNo fname,sname,phone, address
    public  boolean reserveCar(String regNo, String id, String fname, String sname, String phone, String address){
        boolean success = false;

        try{
            //change the car's availability to N -- i.e car is no longer available
            sql =  "update cars set available='N' where regNo=?";

            //insert missing values in their positions, using a prepared statement
            ps = conn.prepareStatement(sql);
            ps.setString(1, regNo);

            //execute the prepared statement
            ps.executeUpdate();

            //add the details to the reservations table
            sql = "insert into reservations (regNo, id, fname, sname, phone, address) values (?,?,?,?,?,?)";

            //initialise ps afresh
            ps = conn.prepareStatement(sql);
            //insert missing portions
            ps.setString(1, regNo);
            ps.setString(2, id);
            ps.setString(3, fname);
            ps.setString(4, sname);
            ps.setString(5, phone);
            ps.setString(6, address);

            //execute second statement
            ps.executeUpdate();

            //close up
            ps.close();
            conn.close();
            success = true;

        }catch(SQLException se){
            se.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return success;
    }

    //method to return a car that was reserved -- simple set its availability to Yes
    public  boolean returnCar(String regNo){
        boolean success = false;

        try{
            //change the car's availability to Y -- i.e car is now available
            sql =  "update cars set available='Y' where regNo=?";

            //insert missing values in their positions, using a prepared statement
            ps = conn.prepareStatement(sql);
            ps.setString(1, regNo);

            //execute the prepared statement
            ps.executeUpdate();

            //remove the details from the reservations table
            sql = "delete from reservations where regNo = ?";
            //initialise ps afresh
            ps = conn.prepareStatement(sql);

            //insert registration number
            ps.setString(1, regNo);

            //execute second statement
            ps.executeUpdate();

            //close up
            ps.close();
            conn.close();
            success = true;

        }catch(SQLException se){
            se.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return success;
    }

    //method to delete a car -- assumes regNo is correct
    public boolean deleteCar(String regNo){
        //boolean variable tracks if suuceesful or not
        boolean success = false;

        //statement to be exuted
        sql = "delete from cars where regNo=?";

        try{
            //create prepared statement using connection 00 supply sql
            ps = conn.prepareStatement(sql);

            //supply ? value -- enter regNo
            ps.setString(1, regNo);

            //execute statement
            ps.executeUpdate();

            //close up
            ps.close();
            conn.close();
            //set success to true
            success = true;

        }catch(SQLException se){
            System.out.println(se.getMessage());
            se.printStackTrace();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        return  success;
    }

    //method to get reserved cars
    public ArrayList<Car> getReservedCars() {

        //create array list to store car objects from db
        ArrayList<Car> carsList= new ArrayList<Car>();

        try {

            //Execute a query
            sql =  "select * from cars where available='N' order by make asc";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            //loop through and get results
            while (rs.next()){
                String make = rs.getString("make");
                String model = rs.getString("model");
                String regNo = rs.getString("regNo");
                int year = rs.getInt("year");
                String available = rs.getString("available");
                String url = rs.getString("url");

                //add a new car object with the properties above
                carsList.add(new Car(make, model, regNo, year, available,url));
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
        return carsList;
    }

    //method to get reservations
    public ArrayList<Reservation> getReservations() {

        //create array list to store car objects from db
        ArrayList<Reservation> reservations= new ArrayList<Reservation>();

        try {

            //Execute a query
            sql =  "select * from reservations, cars where reservations.regNo=cars.regNo ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            //loop through and get results
            while (rs.next()){
                //person's details
                String fname = rs.getString("fname");
                String sname = rs.getString("sname");
                int id = rs.getInt("id");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                //car details
                String make = rs.getString("make");
                String model = rs.getString("model");
                String regNo = rs.getString("regNo");
                int year = rs.getInt("year");
                String available = rs.getString("available");
                String url = rs.getString("url");

                //create a reservation object, add it to the reservations list
                Reservation res = new Reservation(fname, sname, phone, address, id, make, model,regNo, year, available, url);
                reservations.add(res);
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

        //return reservations to caller
        return reservations;
    }

    //method to authenticate user login credentials -- takes in supplied username and password
    public boolean authUser(String inUsername, String inPassword){
        boolean success = false;
        try {
            //check password of matching user
            sql =  "select password from users where username=?";
            ps = conn.prepareStatement(sql);

            //insert missing values
            ps.setString(1, inUsername);
            //get password string
            rs = ps.executeQuery();

            //store password from database
            String password = "";
            //loop through and get results
            while (rs.next()){
                //get password string
                password = rs.getString("password");
            }

            //if user does not exist, password will be blank
            if(password.equals("")){
                //username does not exist
                success  = false;
            }
            else if (password.equals(inPassword)){
                //username exists and password is not blank
                //check for equivalence -- if password matches
                success = true;
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

        return success;
    }
}
    

