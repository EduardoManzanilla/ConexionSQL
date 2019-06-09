/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author eduar
 */
public class ConexionSQL {
    
    public static Connection getConnection(){
        Connection connection = null;
        String dbName= "PruebaA";
        String user= "sa";
        String pass= "root";
        
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionDB = "jdbc:sqlserver://LAPTOP-DOMK2QJP:1433;databaseName=PruebaA";
        connection =DriverManager.getConnection(connectionDB, user, pass);
        
        }catch(ClassNotFoundException e){
            System.out.println("Error: "+ e.getMessage());
        }catch(SQLException e){
            System.out.println("Error: "+ e.getMessage());
        }catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        
        return connection;

}

   
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
      if(ConexionSQL.getConnection()!= null){
        System.out.println("Nos conectamos");
      }
     Statement st = ConexionSQL.getConnection().createStatement();
      st.execute("insert into Db_paciente values ('','eduardo','manzanilla','colonial')");
    }
    
    
}
