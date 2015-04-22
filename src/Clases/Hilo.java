package Clases;

import holamundo.Window;
import javax.swing.JApplet;

/**
 *
 * @author estebanfcv
 */
public class Hilo implements Runnable {

    private boolean corriendo = false;
    public int minutos = 0;
    public int segundos = 0;
    private Window window;

    public Hilo(Window window) {
        this.window = window;
    }

    @Override
    public void run() {
        corriendo = true;
        while (corriendo) {
            try {
                segundos++;
                if (segundos == 60) {
                    segundos = 0;
                    minutos++;
                }
                StringBuilder sMinutos = new StringBuilder(String.valueOf(minutos)).insert(0, String.valueOf(minutos).length() == 1 ? "0" : "");
                StringBuilder sSegindos = new StringBuilder(String.valueOf(segundos)).insert(0, String.valueOf(segundos).length() == 1 ? "0" : "");
                window.getJlMinutos().setText(sMinutos.toString());
                window.getJlSegundos().setText(sSegindos.toString());
                Thread.sleep(1000);
            } catch (Exception e) {
                corriendo = false;
            }

        }
    }

    public boolean isCorriendo() {
        return corriendo;
    }

    public void setCorriendo(boolean corriendo) {
        if (this != null) {
            this.corriendo = corriendo;
        }
    }

}
