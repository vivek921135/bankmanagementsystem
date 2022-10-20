package bank.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        // there are so many runtime error occurs when we connect java with database bcoz sql is external entity so for catching those errors we use try and catch
    try{
     
     c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Dinesh@1968");
     s=c.createStatement();
     
} catch(Exception e){
    System.out.println(e);
}
    
}
}

