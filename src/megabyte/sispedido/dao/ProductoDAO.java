/*
 * UsuarioDAO.java
 *
 */

package megabyte.sispedido.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import megabyte.sispedido.bean.Cliente;
import megabyte.sispedido.bean.Producto;

public class ProductoDAO extends DAO {
    
    public ProductoDAO() {
        super();
    }

    public Producto recordSetAProducto (ResultSet rs) {
        Producto p = new Producto();
        try {
                p.setIDProducto(rs.getInt("IDProducto"));
                p.setDescripcion(rs.getString("Descripcion"));
                p.setPrecio(rs.getDouble("Precio"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
    
    public Producto getProductoxDesc(String desc){
        Producto p = new Producto();
        String cSql = "select * from producto where Descripcion='" + desc + "'";
        try {
            ejecutaSelect(cSql);
            if (rs.next()) {
                p = recordSetAProducto(rs);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return p;
    }

    public Producto getProductoxID(String id){
        Producto p = new Producto();
        String cSql = "select * from producto where IDProducto='" + id + "'";
        try {
            ejecutaSelect(cSql);
            if (rs.next()) {
                p = recordSetAProducto(rs);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return p;
    }
    
    
    public Producto nuevoProducto(Producto p){
        String cSql = "insert into Producto(IDProducto,Descripcion, " +
                "Precio)" +
                "Values ( " +
                "'" + p.getIDProducto() + "', " +
                "'" + p.getDescripcion() + "', " +
                " " + p.getPrecio() + " ) ";
        try {
            ejecutaUpdate(cSql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return getProductoxDesc(p.getDescripcion());
    }

        public Producto actualizaProducto(Producto p){
        String cSql = "Update Producto Set " +
                "Descripcion='" + p.getDescripcion() + "', " +
                "Precio=" + p.getPrecio() + " " +
                "Where IDProducto=" + p.getIDProducto() ;
        try {
            ejecutaUpdate(cSql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return p;
    }

    public List<Producto> getProductos() {
        List<Producto> lst = new ArrayList<Producto>();
        String cSql = "Select * from producto order by descripcion";
        try {
            ejecutaSelect(cSql);
            while (rs.next())                  
                lst.add(recordSetAProducto(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;        
    }
    
    public String[][] getArregloProductos(){        
        List<Producto> l = getProductos();
        String[][] ap = new String[l.size()][3];
        int i = 0;
        for (Producto p : l) {
            ap[i][0] = Integer.toString(p.getIDProducto());
            ap[i][1] = p.getDescripcion();
            ap[i][2] = Double.toString(p.getPrecio());
            i++;
        }
        return ap;
    }
    
    
    public javax.swing.table.DefaultTableModel getProductoEnTabla() {
        return new javax.swing.table.DefaultTableModel(
            getArregloProductos(),
            new String [] {
                "ID Producto", "Descripcion", "Precio"
            })
            {
                Class[] types = new Class [] {
                        java.lang.String.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false
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
