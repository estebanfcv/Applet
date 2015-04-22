package ConexionBD;

import TO.DescripcionImagenTO;
import TO.EstudianteTO;
import TO.RespuestaTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estebanfcv
 */
public class AppletDAO {

    private static final Connection connection = ConexionBD.getConnection();

    public static List<EstudianteTO> obtenerEstudiantes() {
        List<EstudianteTO> listaEstudiantes = new ArrayList<EstudianteTO>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(Queries.CONSULTAR_ESTUDIANTES);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrarConexiones(rs, ps);
        }
        return listaEstudiantes;
    }

    public static EstudianteTO obtenerEstudiante(String email) {
        EstudianteTO estudiante = new EstudianteTO();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(Queries.CONSULTAR_ESTUDIANTES);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrarConexiones(rs, ps);
        }
        return estudiante;
    }

    public static int insertarEstudiante(EstudianteTO estudiante) {
        int id=0;
        PreparedStatement ps = null;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrarConexiones(null, ps);
        }
        return id;
    }

    public static boolean modificarCalificacionEstudiante(EstudianteTO estudiante) {
        boolean exito = false;
        PreparedStatement ps = null;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrarConexiones(null, ps);
        }
        return exito;
    }

    public static List<RespuestaTO> obtenerRespuestasEstudiante() {
        List<RespuestaTO> listaRespuestas = new ArrayList<RespuestaTO>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrarConexiones(rs, ps);
        }
        return listaRespuestas;
    }

    public static boolean insertarRespuestas(List<DescripcionImagenTO> lista, int id) {
        boolean exito = false;
        PreparedStatement ps = null;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrarConexiones(null, ps);
        }
        return exito;
    }
}
