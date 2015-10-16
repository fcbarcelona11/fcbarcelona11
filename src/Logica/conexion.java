
package Logica;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexion {
    public String db="basereserva";
    public String url="jdbc:mysql;//127.0.0.1/" + db;
    //ese numero 127.0.0.1 es la ip de la base de datos...video03
   public String user="root";
   public String pass="";

    public conexion() {
    }
   public Connection conectar(){
        Connection link=null;
       
        try {
           Class.forName("org.gjt.mm.mysql.Driver");
           link=(Connection) DriverManager.getConnection(this.url, this.user, this.pass);
           
           //connection no estaba hay que borrar
       } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
       }
       
        
        return link;
   }
   
   
}
