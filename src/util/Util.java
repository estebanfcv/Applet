package util;

import ficheros.Fichero;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author estebanfcv
 */
public class Util {

    private static List<Integer> contadores = new ArrayList<Integer>();

    public static boolean validarEmail(String email) {
        Pattern pattern;
        pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void cerrarLecturaEscritura(PrintWriter pw, FileWriter fw) {
        try {
            if (pw != null) {
                pw.close();
            }
            if (fw != null) {
                fw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cerrarReaders(BufferedReader br, FileReader fr) {
        try {
            if (br != null) {
                br.close();
            }
            if (fr != null) {
                fr.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generarArchivos() {
        File estudiantes = new File(System.getProperty("user.home") + File.separator + "estudiantes.txt");
        File respuestas = new File(System.getProperty("user.home") + File.separator + "respuestas.txt");
        File configuracion = new File(System.getProperty("user.home") + File.separator + "config.txt");
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            estudiantes.createNewFile();
            respuestas.createNewFile();
            if (!configuracion.exists()) {
                configuracion.createNewFile();
                fw = new FileWriter(configuracion, false);
                pw = new PrintWriter(fw);
                pw.append("0|0").append("\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        } finally {
            cerrarLecturaEscritura(pw, fw);
        }
    }

    public static void armarListaContadores() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(new File(System.getProperty("user.home") + File.separator + "config.txt"));
            br = new BufferedReader(fr);
            String linea;
            if ((linea = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, "|");
                contadores.add(new Integer(st.nextToken()));
                contadores.add(new Integer(st.nextToken()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarReaders(br, fr);
        }
    }

    public static void actualizarContadores() {
        FileWriter fw = null;
        PrintWriter pw = null;
        File configuracion = new File(System.getProperty("user.home") + File.separator + "config.txt");
        try {
            if (configuracion.exists()) {
                fw = new FileWriter(configuracion, false);
                pw = new PrintWriter(fw);
                pw.append(Fichero.getContador() + "|" + Fichero.getContadorRespuestas()).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarLecturaEscritura(pw, fw);
        }
    }

    public static int getContadorEstudiantes() {
        return contadores.isEmpty() ? 0 : contadores.get(0);
    }

    public static int getContadorRespuestas() {
        return contadores.isEmpty() ? 0 : contadores.get(1);
    }

    public static float isNumero(String numero) {
        float f;
        try {
            f = Float.parseFloat(numero);
        } catch (Exception e) {
            f = 0;
            e.printStackTrace();
        }
        return f;
    }

    public static char getJavaVersion() {
        return System.getProperty("java.version").charAt(2);
    }
}
