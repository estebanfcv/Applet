package Clases;

import TO.DescripcionImagenTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estebanfcv
 */
public class ListaImagenes {

    private static final List<DescripcionImagenTO> lista = new ArrayList<DescripcionImagenTO>();

    public static void armarListaImagenes() {
        lista.add(new DescripcionImagenTO("/imagenes/ardilla.png"));
        lista.add(new DescripcionImagenTO("/imagenes/emma.jpg"));
    }

    public static String getNombreImagen(int i) {
        return lista.get(i).getNombre();
    }

    public static String getDescripcion(int i) {
        return lista.get(i).getDescripcion();
    }

    public static int getTamanio() {
        return lista.size();
    }

    public static void setDescripcion(int i, String descripcion) {
        lista.get(i).setDescripcion(descripcion);
    }

    public static List<DescripcionImagenTO> getLista() {
        return lista;
    }
}
