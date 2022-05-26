package nttdata.nttdata.javat1.game;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdata.nttdata.javat1.App;

/**
 * Método de implementación bola donde se configurará los movimientos de la bola
 * y se creará el mapa en donde se jugará. 
 *
 */

public class Ball implements lowerRightCircle {
	
	private static Logger LOG = LoggerFactory.getLogger(App.class);
	
		// Atributo para ponerle color al texto
		public static final String ANSI_GREEN = "\u001B[32m";
	    public static final String ANSI_RESET = "\u001B[0m";

	    // creación del mapa junto con la puntuación
	    private final char[][] map = new char[10][11];
	    private double multiplicador;
	    private final int puntuacion = 100;
	    private final Random aleat = new Random();
	    private int score;
	    
	    public void puntuacion(){
	    	
	    	// método para multiplicar los puntos obtenidos
	        score += puntuacion*multiplicador;
	        multiplicador*=1.10;
	    }
	    
	    public Ball() {
	    	
	        // método bola para que ejecute el juego
	    	
	        multiplicador = 1;
	        
	        for (int i = 0; i < map.length ; i++) {
	            for (int j = 0; j < map[1].length ; j++) {
	                map[i][j]=' ';
	            }
	        }
	        
	        LOG.info("CREACION DEL MAPA");
	        // creación del mapa
	        mapMaking();
	    }

		private void mapMaking() {
			map[1][1] = '/';
	        map[1][9] ='\\' ;
	        map[4][3] = '/';
	        map[4][5] = '\\';
	        map[6][4] = 'O';
	        map[8][3] = '\\';
	        map[8][5] = '/';
	        
	        map[2][8] = '|';
	        map[3][8] = '|';
	        map[4][8] = '|';
	        map[5][8] = '|';
	        map[6][8] = '|';
	        map[7][8] = '|';
	        map[8][8] = '|';
	        
	        map[3][1] = 'O';
	        map[3][7] = 'O';
	        map[8][1] = 'O';
	        map[8][7] = 'O';
	        
	        for (int i = 0; i < map.length; i++) {
	            map[i][0] = '|';
	            map[i][map[1].length -1] = '|';
	            map[0][i+1] = '_';
	            map[map.length -1] [i] = '_';
	            
	        }
	        map [0][10] = '|';
		}
	    
	    /**
	     * Método donde se mostrará la zona de juego.
	     *
	     */
	    
	    public void showMap(){
	    	
	    	LOG.info("MOSTRANDO MAPA");
	        // mostrar el mapa
	        for (int i = 0; i < map.length ; i++) {
	            for (int j = 0; j < map[1].length ; j++) {
	                System.out.print(map[i][j]);
	            }
	            System.out.println("");
	        }
	    }
	    
	    
	    /**
	     * Método de lanzamiento de la bola al inicio de la partida.
	     * @throws PerderException
	     */
	    public void launching() throws PerderException{
	    	
	    	// movimientos
	    	LOG.info("LANZANDO BOLA");
	    	// lanzamiento de la bola y movimiento de la barra superior derecha
	        rightLaunch();
	    }

		private void rightLaunch() throws PerderException {
			for (int i = 8; i > 1; i--) {
	            method(i, 9);
	        }
	        leftLaunching();
		}
	    
	    /**
	     * Método para la barra superior izquierda para que baje la bola.
	     * @throws PerderException
	     */
	    
	    public void leftLaunching() throws PerderException{
	    	
	    	LOG.info("BARRA SUPERIOR IZQUIERDA");
	    	// movimiento estático de la bola de la barra superior izquierda
	    	leftLaunch();
	    }

		private void leftLaunch() throws PerderException {
			for (int i = 7; i > 1; i--) {
	            method(1, i);
	        }
	        method(2, 2);
	        puntuacion();
	        topLeftLaunch();
		}
	    
	    /**
	     * Método de la bola superior izquierda.
	     * @throws PerderException
	     */
	    
	    public void topLeftLaunch() throws PerderException{
	    	
	    	LOG.info("CIRCULO SUPERIOR IZQUIERDA");
	    	// circulo superior izquierda
	        topLeftCircle();
	    }

		private void topLeftCircle() throws PerderException {
			if (aleat.nextInt(50)< 25) {
	            for (int i = 2; i < 7; i++) {
	                method(3, i);
	            }
	            puntuacion();
	            topRightLaunch();
	        }else{
	            method(4,2);
	            method(5,1);
	            method(6,3);
	            puntuacion();
	            middleLaunch();
	        }
		}
	    
	    /**
	     * Método de la bola superior derecha.
	     * @throws PerderException
	     */
	    
	    public void topRightLaunch() throws PerderException{
	    	
	    	LOG.info("CIRCULO SUPERIOR DERECHA");
	    	// circulo superior derecha
	        topRightCircle();
	    }

		private void topRightCircle() throws PerderException {
			if(aleat.nextInt(50)< 25){
	            for (int i = 6; i > 2; i--) {
	                method(3, i);
	            }
	            puntuacion();
	            topLeftLaunch();
	        }else{
	            method(3,6);
	            method(4,7);
	            method(5,6);
	            method(6,5);
	            puntuacion();
	            middleLaunch();
	        }
		}
	    
	    /**
	     * Método de la bola central.
	     * @throws PerderException
	     */
	    
	    public void middleLaunch() throws PerderException{
	    	
	    	LOG.info("CIRCULO CENTRAL");
	    	// circulo central
	        centralCircle();
	    }

		private void centralCircle() throws PerderException {
			int ran = aleat.nextInt(100);
	        
	        if (ran < 20) { //vuelta a Ari 
	            method(6,3);
	            method(5,1);
	            method(4,2);
	            method(3,2);
	            puntuacion();
	            topLeftLaunch();
	        }else if(ran <40){ //vuelta a Alf 
	            method(8,2);
	            puntuacion();
	            lowerLeftLaunch();
	        }else if(ran <60){ //vuelta a Adri 
	            method(6,5);
	            method(5,6);
	            method(4,7);
	            method(3,6);
	            puntuacion();
	            topRightLaunch();
	        }else if(ran <80){ //vuelta a alb 
	            method(7,5);
	            method(8,6);
	            puntuacion();
	            lowerRightLaunch();
	        }else{
	            method(7,4);
	            method(8,4);
	            method(9,4);
	            throw new PerderException(score);
	        }
		}
	    
	    /**
	     * Método de la bola inferior izquierda.
	     * @throws PerderException
	     */
	    
	    public void lowerLeftLaunch() throws PerderException{
	    	
	    	LOG.info("CIRCULO INFERIOR IZQUIERDA");
	    	// circulo inferior izquierda
	        lowerLeftCircle();
	    }

		private void lowerLeftCircle() throws PerderException {
			if (aleat.nextInt(50)< 25) {
	            method(9,2);
	            throw new PerderException(score);
	        }else{
	            method(7,2);
	            method(6,3);
	            puntuacion();
	            middleLaunch();
	        }
		}
	    
	    /**
	     * Método de la bola inferior derecha.
	     * @throws PerderException
	     */
	    
	    public void lowerRightLaunch() throws PerderException{
	    	
	    	LOG.info("CIRCULO INFERIOR DERECHA");
	    	// circulo inferior derecha
	        lowerRightCircle();
	    }

		private void lowerRightCircle() throws PerderException {
			if (aleat.nextInt(50)< 25) {
	            method(9,6);
	            throw new PerderException(score);
	        }else{
	            method(7,6);
	            method(6,5);
	            puntuacion();
	            middleLaunch();
	        }
		}
	    
	    /**
	     * Método para la posición de la bola donde se genera y se elimina
	     * por cada una de las posiciones que pasa.
	     *
	     */
	    
	    public void method(int coor1, int coor2){
	    	
	    	// situación actual de la bola
	        coordinate(coor1, coor2);
	    }

		private void coordinate(int coor1, int coor2) {
			map[coor1][coor2] ='º';
	        showMap();
	        map[coor1][coor2] = ' ';
	        try{
	            Thread.sleep(500);
	        }catch (InterruptedException e){
	        }
	        System.out.println("Puntuacion acutal:"+ score);
		}
	    
	    /**
	     * Método de inicio del juego.
	     *
	     */

	    public void start(){
	    	
	    	LOG.info("INICIANDO JUEGO");
	    	
	    	// Texto de inicio
	    	
	        text();
	        
	    }

		private void text() {
			System.out.println(ANSI_GREEN +"I01010111 10100");
	        try{
	            Thread.sleep(100);
	        }catch (InterruptedException e){
	        }
	        System.out.println(ANSI_GREEN +"In1010101 01011");
	        try{
	            Thread.sleep(100);
	        }catch (InterruptedException e){
	        }
	        System.out.println(ANSI_GREEN +"Ini010100 10010");
	        try{
	            Thread.sleep(100);
	        }catch (InterruptedException e){
	        }
	        System.out.println(ANSI_GREEN +"Inic01011 10101");
	        try{
	            Thread.sleep(100);
	        }catch (InterruptedException e){
	        }
	        System.out.println(ANSI_GREEN +"Inici1000 01101");
	        try{
	            Thread.sleep(200);
	        }catch (InterruptedException e){
	        }
	        System.out.println(ANSI_GREEN +"Inicia101 10110");
	        try{
	            Thread.sleep(200);
	        }catch (InterruptedException e){
	        }
	        System.out.println(ANSI_GREEN +"Inician11 01010");
	        try{
	            Thread.sleep(200);
	        }catch (InterruptedException e){
	        }
	        System.out.println(ANSI_GREEN +"Iniciand0 11010");
	        try{
	            Thread.sleep(200);
	        }catch (InterruptedException e){
	        }
	        System.out.println(ANSI_GREEN +"Iniciando 01101");
	        try{
	            Thread.sleep(300);
	        }catch (InterruptedException e){
	        }
	        System.out.println(ANSI_GREEN +"Iniciando J1001");
	        try{
	            Thread.sleep(300);
	        }catch (InterruptedException e){
	        }
	        System.out.println(ANSI_GREEN +"Iniciando Ju011");
	        try{
	            Thread.sleep(300);
	        }catch (InterruptedException e){
	        }
	        System.out.println(ANSI_GREEN +"Iniciando Jue00");
	        try{
	            Thread.sleep(300);
	        }catch (InterruptedException e){
	        }
	        System.out.println(ANSI_GREEN +"Iniciando Jueg1");
	        try{
	            Thread.sleep(300);
	        }catch (InterruptedException e){
	        }
	        System.out.println(ANSI_GREEN +"Iniciando Juego" + ANSI_RESET);
	        try{
	            Thread.sleep(750);
	        }catch (InterruptedException e){
	        }
	        System.out.println(ANSI_GREEN +"Iniciando Juego." + ANSI_RESET);
	        try{
	            Thread.sleep(750);
	        }catch (InterruptedException e){
	        }
	        System.out.println(ANSI_GREEN +"Iniciando Juego.." + ANSI_RESET);
	        try{
	            Thread.sleep(750);
	        }catch (InterruptedException e){
	        }
	        System.out.println(ANSI_GREEN +"Iniciando Juego..." + ANSI_RESET);
	        try{
	            Thread.sleep(750);
	        }catch (InterruptedException e){
	        }
		}
}
