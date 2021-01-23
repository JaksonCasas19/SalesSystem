/*
 * VisualizadorJasper.java
 */

package megabyte.sispedido.ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;



/**
 * @author anoriega
 */
public class VisualizadorJasper extends JFrame {
    
private JRViewer viewer = null;

    //Componentes visuais
    private JPanel panel = new JPanel();

    public VisualizadorJasper(JasperPrint jasperPrint)
        throws JRException {
        super("Reporte");

        try {
            this.viewer = new JRViewer( jasperPrint);
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() {
        //Setea panel
        this.panel.setLayout(new BorderLayout());
        this.panel.add(this.viewer, BorderLayout.CENTER);

        //Adiciona panel
        this.getContentPane().add(this.panel, BorderLayout.CENTER);
        this.pack();

        //Dimenciona viewer
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension(750, 550));
        this.setLocation((screenSize.width - 750) / 2,
            (screenSize.height - 550) / 2);
        this.setVisible(true);
    }

    public static void viewReport(JasperPrint jasperPrint)
        throws JRException {
        VisualizadorJasper jasperViewer = 
        	new VisualizadorJasper(jasperPrint);
        jasperViewer.setVisible(true);
    }

}
