package megabyte.sispedido.bean;

public class Cliente {

    private int iDCliente = 0;
    private String nombre;
    private String ruc;
    private String contacto;
    private String direccion;
    private String telefono;
    private String email;
    
    /** Creates a new instance of Cliente */
    public Cliente() {
    }

    public Cliente(int iDCliente) {
        this.iDCliente = iDCliente;
    }

    public Cliente(int iDCliente, String nombre, String ruc, String contacto, String direccion, String telefono, String email) {
        this.iDCliente = iDCliente;
        this.nombre = nombre;
        this.ruc = ruc;
        this.contacto = contacto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public int getIDCliente() {
        return this.iDCliente;
    }

    public void setIDCliente(int iDCliente) {
        this.iDCliente = iDCliente;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return this.ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getContacto() {
        return this.contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
