
package ltic;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Universidad
 */
public class ConexionSQL {
      
    public static Connection GetConnection()
    {
        Connection conexion=null;
        String bd = "ltic";
        String login = "ltic";
        String password = "abc123";
        String url = "jdbc:mysql://localhost/" + bd;
        //hoy es martes
        //Yo soy JuanSe
      
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, login, password);
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        finally
        {
            return conexion;
        }
    }
}
