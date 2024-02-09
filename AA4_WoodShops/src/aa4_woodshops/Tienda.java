package aa4_woodshops;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private String nombre;
    private List<Producto> almacen = new ArrayList<>();

    public Tienda(String nombre) {
        this.nombre = nombre;
    }

    public void agregarProducto(Producto producto) {
        almacen.add(producto);
    }

    public List<TicketVenta> listarVentasPorFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        List<TicketVenta> ventasFiltradas = new ArrayList<>();

        for (TicketVenta ticketVenta : ventas) {
            LocalDate fechaVenta = ticketVenta.getFecha();

            // Verificar si la fecha de la venta está dentro del rango especificado
            if ((fechaVenta.isEqual(fechaInicio) || fechaVenta.isAfter(fechaInicio)) &&
                    (fechaVenta.isEqual(fechaFin) || fechaVenta.isBefore(fechaFin))) {
                ventasFiltradas.add(ticketVenta);
            }
        }

        return ventasFiltradas;
    }




    public List<Producto> listarProductosPorTipo(String tipo) {
        List<Producto> productosPorTipo = new ArrayList<>();

        for (Producto producto : this.almacen) {
            if (producto instanceof Tablero && tipo.equals("Tablero")) {
                productosPorTipo.add(producto);
            } else if (producto instanceof Barniz && tipo.equals("Barniz")) {
                productosPorTipo.add(producto);
            } else if (producto instanceof Articulo && tipo.equals("Artículo")) {
                productosPorTipo.add(producto);
            }
        }

        return productosPorTipo;
    }

    private List<TicketVenta> ventas = new ArrayList<>();

    public void agregarVenta(TicketVenta venta) {
        ventas.add(venta);
    }

    public List<TicketVenta> getVentas() {
        return new ArrayList<>(ventas);
    }

    public List<TicketVenta> listarTicketsPorFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        List<TicketVenta> ticketsFiltrados = new ArrayList<>();

        for (TicketVenta ticket : ventas) {
            LocalDate fechaTicket = ticket.getFecha();
            if ((fechaTicket.isEqual(fechaInicio) || fechaTicket.isAfter(fechaInicio)) &&
                    (fechaTicket.isEqual(fechaFin) || fechaTicket.isBefore(fechaFin))) {
                ticketsFiltrados.add(ticket);
            }
        }

        return ticketsFiltrados;
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(almacen);
    }

    public int obtenerStockProducto(String codigo) {
        int stockTotal = 0;
        for (Producto producto : almacen) {
            if (producto.getCodigo().equals(codigo)) {
                stockTotal += producto.getStock();
            }
        }
        return stockTotal;
    }

    public String getNombreTienda() {
        return this.nombre;
    }
    // Otros métodos relacionados con la tienda según sea necesario
}
