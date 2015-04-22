package Clases;

/**
 *
 * @author estebanfcv
 */
public class DescripcionImagenTO {
    
    private String nombre;
    private String descripcion;

    public DescripcionImagenTO() {
    }

    public DescripcionImagenTO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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
