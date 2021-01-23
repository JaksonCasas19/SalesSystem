package megabyte.sispedido.bean;
public class DetallePedido {

    private int iDDetalle;
    private int iDPedido;
    private Producto producto = new Producto();
    private int cantidad = 0;
    private double totalDetalle = 0;
    
    /**
     * Creates a new instance of DetallePedido
     */
    public DetallePedido() {
    }

    public DetallePedido(int iDDetalle) {
        this.iDDetalle = iDDetalle;
    }

    public DetallePedido(int iDDetalle, int iDPedido, Producto producto, int cantidad, double descuento) {
        this.iDDetalle = iDDetalle;
        this.iDPedido = iDPedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.totalDetalle = cantidad * producto.getPrecio();
    }

    public int getIDDetalle() {
        return this.iDDetalle;
    }

    public void setIDDetalle(int iDDetalle) {
        this.iDDetalle = iDDetalle;
    }

    public int getIDPedido() {
        return this.iDPedido;
    }

    public void setIDPedido(int iDPedido) {
        this.iDPedido = iDPedido;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        totalDetalle = cantidad * producto.getPrecio(); 
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        totalDetalle = cantidad * producto.getPrecio(); 
    }

    public double getTotalDetalle() {
        return this.totalDetalle;
    }

}
