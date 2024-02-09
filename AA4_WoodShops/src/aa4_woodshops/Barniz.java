package aa4_woodshops;

public class Barniz extends Producto {
    private int mililitros;
    private TipoColorBarniz tipoColor;

    public Barniz(String codigo, String descripcion, Proveedor proveedor, double precioVenta, int stock, int mililitros, TipoColorBarniz tipoColor) {
        super(codigo, descripcion, proveedor, precioVenta, stock);
        this.mililitros = mililitros;
        this.tipoColor = tipoColor;
    }

    // Getters y setters específicos para Barniz
    public int getMililitros() {
        return mililitros;
    }

    public void setMililitros(int mililitros) {
        this.mililitros = mililitros;
    }

    public TipoColorBarniz getTipoColor() {
        return tipoColor;
    }

    public void setTipoColor(TipoColorBarniz tipoColor) {
        this.tipoColor = tipoColor;
    }

    // Método para obtener el tipo de color del barniz como texto
    public String getTipo() {
        return tipoColor.toString();
    }

    // Enum para representar los tipos de color del barniz
    public enum TipoColorBarniz {
        INCOLORO,
        CAOBA,
        NOGAL,
        // Agregar otros colores según sea necesario
    }
}

