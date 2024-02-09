package aa4_woodshops;

public class ClienteProfesional extends Cliente {
    private double descuento;

    public ClienteProfesional(String nif, String nombre, double descuento) {
        super(nif, nombre, TipoCliente.PROFESIONAL);
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }
}

