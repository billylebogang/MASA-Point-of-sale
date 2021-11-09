package SalePoint;

/**
 *
 * @author lb19000961
 */
public class Users { //for making users
    private String username;
    private String password;
    private String userType;
    
    public Users(){
        this.username = "def";
        this.password = "mass";
        this.userType = "null";
    }
    
    public Users (String user, String pass, String type){
        this.username = user;
        this.password = pass;
        this.userType = type;
    
    }
    
    //set methods
    
    public void setUsername(String user){ this.username = user;}
    public void setPassword(String pass){ this.password = pass;}
    public void setUserType(String type){ this.userType = type;}
    
    //get method
    
    public String getUsername(){return this.username;}
    public String getPassword(){return this.password;}
    public String getUserType(){return this.userType;}
    
    
    
}
