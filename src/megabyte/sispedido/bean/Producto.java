/*
 * Producto.java
 *
 */

package megabyte.sispedido.bean;
/**
 * @author Adrian
 */
public class Producto {

    private int iDProducto = 0;
    private String descripcion;
    private double precio = 0;
    
    /** Creates a new instance of Producto */
    public Producto() {
    }

    public Producto(int iDProducto) {
        this.iDProducto = iDProducto;
    }

    public Producto(int iDProducto, String descripcion, double precio) {
        this.iDProducto = iDProducto;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getIDProducto() {
        return this.iDProducto;
    }

    public void setIDProducto(int iDProducto) {
        this.iDProducto = iDProducto;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
