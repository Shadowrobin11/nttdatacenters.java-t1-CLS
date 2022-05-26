package nttdata.nttdata.javat1.game;

import java.io.FileWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdata.nttdata.javat1.App;

import java.io.IOException;
import java.util.Scanner;

/**
 * Método game donde llamará a las funciones de la bola
 * se iniciará el lanzamiento de la bola
 * y se guardará la puntuación en un fichero dentro de la 
 * carpeta del proyecto.
 *
 */

public class Game {
	private static Logger LOG = LoggerFactory.getLogger(App.class);
	private int score;
    
    private Ball bola;

    /**
     * Método para indicar la puntuación inicial,
     * y llamamiento de los demás métodos.
     *
     */
    
    public Game() {
    	
    	//creación de bola y llamamiento a los métodos de la clase
        this.score = 0;
        this.bola = new Ball();
        launchAndStart();
        guardarScore();
    }
    
    /**
     * Método para iniciar el lanzamiento de la bola
     * junto con la puntuación.
     *
     */
    
    public void launchAndStart(){
    	
    	// lamamiento de bola
        bola.start();
        try{
            bola.launching();
        }catch(PerderException e){
            System.out.println(e);
            score =(int)e.getPuntuacion();
        }
    }
        
    /**
     * Método para guardar la puntuación obtenida 
     * en el juego.
     *
     */
    
    public void guardarScore(){
    	
    	LOG.info("GUARDANDO PUNTUACIÓN");
    	// guardar puntuación obtenido en un archivo de texto
        Scanner sc = new Scanner(System.in);
        System.out.println("¡Enhorabuena, has sacado "+score+" escribe tu nombre:");
        String nombre = sc.nextLine();
        FileWriter fichero = null;
        try {
            fichero = new FileWriter("Puntuacion.txt",true);
            fichero.write("Puntuacion de "+nombre+ ": " + score + "\n");
        } catch (IOException ex) {
            System.out.println("Error al crear el fichero");
        } finally {
            try {
                fichero.flush();
                fichero.close();
            } catch (IOException ex) {
                System.out.println("Error E/S 2");
            }
        }
    }
}
