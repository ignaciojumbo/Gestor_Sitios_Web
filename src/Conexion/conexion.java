
package Conexion;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;


public class conexion {
    private final String base = "gestorpagina";
    private final String user = "root";
    private final String password = "101219931";
    private final String url = "jdbc:mysql://Localhost:3306/" + base;
    

    public Connection getConexion() {
        Connection con = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, user, password);
            //JOptionPane.showMessageDialog(null, "Conexion exitosa");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
        return con;
    }
    
}
