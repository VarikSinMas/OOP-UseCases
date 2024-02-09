package aa4_woodshops;

import java.time.LocalDate;
import java.util.List;

public class Venta {
    private int numeroTicket;
    private LocalDate fecha;  // Actualizado a LocalDate
    private Cliente cliente;
    private List<LineaTicket> lineasDetalle;

    public Venta(int numeroTicket, LocalDate fecha, Cliente cliente, List<LineaTicket> lineasDetalle) {
        this.numeroTicket = numeroTicket;
        this.fecha = fecha;
        this.cliente = cliente;
        this.lineasDetalle = lineasDetalle;
    }

    // Agrega otros métodos y lógica según sea necesario.

    // Método para obtener la fecha
    public LocalDate getFecha() {
        return fecha;
    }
}
