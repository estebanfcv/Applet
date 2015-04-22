package Clases;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author estebanfcv
 */
public class ListaImagenes {

    private static final List<DescripcionImagenTO> lista = new ArrayList<DescripcionImagenTO>();
    private JTextArea jTextArea;

    public ListaImagenes() {
       
        lista.add(new DescripcionImagenTO("/imagenes/ardilla.png", ""));
         lista.add(new DescripcionImagenTO("/imagenes/emma.jpg", ""));

    }

    public static String obtenerImagen(int i) {
        return lista.get(i).getNombre();
    }

    public static void setDescripcion(int i, String descripcion) {
        System.out.println("descripcion vale:::::: "+descripcion);
        lista.get(i).setDescripcion(descripcion);
        for (DescripcionImagenTO d : lista) {
            System.out.println("el nombre es:::: "+d.getNombre()+" la descripcion es::::: "+d.getDescripcion());
        }
    }

    public static String getDescripcion(int i) {
        return lista.get(i).getDescripcion();
    }

    public static int getTamanio() {
        return lista.size();
    }

}
