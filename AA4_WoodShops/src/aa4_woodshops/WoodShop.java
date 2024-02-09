package aa4_woodshops;
import java.util.ArrayList;
import java.util.List;

public class WoodShop {
    private String nifTienda;
    private String nombreTienda;
    private List<Tienda> tiendas = new ArrayList<>();
    private List<Proveedor> proveedores = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();

    public WoodShop(String nifTienda, String nombreTienda) {
        this.nifTienda = nifTienda;
        this.nombreTienda = nombreTienda;
    }


    public void agregarTienda(Tienda tienda) {
        tiendas.add(tienda);
    }

    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Tienda> getTiendas() {
        return tiendas;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    // Otros métodos para gestionar los datos

    public static void main(String[] args) {
        // Ejemplo de uso:
        WoodShop woodShop = new WoodShop("123456789A", "Mi Tienda");
        Proveedor proveedor1 = new Proveedor("P1", "Proveedor 1");
        Proveedor proveedor2 = new Proveedor("P2", "Proveedor 2");
        Producto producto1 = new Tablero("T1", "Tablero 1", proveedor1, 20.0, 100, 120, 60, Tablero.TipoTablero.AGLOMERADO);
        Producto producto2 = new Barniz("B1", "Barniz 1", proveedor2, 10.0, 50, 250, Barniz.TipoColorBarniz.CAOBA);
        Tienda tienda1 = new Tienda("Tienda 1");
        tienda1.agregarProducto(producto1);
        tienda1.agregarProducto(producto2);
        woodShop.agregarTienda(tienda1);
        woodShop.agregarProveedor(proveedor1);
        woodShop.agregarProveedor(proveedor2);
        woodShop.agregarProducto(producto1);
        woodShop.agregarProducto(producto2);

        // Realizar operaciones adicionales según el enunciado
    }
}

