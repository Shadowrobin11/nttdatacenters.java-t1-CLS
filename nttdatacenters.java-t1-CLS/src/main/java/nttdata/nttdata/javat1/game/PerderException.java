package nttdata.nttdata.javat1.game;

/**
 * Creamos una excepción para los métodos de la bola.
 *
 */

public class PerderException extends Exception {

	private double puntuacion;

	//constructor
    public PerderException(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "¡Has perdido! tu puntuacion es: "+ puntuacion;
    }

    public double getPuntuacion() {
        return puntuacion;
    }
}
