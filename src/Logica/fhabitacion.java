
package Logica;

import Datos.vhabitacion;
import com.mysql.jdbc.Connection;
import java.beans.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class fhabitacion {
  
    private conexion msyql=new conexion();
    private Connection cn=msyql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
    String [] titulos = ("ID","Numero","piso","Descripcion","Caracteristicas","Precio","Estado","Tipo habitacion");
    
    String [] registro =new String [8];
    
    totalregistros=0;
    modelo = new DefaultTableModel(null,titulos);
    
    sSQL="select * from habitacion  where pisos like '%"+ buscar + "%' order by idhabitacion" ;
    
        try {
            Statement st= cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            
            
            while (rs.next()){
                registro[0]=rs.getString("idhabitacion");
                registro[1]=rs.getString("numero");
                registro[2]=rs.getString("piso");
                registro[3]=rs.getString("descripcion");
                registro[4]=rs.getString("caracteristicas");
                registro[5]=rs.getString("precio_diario");
                registro[6]=rs.getString("registro");
                registro[7]=rs.getString("tipo_habitacion");
                
                totalregistros=totalregistros+1;
                
                modelo.addRow(registro);            
            }
         return modelo;
         
                    
                 
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
            
    
    }
      
    public boolean insertar (vhabitacion dts){
        sSQL="insert into habitacion (numero,piso,descripcion,caracteristicas,precio_diario,estado,tipo_habitacion) " +
                "values (?,?,?,?,?,?,?)";
        try {
            
            PreparedStatement pst=cn.preparedStatement (sSQL);
            pst.setString(1, dts.getNumero());
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getDescripcion());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecio_diario());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipo_habitacion());
            
            int n=pst.executeUpdate();
            
            if (n!=0){
                return true;
            }
            else {
                return false;
            }
            
            
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
            return false;
            
        }
 
    }     
     public boolean editar (vhabitacion dts){
         sSQL="Update habitacion set numero=?,piso=?,descripcion=?,caracteristicas=?,precio_diario=?,estado=?,tipo_habitacion=?,"+
                 " where idhabitacion=?,";
         
        try {
            PreparedStatement pst=cn.preparedStatement (sSQL);
            pst.setString(1, dts.getNumero());
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getDescripcion());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecio_diario());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipo_habitacion());
            pst.setInt(8, dts.getIdhabitacion());
            
            int n=pst.executeUpdate();
            
            if (n!=0){
                return true;
            }
            else {
                return false;
            }
            
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
            return false;
                   
            
        }
 
    }      
    
        public boolean eliminar (vhabitacion dts){
            sSQL="delete from habitacion where idhabitacion=?";
            
        try {
            PreparedStatement pst=cn.preparedStatement (sSQL);
           
            pst.setInt(1, dts.getIdhabitacion());
            
            int n=pst.executeUpdate();
            
            if (n!=0){
                return true;
            }
            else {
                return false;
            }
            
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
            return false;
        }
 
    }










} 
