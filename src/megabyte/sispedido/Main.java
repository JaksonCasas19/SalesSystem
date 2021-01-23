/*
 * Main.java
 *
 * Created on 20 de Junio de 2017
 *
 */

package megabyte.sispedido;

import megabyte.sispedido.dao.DAO;
import megabyte.sispedido.ventanas.Frame;
import megabyte.sispedido.ventanas.Login;

/**
 *
 * @author Adrian Noriega
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DAO dao = new DAO(); //acá abre la conexión y la mantiene
        new Frame().setVisible(true);         
    }
    
}
