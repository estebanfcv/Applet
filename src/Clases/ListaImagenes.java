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
        lista.clear();
        lista.add(new DescripcionImagenTO("/imagenes/aplicacionWeb.png"));
        lista.add(new DescripcionImagenTO("/imagenes/chrome.png"));
        lista.add(new DescripcionImagenTO("/imagenes/css.png"));
        lista.add(new DescripcionImagenTO("/imagenes/firefox.png"));
        lista.add(new DescripcionImagenTO("/imagenes/glassfish.png"));
        lista.add(new DescripcionImagenTO("/imagenes/icefaces.png"));
        lista.add(new DescripcionImagenTO("/imagenes/jasperReports.png"));
        lista.add(new DescripcionImagenTO("/imagenes/java.png"));
        lista.add(new DescripcionImagenTO("/imagenes/linux.png"));
        lista.add(new DescripcionImagenTO("/imagenes/mysql.png"));
        lista.add(new DescripcionImagenTO("/imagenes/navicat.png"));
        lista.add(new DescripcionImagenTO("/imagenes/netbeans.png"));
        lista.add(new DescripcionImagenTO("/imagenes/servlet.png"));
        lista.add(new DescripcionImagenTO("/imagenes/xhtml.png"));
    }

    public static String getNombreImagen(int i) {
        try {
            return lista.get(i).getNombre();
        } catch (Exception e) {
            return "";
        }

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
