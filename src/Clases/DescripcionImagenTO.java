package Clases;

/**
 *
 * @author estebanfcv
 */
public class DescripcionImagenTO {
    
    private String nombre;
    private String descripcion="";

    public DescripcionImagenTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
