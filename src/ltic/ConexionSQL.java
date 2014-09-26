
package ltic;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Universidad
 */
public class ConexionSQL {
       Connection conexion=null;
        String bd = "ltic";
        String login = "ltic";
        String password = "abc123";
        String url = "jdbc:mysql://localhost/" + bd;
    public  Connection GetConnection()
    {
            
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

 public void insertar(String codigos,String codigor,String marca,String fecha,
            int tipo,float precio,int  fibra,int  borde){

        Connection conn = null;
        ResultSet rs= null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection(url, login, password);
            Statement estatuto = conn.createStatement();
            
            
        estatuto.executeUpdate("Insert into Switch(CODIGOSWITCH,CODIGORACK,MARCASWITCH,FECHACOMPRASWITCH,TIPOSWITCH"
                 + ",PRECIOSWITCH,FIBRAOPTICASWITCH,BORDESWITCH)"
                 + " values('"+codigos+"','"+codigor+"','"+marca+"','"+fecha+"',"+tipo+","+precio+","+fibra+","+borde+")");
   
            if (conn != null) {
                System.out.println("Conexión a base de datos " + url + " ... Ok");
                estatuto.close();
                conn.close();//cierre de conexion    
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }}
        
    
    
    public void devolderdatos(JComboBox comborack)
{
    Connection conn = null;
        ResultSet rs= null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection(url, login, password);
            Statement estatuto = conn.createStatement();
             rs=estatuto.executeQuery("select codigorack from rack");
             while(rs.next())
            {
                comborack.addItem(rs.getString("codigorack"));   //PRUEBA          
            }
            if (conn != null) {
                System.out.println("Conexión a base de datos " + url + " ... Ok");
                estatuto.close();
                conn.close();//cierre de conexion    
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
}

    
public void retornardatos(JTextField a,JTextField b,JTextField c,JTextField d,
        JTextField g, JComboBox x,JComboBox y,JComboBox z)
{
    Connection conn = null;
        ResultSet rs= null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection(url, login, password);
            Statement estatuto = conn.createStatement();
             rs=estatuto.executeQuery("Select * from Switch where codigoSWITCH='"+g.getText()+"'");
             while(rs.next())
            {
                
                a.setText(rs.getString("MARCASWITCH"));
                b.setText(rs.getString("FECHACOMPRASWITCH"));
                 c.setText(""+rs.getInt("TIPOSWITCH"));
                 x.setSelectedItem(rs.getString("CodigoRack"));
                // y.setSelectedItem(""+rs.getInt("bordeswitch"));
                 //z.setSelectedItem(""+rs.getInt("fibraopticaswitch"));
                d.setText(""+rs.getFloat("PRECIOSWITCH"));
            }

            if (conn != null) {
                System.out.println("Conexión a base de datos " + url + " ... Ok");
                estatuto.close();
                conn.close();//cierre de conexion    
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
}    
    
 public void modificarDatos(JComboBox  a,JTextField b,JTextField c,JTextField d,JTextField e,JComboBox f,JComboBox g,JTextField x)
{
 Connection conn = null;
        ResultSet rs= null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection(url, login, password);
            Statement estatuto = conn.createStatement();
            String codigorack=(String)a.getSelectedItem();
            int fibra;
            int borde;
        if(((String)f.getSelectedItem()).compareTo("si")==0)
        { fibra=1; }
        else
        {fibra=0;}

         if(((String)g.getSelectedItem()).compareTo("si")==0)
        { borde=1; }
        else
        {borde=0;}
         
         
          estatuto.executeUpdate("UPDATE Switch set codigorack='"+codigorack+"',MARCASWITCH='"+b.getText()+"',FECHACOMPRASWITCH='"+c.getText()+"',TIPOSWITCH="+d.getText()+",PRECIOSWITCH="+e.getText()+",FIBRAOPTICASWITCH="+fibra+",BORDESWITCH="+borde+" where codigoswitch='"+x.getText()+ "'");
 
            if (conn != null) {
                System.out.println("Conexión a base de datos " + url + " ... Ok");
          
                estatuto.close();
                conn.close();//cierre de conexion    
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
       
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } 
       
}

  public void eliminar(String codigo)
   {
       Connection conn = null;
        ResultSet rs= null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection(url, login, password);
            Statement estatuto = conn.createStatement();
             estatuto.executeUpdate("Delete from Switch where codigoswitch='"+codigo+"'");
            if (conn != null) {
                System.out.println("Conexión a base de datos " + url + " ... Ok");
                estatuto.close();
                conn.close();//cierre de conexion    
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }  
    }

}

