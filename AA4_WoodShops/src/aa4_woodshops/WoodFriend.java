package aa4_woodshops;

public class WoodFriend extends Cliente {
    private String codigoSocio;

    public WoodFriend(String nif, String nombre, String codigoSocio) {
        super(nif, nombre, TipoCliente.WOODFRIEND);
        this.codigoSocio = codigoSocio;
    }

    public String getCodigoSocio() {
        return codigoSocio;
    }
}

