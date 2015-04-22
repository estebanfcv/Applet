package Clases;

import holamundo.Window;

/**
 *
 * @author estebanfcv
 */
public class Hilo implements Runnable {

    private boolean corriendo = false;
    private int minutos = 0;
    private int segundos = 0;
    private final Window window;
    private boolean suspender = false;

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
                synchronized (this) {
                    while (suspender) {
                        wait();
                    }
                }
            } catch (Exception e) {
                corriendo = false;
            }
        }
    }

    public boolean isCorriendo() {
        return corriendo;
    }

    public void setCorriendo(boolean corriendo) {
        this.corriendo = corriendo;
    }

    public void suspenderHilo() {
        suspender = true;
    }

    public synchronized void reanudarHilo() {
        suspender = false;
        notify();
    }

}
