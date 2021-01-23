package megabyte.sispedido.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pedido {

    private int iDPedido = 0;
    private Cliente cliente;
    private String fechaPedido;
    private double subTotal = 0;
    private double total = 0;
    private double igv = 0;
    private List<DetallePedido> detalle = new ArrayList<DetallePedido>();
    
    /** Creates a new instance of Pedido */
    public Pedido() {
        setFechaPedido();
    }

    public Pedido(int iDPedido) {
        this.iDPedido = iDPedido;
    }

    public Pedido(int iDPedido, Cliente cliente, int iDEmpleado, String fechaPedido, double subTotal, double total, double igv) {
        this.iDPedido = iDPedido;
        this.cliente = cliente;
        this.fechaPedido = fechaPedido;
        this.subTotal = subTotal;
        this.total = total;
        this.igv = igv;
    }

    public int getIDPedido() {
        return this.iDPedido;
    }

    public List<DetallePedido> getDetalle() {
        return this.detalle;
    }
    
    public String[][] getArregloDetalle(){
        String[][] ac = new String[detalle.size()][5];
        int i = 0;
        for (DetallePedido d : detalle) {
            ac[i][0] = Integer.toString(i + 1);
            ac[i][1] = d.getProducto().getDescripcion();
            ac[i][2] = Double.toString(d.getProducto().getPrecio());
            ac[i][3] = Integer.toString(d.getCantidad());
            ac[i][4] = Double.toString(d.getTotalDetalle());
            i++;
        }
        return ac;
    }


    public void setIDPedido(int iDPedido) {
        this.iDPedido = iDPedido;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFechaPedido() {
        return this.fechaPedido;
    }
    
    public String getFechaPedidoMySql() {
        return fechaPedido.substring(6) + 
                fechaPedido.substring(3, 4) +
                fechaPedido.substring(0, 1);
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setFechaPedido() {
        Calendar c = new GregorianCalendar();
        this.fechaPedido = (c.get(Calendar.DATE) < 10 ? "0" : "") +
                            Integer.toString(c.get(Calendar.DATE)) + "/" +
                            (c.get(Calendar.MONTH) < 9 ? "0" : "") + 
                            Integer.toString(c.get(Calendar.MONTH) + 1) + "/" +
                            Integer.toString(c.get(Calendar.YEAR));
    }
    
    public double getSubTotal() {
        return this.subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIgv() {
        return this.igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public void setDetalle(List<DetallePedido> detalle) {
        this.detalle = detalle;
    }
    
    public void addDetalle(DetallePedido detPedido) {
        detPedido.setIDPedido(detalle.size() + 1);
        detPedido.setIDPedido(this.iDPedido);
        subTotal += detPedido.getTotalDetalle();
        igv = subTotal * 0.18;
        total = subTotal + igv;
        detalle.add(detPedido);        
    }
    
    public void quitaDetalle(int i) {
        if (detalle.size() == 0)
            return;
        DetallePedido detPedido = detalle.get(i);
        subTotal -= detPedido.getTotalDetalle();
        igv = subTotal * 0.18;
        total = subTotal + igv;
        detalle.remove(i);        
    }
    
    public List<Map> getDetalleEnMap() {
        List<Map> l = new ArrayList();
        Map m = new HashMap();
        for (DetallePedido d : detalle) {
            m = new HashMap();
            m.put("Item", Integer.toString(l.size() + 1));
            m.put("Producto", d.getProducto().getDescripcion());
            m.put("Precio", d.getProducto().getPrecio());
            m.put("Cantidad", Integer.toString(d.getCantidad()));
            m.put("TotalProducto", d.getTotalDetalle());
            l.add(m);
        }
        return l;
    }
    
        public javax.swing.table.DefaultTableModel getDetalleEnTabla() {
        return new javax.swing.table.DefaultTableModel(
            getArregloDetalle(),
            new String [] {
                "Item", "Producto", "Precio Unitario", "Cantidad", "Total"
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
