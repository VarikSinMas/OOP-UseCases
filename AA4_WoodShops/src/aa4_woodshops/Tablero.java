package aa4_woodshops;

public class Tablero extends Producto {
    private int altura;
    private int anchura;
    private TipoTablero tipoTablero;

    public Tablero(String codigo, String descripcion, Proveedor proveedor, double precioVenta, int stock, int altura, int anchura, TipoTablero tipoTablero) {
        super(codigo, descripcion, proveedor, precioVenta, stock);
        this.altura = altura;
        this.anchura = anchura;
        this.tipoTablero = tipoTablero;
    }

    // Getters y setters específicos para Tablero
    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAnchura() {
        return anchura;
    }

    public void setAnchura(int anchura) {
        this.anchura = anchura;
    }

    public TipoTablero getTipoTablero() {
        return tipoTablero;
    }

    public void setTipoTablero(TipoTablero tipoTablero) {
        this.tipoTablero = tipoTablero;
    }

    // Método para obtener el tipo de tablero como texto
    public String getTipo() {
        return tipoTablero.toString();
    }

    // Enum para representar los tipos de tablero
    public enum TipoTablero {
        AGLOMERADO,
        CONTRACHAPADO,
        MDF,
        // Agregar otros tipos según sea necesario
    }
}

