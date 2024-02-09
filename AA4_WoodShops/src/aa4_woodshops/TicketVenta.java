package aa4_woodshops;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TicketVenta {
    private static int numeroTicketGlobal = 1; // Variable estática para generar números únicos de ticket
    private int numeroTicket;
    private LocalDate fecha;
    private Cliente cliente;
    private List<LineaTicket> lineasTicket;
    private double descuento;

    public TicketVenta() {
        this.numeroTicket = numeroTicketGlobal++;
        this.fecha = LocalDate.now(); // Fecha actual por defecto
        this.lineasTicket = new ArrayList<>();
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public double calcularTotal(boolean imprimirDetalles) {
        double total = 0;

        for (LineaTicket linea : lineasTicket) {
            if (imprimirDetalles) {
                System.out.println("Producto: " + linea.getProducto().getDescripcion());
                System.out.println("Cantidad: " + linea.getCantidad());
                System.out.println("Precio Unitario: " + String.format("%.2f", linea.getPrecioUnitario()));
                System.out.println("Subtotal: " + String.format("%.2f", linea.calcularSubtotal()));
                System.out.println("-------------------------");
            }

            total += linea.calcularSubtotal();
        }

        // Guardar el total antes de aplicar el descuento
        double totalAntesDescuento = total;

        // Aplicar descuento si hay uno
        double descuentoAplicado = total * (descuento / 100.0);

        // Mostrar el descuento aplicado si es mayor que 0
        if (descuentoAplicado > 0) {
            System.out.println("Descuento aplicado: " + String.format("%.2f", descuentoAplicado));
        }

        double totalConDescuento = total - descuentoAplicado;

        // Redondear el total después de restar el descuento
        totalConDescuento = Math.round(totalConDescuento * 100.0) / 100.0;

        return totalConDescuento;  // Devolver el total después del descuento
    }




    public LocalDate getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<LineaTicket> getLineasTicket() {
        return lineasTicket;
    }

    public void agregarLinea(LineaTicket lineaTicket) {
        this.lineasTicket.add(lineaTicket);
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    // Otros métodos necesarios, como calcular total, mostrar ticket completo, etc.
}
