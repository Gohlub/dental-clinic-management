package ReusableClasses;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class dbconnection {
                public static final String connectionstring = "jdbc:mysql://localhost:3306/clinic_database";
                public static final String databaseusername = "root";
                public static final String databasepassword = "kokoska12";

     public static java.sql.Connection conn=  null;
    
     public static java.sql.Connection connection(){
    
     try{  
        conn = DriverManager.getConnection(connectionstring, databaseusername,databasepassword);
        //System.out.println("Connected");
        return conn;   
     } catch(SQLException ex){
    
     JOptionPane.showMessageDialog(null, "There has been an error: " + ex);    
     }  
        return null;
     }
     }
