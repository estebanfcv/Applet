package ConexionBD;

import TO.DescripcionImagenTO;
import TO.EstudianteTO;
import TO.RespuestaTO;
import java.sql.Connection;
import java.sql.Date;
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
            rs = ps.executeQuery();
            while (rs.next()) {
                EstudianteTO e = new EstudianteTO();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setEmail(rs.getString("email"));
                e.setCalificacion(rs.getFloat("calificacion"));
                e.setRetroalimentacion(rs.getString("retroalimentacion"));
                e.setTiempo(rs.getString("tiempo"));
                e.setFecha(rs.getDate("fecha"));
                listaEstudiantes.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrarConexiones(rs, ps);
        }
        return listaEstudiantes;
    }

    public static int obtenerEstudiante(String email) {
        int id = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = Queries.CONSULTAR_ESTUDIANTES + " WHERE email=?";
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            id = rs.next() ? rs.getInt("id") : 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrarConexiones(rs, ps);
        }
        return id;
    }

    public static int insertarEstudiante(EstudianteTO estudiante) {
        int id = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(Queries.INSERTAR_ESTUDIANTE, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getEmail());
            ps.setFloat(3, estudiante.getCalificacion());
            ps.setString(4, estudiante.getRetroalimentacion());
            System.out.println("el tiempo es:::::: " + estudiante.getTiempo());
            ps.setString(5, estudiante.getTiempo());
            ps.setDate(6, new Date(estudiante.getFecha().getTime()));
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            id = rs.next() ? rs.getInt(1) : 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrarConexiones(rs, ps);
        }
        return id;
    }

    public static boolean modificarCalificacionEstudiante(EstudianteTO estudiante) {
        boolean exito = false;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(Queries.MODIFICAR_CALIFICACION);
            ps.setFloat(1, estudiante.getCalificacion());
            ps.setString(2, estudiante.getRetroalimentacion());
            ps.setInt(3, estudiante.getId());
            ps.executeUpdate();
            exito = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrarConexiones(null, ps);
        }
        return exito;
    }

    public static List<RespuestaTO> obtenerRespuestasEstudiante(int id) {
        List<RespuestaTO> listaRespuestas = new ArrayList<RespuestaTO>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(Queries.CONSULTAR_RESPUESTAS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                RespuestaTO r = new RespuestaTO();
                r.setId(rs.getInt("id"));
                r.setPregunta(rs.getString("pregunta"));
                r.setRespuesta(rs.getString("respuesta"));
                r.setIdEstudiante(rs.getInt("id_estudiante"));
                listaRespuestas.add(r);
            }
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
            ps = connection.prepareStatement(Queries.INSERTAR_RESPUESTAS);
            ps.setInt(3, id);
            for (DescripcionImagenTO di : lista) {
                ps.setString(1, di.getNombre());
                ps.setString(2, di.getDescripcion());
                ps.addBatch();
            }
            ps.executeBatch();
            exito = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrarConexiones(null, ps);
        }
        return exito;
    }
}
