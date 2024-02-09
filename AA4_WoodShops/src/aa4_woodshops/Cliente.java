package aa4_woodshops;

public class Cliente {
    private String nif;
    private String nombre;
    private TipoCliente tipoCliente;

    public Cliente(String nif, String nombre, TipoCliente tipoCliente) {
        this.nif = nif;
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }
}

