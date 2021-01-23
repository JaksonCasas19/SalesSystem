/*
 * DAO.java
 *
 *
 */

package megabyte.sispedido.dao;

import java.sql.*;

/**
 *
 * @author Adrian
 */
public class DAO {
    private static Connection con = null;
    private Statement st = null;
    protected ResultSet rs = null;
    
    /** Creates a new instance of DAO */
    public DAO(Connection con) {
        this.con = con;
    }
    
    public DAO() {
        if (con == null)
            con = getConexion();        
    }
    
   private Connection getConexion(){
        Connection cn=null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Proyecto","pescado2");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al conectar BD " + e.getMessage());         
        }
        return cn;
    }
    
    public void cerrarConexion(){
        if (con == null)
            return;
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al desconectar BD " + e.getMessage());         
        }
    }
    
    public void ejecutaSelect(String csql) throws Exception{
        try {
            st = con.createStatement();
            rs = st.executeQuery(csql);
        } catch(Exception e) {
            rs= null;
            throw new java.sql.SQLException(e.getMessage());
        }
    }
    
    public void ejecutaUpdate(String csql) throws Exception{
        try {
            st = con.createStatement();
            st.executeUpdate(csql);
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
            throw new java.sql.SQLException(e.getMessage());
        }
        
    }
    
}
