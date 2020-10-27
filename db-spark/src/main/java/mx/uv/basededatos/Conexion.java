package mx.uv.basededatos;

import java.sql.*;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;

public class Conexion {
    private static String url = "jdbc:mysql://127.0.0.1:3306/depresion?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
    private static String driverName ="com.mysql.cj.jdbc.Driver";
    private static String user = "root";
    private static String password ="";
    private static Connection conen = null;
    
    public static Connection getConnection(){
        try{
            Class.forName(driverName);
            conen = DriverManager.getConnection(url,user,password);
            System.out.println("salio bien");
        }catch(SQLException e){
            System.out.println("sql fallo");
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            System.out.println("el driver no se hallo F");
            e.printStackTrace();
        }
        return conen;
    }

}
