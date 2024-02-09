package aa4_woodshops;

public class Articulo extends Producto {
    private TipoArticulo tipoArticulo;

    public Articulo(String codigo, String descripcion, Proveedor proveedor, double precioVenta, int stock, TipoArticulo tipoArticulo) {
        super(codigo, descripcion, proveedor, precioVenta, stock);
        this.tipoArticulo = tipoArticulo;
    }

    // Getter y setter específico para tipoArticulo
    public TipoArticulo getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(TipoArticulo tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    // Método para obtener el tipo de artículo como texto
    public String getTipo() {
        return tipoArticulo.toString();
    }

    // Enum para representar los tipos de artículo
    public enum TipoArticulo {
        ESTANTERIA,
        MESA,
        SILLA,
        ARMARIO,
        // Agregar otros tipos de artículo según sea necesario
    }
}
