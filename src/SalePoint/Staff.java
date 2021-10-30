package SalePoint;

/**
 * Billy Lebogang
 * @author lb19000961
 */
public class Staff {
    //instances
    String name;
    String surname;
    String birthdate;
    String omangId;
    String userType;
    String dateHired;
    String number;
    String password;
    
    //contructors
    public Staff(){
        this.name = "null";
        this.surname = "null";
        this.birthdate = "null";
        this.omangId = "null";
        this.userType = "null";
        this.dateHired = "null";
        this.number = "null";
        this.password = "null";
    
    }
    public Staff(String Name, String Surname, String Birthdate, String OmangId, String UserType, String DateHired, String Number, String Password){
        
        this.name = Name;
        this.surname = Surname;
        this.birthdate = Birthdate;
        this.omangId = OmangId;
        this.userType = UserType;
        this.dateHired = DateHired;
        this.number = Number;
        this.password = Password;
    }
    
    //set methods
    public void setName(String newName){
        this.name = newName;
    }    
    public void setSurname(String newSurname){
        this.surname = newSurname;
    }
    public void setBirthdate(String newBirthdate){
        this.birthdate = newBirthdate;
    }    
    public void setOmangId(String newOmang){
        this.omangId = newOmang;
    }
    public void setUserType(String newUserType){
        this.userType = newUserType;
    }
    public void setDateHired(String newDate){
        this.dateHired= newDate;
    }    
    public void setNumber(String newNum){
        this.number = newNum;
    }     
    public void setPassword(String newPass){
        this.password = newPass;
    }
    
    //get methods
       
       public String getName(){
           return this.name;
       }
       
       public String getSurname(){
           return this.surname;
       }
       
       public String getBirthdate(){
           return this.birthdate;
       }
       public String getOmangId(){
           return this.omangId;
       }
       public String getUserType(){
           return this.userType;
       }
       public String getDatehired(){
           return this.dateHired;
       }
       public String getNumber(){
           return this.number;
       }
       public String getPassword(){
           return this.password;
       }
    //toString method
    public String toString(){
        return this.name +" |"+ this.surname +" |"+ this.birthdate +" |"+ this.omangId +" |"+ this.dateHired+" |"+ this.userType +" |"+this.number +" |"+ this.password;
    }
}
