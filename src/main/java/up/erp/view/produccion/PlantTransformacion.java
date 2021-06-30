package up.erp.view.produccion;

public class PlantTransformacion implements Cloneable{
    
    private int id;
    private String numero;
    private String nombre;

    public PlantTransformacion() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}