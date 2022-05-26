package nttdata.nttdata.javat1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdata.nttdata.javat1.game.Game;

/**
 * Clase principal donde se le hace un llamamiento a la clase Game.
 *
 */
public class App 
{
	
	private static Logger LOG = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args )
    {
    	LOG.info("INICIO DE EJECUCIÓN");
    	 Game juego = new Game();
    	LOG.info("FIN DE EJECUCIÓN"); 
    }
}
