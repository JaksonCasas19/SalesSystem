package megabyte.sispedido.bean;
public class Empleado {

    private int iDEmpleado;
    private String nombres;
    private String apellidos;
    private String cargo;
    
    /** Creates a new instance of Empleado */
    public Empleado() {
    }

    public Empleado(int iDEmpleado) {
        this.iDEmpleado = iDEmpleado;
    }

    public Empleado(int iDEmpleado, String nombres, String apellidos, String cargo) {
        this.iDEmpleado = iDEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
    }

    public int getIDEmpleado() {
        return this.iDEmpleado;
    }

    public void setIDEmpleado(int iDEmpleado) {
        this.iDEmpleado = iDEmpleado;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
