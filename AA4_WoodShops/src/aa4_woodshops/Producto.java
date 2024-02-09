package aa4_woodshops;
import java.util.ArrayList;
import java.util.List;

public abstract class Producto {
    private String codigo;
    private String descripcion;
    private Proveedor proveedor;
    private double precioVenta;

    private int stock;

    public Producto(String codigo, String descripcion, Proveedor proveedor, double precioVenta, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    //Método para añadir stock a un producto ya existente en una tienda.
    public void addStock(int cantidad) {
        this.stock += cantidad;
    }
    // Getters y setters para los atributos
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }


    public void setStock(int stock) {
        this.stock = stock;
    }

    // Método abstracto que deberá implementarse en las subclases
    public abstract String getTipo();
}

