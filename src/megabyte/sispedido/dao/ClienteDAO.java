/*
 * UsuarioDAO.java
 *
 */

package megabyte.sispedido.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import megabyte.sispedido.bean.Cliente;

public class ClienteDAO extends DAO {
    
    public ClienteDAO() {
        super();
    }
    
    public Cliente recordSetACliente(ResultSet rs) {
        Cliente c = new Cliente();
        try {
            c.setIDCliente(rs.getInt("IDCliente"));
            c.setNombre(rs.getString("Nombre"));
            c.setRuc(rs.getString("RUC"));
            c.setContacto(rs.getString("Contacto"));
            c.setDireccion(rs.getString("Direccion"));
            c.setTelefono(rs.getString("Telefono"));
            c.setEmail(rs.getString("Email"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
    
    public Cliente getClientexNombre(String nombre){
        Cliente c = new Cliente();
        String cSql = "select * from cliente where Nombre='" + nombre + "'";
        try {
            ejecutaSelect(cSql);
            if (rs.next()) {
                c = recordSetACliente(rs);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return c;
    }
    
    public Cliente getClientexID(String id){
        Cliente c = new Cliente();
        String cSql = "select * from cliente where IDCliente=" + id ;
        try {
            ejecutaSelect(cSql);
            if (rs.next()) {
                c = recordSetACliente(rs);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return c;
    }
    
    
    public Cliente nuevoCliente(Cliente c){
        String cSql = "insert into Cliente(IDCliente,Nombre, RUC, " +
                "Contacto, Direccion, Telefono, Email)" +
                "Values ( " +
                "'" + c.getIDCliente() + "', " +
                "'" + c.getNombre() + "', " +
                "'" + c.getRuc() + "', " +
                "'" + c.getContacto() + "', " +
                "'" + c.getDireccion() + "', " +
                "'" + c.getTelefono() + "', " +
                "'" + c.getEmail() + "') ";
        try {
            ejecutaUpdate(cSql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return getClientexNombre(c.getNombre());
    }
    
    public Cliente actualizaCliente(Cliente c){
        String cSql = "Update Cliente Set " +
          
                "Nombre='" + c.getNombre() + "', " +
                "RUC='" + c.getRuc() + "', " +
                "Contacto='" + c.getContacto() + "', " +
                "Direccion='" + c.getDireccion() + "', " +
                "Telefono='" + c.getTelefono() + "', " +
                "Email='" + c.getEmail() + "' " +
                "Where IDCliente=" + c.getIDCliente() ;
        try {
            ejecutaUpdate(cSql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return c;
    }
    
    public List<Cliente> getClientes() {
        List<Cliente> lst = new ArrayList<Cliente>();
        String cSql = "Select * from cliente order by nombre";
        try {
            ejecutaSelect(cSql);
            while (rs.next())
                lst.add(recordSetACliente(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
    public String[][] getArregloClientes(){
        List<Cliente> l = getClientes();
        String[][] ac = new String[l.size()][5];
        int i = 0;
        for (Cliente c : l) {
            ac[i][0] = Integer.toString(c.getIDCliente());
            ac[i][1] = c.getNombre();
            ac[i][2] = c.getRuc();
            ac[i][3] = c.getContacto();
            ac[i][4] = c.getTelefono();
            i++;
        }
        return ac;
    }
    
        
    public javax.swing.table.DefaultTableModel getClienteEnTabla() {
        return new javax.swing.table.DefaultTableModel(
            getArregloClientes(),
            new String [] {
                "ID Cliente", "Nombre", "RUC", "Contacto", "Telefono"
            })
            {
                Class[] types = new Class [] {
                        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            };
    }
   
    
}
