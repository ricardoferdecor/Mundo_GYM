package Conexion;

/**
 *
 * @author ricardo
 */
import java.sql.*;
public class MySQLConexion {
    public static Connection getConnection(){
        Connection cnx=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost/bd_mg";
            String usr="root";
            String psw="";
            cnx = DriverManager.getConnection(url, usr, psw);
            System.out.println("Conectaste a la BD!");
        } catch (ClassNotFoundException ex) {
            System.out.println("No hay driver!!");
        } catch(SQLException ex){
            System.out.println("Error con la BD!!!");
        }
        return cnx;
    }    
}
