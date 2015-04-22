package TO;

import java.util.Date;

/**
 *
 * @author estebanfcv
 */
public class EstudianteTO {
    private int id;
    private String nombre;
    private String email;
    private float calificacion;
    private String retroalimentacionFinal;
    private String tiempo;
    private Date fecha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public String getRetroalimentacionFinal() {
        return retroalimentacionFinal;
    }

    public void setRetroalimentacionFinal(String retroalimentacionFinal) {
        this.retroalimentacionFinal = retroalimentacionFinal;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
