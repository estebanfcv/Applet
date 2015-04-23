package ConexionBD;

/**
 *
 * @author estebanfcv
 */
public class Queries {

    public static final String CONSULTAR_ESTUDIANTES = "select "
            + "id,"
            + "nombre,"
            + "email,"
            + "calificacion,"
            + "retroalimentacion,"
            + "tiempo,"
            + "fecha "
            + "from estudiantes";

    public static final String INSERTAR_ESTUDIANTE = "insert into estudiantes( "
            + "nombre,"
            + "email,"
            + "calificacion,"
            + "retroalimentacion,"
            + "tiempo,"
            + "fecha) "
            + "values(?,?,?,?,?,?)";

    public static final String MODIFICAR_CALIFICACION = "update estudiantes set "
            + "calificacion=?,"
            + "retroalimentacion=? "
            + "where id=?";

    public static final String CONSULTAR_RESPUESTAS = "select "
            + "id,"
            + "pregunta,"
            + "respuesta,"
            + "id_estudiante "
            + "from respuestas "
            + "where id_estudiante=?";

    public static final String INSERTAR_RESPUESTAS = "insert into respuestas( "
            + "pregunta,"
            + "respuesta,"
            + "id_estudiante) "
            + "values(?,?,?)";

}
