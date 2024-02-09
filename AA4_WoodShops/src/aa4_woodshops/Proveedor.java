package aa4_woodshops;
import java.util.ArrayList;
import java.util.List;

public class Proveedor {
    private String nif;
    private String nombre;

    // Lista estática de proveedores
    private static List<Proveedor> proveedores = new ArrayList<>();

    public Proveedor(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;

        // Agregar el proveedor a la lista estática
        proveedores.add(this);
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Otros métodos relacionados con el proveedor según sea necesario

    // Método para obtener la lista de proveedores
    public static List<Proveedor> getProveedores() {
        return proveedores;
    }
}
