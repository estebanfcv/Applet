package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author estebanfcv
 */
public class Util {

    public static boolean validarEmail(String email) {
        Pattern pattern;
        pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
