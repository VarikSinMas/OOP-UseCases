package aa4_woodshops;

public class LineaTicket {
    private Producto producto;
    private int cantidad;

    public LineaTicket(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }


    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return producto.getPrecioVenta(); // Ajusta esto según la lógica de tu aplicación
    }

    public double calcularSubtotal() {
        return cantidad * getPrecioUnitario();
    }

    // Otros métodos de la clase LineaTicket según sea necesario
}


