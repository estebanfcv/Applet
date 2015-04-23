package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author estebanfcv
 */
public class ConexionBD {

    private static Connection connection;

    public static void setConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://192.168.1.70/applet";
            String usuarioDB = "root";
            String passwordDB = "PassMysqlWord";
            connection = DriverManager.getConnection(servidor, usuarioDB, passwordDB);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void cerrarConexiones(ResultSet rs, PreparedStatement ps) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
