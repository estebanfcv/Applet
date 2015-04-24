package ficheros;

import TO.DescripcionImagenTO;
import TO.EstudianteTO;
import TO.RespuestaTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import util.Util;

/**
 *
 * @author estebanfcv
 */
public class Fichero {

    private static final File estudiantes = new File("/home/estebanfcv/estudiantes.txt");
    private static final File respuestas = new File("/home/estebanfcv/respuestas.txt");
    private static int contador = Util.getContadorEstudiantes();
    private static int contadorRespuestas = Util.getContadorRespuestas();

    public static List<EstudianteTO> obtenerEstudiantes() {
        List<EstudianteTO> listaEstudiantes = new ArrayList<EstudianteTO>();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(estudiantes);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                EstudianteTO e = new EstudianteTO();
                for (StringTokenizer st = new StringTokenizer(linea, "|"); st.hasMoreTokens();) {
                    e.setId(new Integer(st.nextToken()));
                    e.setNombre(st.nextToken());
                    e.setEmail(st.nextToken());
                    e.setTiempo(st.nextToken());
                    e.setFecha(new SimpleDateFormat("dd/MM/yyyy").parse(st.nextToken()));
                    e.setRetroalimentacion(st.nextToken());
                    e.setCalificacion(new Float(st.nextToken()));
                    listaEstudiantes.add(e);
                }
            }

            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.cerrarReaders(br, fr);
        }
        return listaEstudiantes;
    }

    public static EstudianteTO obtenerEstudiante(String email) {
        EstudianteTO estudiante = new EstudianteTO();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(estudiantes);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains(email)) {
                    for (StringTokenizer st = new StringTokenizer(linea, "|"); st.hasMoreTokens();) {
                        estudiante.setId(new Integer(st.nextToken()));
                        estudiante.setNombre(st.nextToken());
                        estudiante.setEmail(st.nextToken());
                        estudiante.setTiempo(st.nextToken());
                        estudiante.setFecha(new SimpleDateFormat("dd/MM/yyyy").parse(st.nextToken()));
                        estudiante.setRetroalimentacion(st.nextToken());
                        estudiante.setCalificacion(new Float(st.nextToken()));
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.cerrarReaders(br, fr);
        }
        return estudiante;
    }

    public static int registrarEstudiante(EstudianteTO estudiante) {
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            if (estudiantes.exists()) {
                fw = new FileWriter(estudiantes, true);
                pw = new PrintWriter(fw);
                String renglon = ++contador + "|" + estudiante.getNombre() + "|" + estudiante.getEmail() + "|"
                        + estudiante.getTiempo() + "|" + new SimpleDateFormat("dd/MM/yyyy").format(estudiante.getFecha()) + "|"
                        + estudiante.getRetroalimentacion() + "|" + estudiante.getCalificacion();
                pw.append(renglon).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.cerrarLecturaEscritura(pw, fw);
        }
        return contador;
    }

    public static boolean modificarCalificacionEstudiante(EstudianteTO estudiante) {
        boolean exito = false;
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            String texto = obtenerNuevoTexto(estudiante);
            fw = new FileWriter(estudiantes, false);
            pw = new PrintWriter(fw);
            pw.append(texto).append("\n");
            exito = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.cerrarLecturaEscritura(pw, fw);
        }
        return exito;

    }

    private static String obtenerNuevoTexto(EstudianteTO estudiante) {
        FileReader fr = null;
        BufferedReader br = null;
        String texto = "";
        String linea;
        try {
            fr = new FileReader(estudiantes);
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                System.out.println("la linea es::::: " + linea);
                if (linea.contains(estudiante.getEmail())) {
                    String renglon = estudiante.getId() + "|" + estudiante.getNombre() + "|" + estudiante.getEmail() + "|"
                            + estudiante.getTiempo() + "|" + new SimpleDateFormat("dd/MM/yyyy").format(estudiante.getFecha()) + "|"
                            + estudiante.getRetroalimentacion() + "|" + estudiante.getCalificacion();
                    System.out.println("el renglon es:::::: " + renglon);
                    texto += renglon + "\n";
                } else {
                    texto += linea + "\n";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.cerrarReaders(br, fr);
        }
        return texto;
    }

    public static List<RespuestaTO> obtenerRespuestasEstudiante(int id) {
        List<RespuestaTO> listaRespuestas = new ArrayList<RespuestaTO>();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(respuestas);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                for (StringTokenizer st = new StringTokenizer(linea, "|"); st.hasMoreTokens();) {
                    int idFile = new Integer(st.nextToken());
                    String pregunta = st.nextToken();
                    String respuesta = st.nextToken();
                    int idEstudiante = new Integer(st.nextToken());
                    if (idEstudiante == id) {
                        RespuestaTO r = new RespuestaTO();
                        r.setId(idFile);
                        r.setPregunta(pregunta);
                        r.setRespuesta(respuesta);
                        r.setIdEstudiante(idEstudiante);
                        listaRespuestas.add(r);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.cerrarReaders(br, fr);
        }
        return listaRespuestas;
    }

    public static boolean insertarRespuestas(List<DescripcionImagenTO> lista, int id) {
        boolean exito = false;
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(respuestas, true);
            pw = new PrintWriter(fw);
            for (DescripcionImagenTO di : lista) {
                String pregunta = di.getNombre().replace("/imagenes/", "");
                pregunta=pregunta.substring(0, pregunta.lastIndexOf("."));
                String renglon = ++contadorRespuestas + "|" + pregunta + "|" + di.getDescripcion() + "|" + id;
                pw.append(renglon).append("\n");
            }
            exito = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.cerrarLecturaEscritura(pw, fw);
        }
        return exito;
    }

    public static int getContador() {
        return contador;
    }

    public static int getContadorRespuestas() {
        return contadorRespuestas;
    }

}
